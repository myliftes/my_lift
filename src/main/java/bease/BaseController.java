package bease;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


@SuppressWarnings("all")
public abstract class BaseController<T> 
{
	/**
	 * 返回map
	 * @param Map<String, String[]
	 * @return Map<String, Object>
	 * 转换map类
	 */
	public  Map<String, Object>  getMap(Map<String, String[]> properties) 
	{
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Iterator<Entry<String, String[]>> iter = properties.entrySet().iterator();
		String name = "";
		String value = "";
		while (iter.hasNext()) 
		{
		    Entry<String, String[]> entry = iter.next();
		    name = entry.getKey();
		    Object valueObj = entry.getValue();
		    if (null == valueObj) 
		    {
		        value = "";
		    } 
		    else if (valueObj instanceof String[]) 
		    {
		        String[] values = (String[]) valueObj;
		        for (int i = 0; i < values.length; i++)  //用于请求参数中有多个相同名称
		        {
		            value = values[i] + ",";
		        }
		        value = value.substring(0, value.length() - 1);
		    } 
		    else 
		    {
		        value = valueObj.toString();//用于请求参数中请求参数名唯一
		    }
		    returnMap.put(name, value);
		}
		return returnMap;
	}
	
	/**
	 * 
	 * @param map
	 * @param class1
	 * @return
	 * @throws DiyExceetion
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * 将map转换为实体类
	 */
	public  <T> T mapToBean(Map<String, Object> map, T class1) throws DiyExceetion, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Field[] fields = class1.getClass().getDeclaredFields();
		//非空校验
        if (0 == fields.length || 0==map.size()) {
        	throw new DiyExceetion("传入的实体类或map为空",-1);
        }

        Class<?> clazz;
        String fieldName ="";
        String mapKey ="";
        Object mapValue ="";
        Method method = null;
        String setMethodName ="";
        
        for(Entry<String, Object> str : map.entrySet())//便利map
        {
	        for (int k = 0, len = fields.length; k < len; k++) //便利实体类数组
	        {
	        	//根据属性名称,找寻合适的set方法
	            fieldName = fields[k].getName();
	            setMethodName = "set" + fieldName.substring(0, 1).toUpperCase()+ fieldName.substring(1).toLowerCase();
	            clazz = class1.getClass();
            	//获取map中的内容
	            mapKey=str.getKey();
				if(fieldName.equals(mapKey))
			   {
					//若key为id则将时间戳带入
					if(!"id".equals(mapKey.toLowerCase())) {
						mapValue = str.getValue();
					}else {
						mapValue=(int) (System.currentTimeMillis() / 1000);
						System.out.println("给ID赋值为:【"+mapValue+"】");
					}
			   }
				else //若是一个循环后仍未找到对应说明map中混入了不属于实体类的内容
			   {
					if (k==fields.length) 
					{
						throw new DiyExceetion("传入的实体类:"+class1.getClass()+"实体子段名"+fieldName+"与传入的map内容不对应",-1);
					}
					continue;
			   }
				if("" != mapValue.toString().trim())
				{
				 try {
		                method = clazz.getMethod(setMethodName, new Class[] { mapValue.getClass() });
		                System.out.println(" 实体类:【"+fieldName+"】的value【"+mapValue+"】");
		            } catch (SecurityException e1) {
		                e1.printStackTrace();
		                //return;
		            } catch (NoSuchMethodException e1) {
		                String newMethodName = "set" + fieldName.substring(0, 1).toLowerCase()
		                        + fieldName.substring(1).toLowerCase();
		                try { 
		                    method = clazz.getMethod(newMethodName, new Class[] { mapValue.getClass() });
		                } catch (SecurityException e) {
		                    e.printStackTrace();
		                } catch (NoSuchMethodException e) {
		                    e.printStackTrace();
		                }
		            }
		            if (method == null) {
		            	throw new DiyExceetion("method为空",-1);
		            }
		            method.invoke(class1, new Object[] { mapValue });
				}
			}
        }
		return class1;
    }
	
	/**
	 * 
	 * @return time
	 */
	public Integer getTime()
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Integer seconds = (int) (System.currentTimeMillis() / 1000);
		return seconds;
	}
}
