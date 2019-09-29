package bease;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;


public abstract class BaseController<T> 
{
	/**
	 * 对传入的实体类和map赋值并返回
	 * @param cls
	 * @param properties
	 * @return 赋值的实体类
	 */
	public  Class<?>  getBean(Class<?> cls, Map<String, String[]> properties) 
	{ 
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Iterator<Entry<String, String[]>> iter = properties.entrySet().iterator();
		String name = "";
		String value = "";
		while (iter.hasNext()) {
		    Entry<String, String[]> entry = iter.next();
		    name = entry.getKey();
		    Object valueObj = entry.getValue();
		    if (null == valueObj) {
		        value = "";
		    } else if (valueObj instanceof String[]) {
		        String[] values = (String[]) valueObj;
		        for (int i = 0; i < values.length; i++) { //用于请求参数中有多个相同名称
		            value = values[i] + ",";
		        }
		        value = value.substring(0, value.length() - 1);
		    } else {
		        value = valueObj.toString();//用于请求参数中请求参数名唯一
		    }
		    returnMap.put(name, value);
		}
		
		
		Iterator iterMap = returnMap.entrySet().iterator(); 
		  while (iterMap.hasNext()) {
		   Map.Entry entry = (Map.Entry) iterMap.next();
		   PropertyDescriptor pd = org.springframework.beans.BeanUtils.getPropertyDescriptor(cls, entry.getKey().toString());
		   if (pd == null || pd.equals("")) {
		    throw new RuntimeException("输入的"+pd+"要修改的"+entry.getKey().toString()+"属性与实体属性不匹配");
		   }
		   try {
			BeanUtils.setProperty(cls, (String) entry.getKey(),entry.getValue());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  }
		//返回赋值后的实体类
		return cls;
	}
	
	/**
	 * 返回map
	 * @param Map<String, String[]
	 * @return Map<String, Object>
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
	 * map装换为bean  
	 * 
	 * @param map bean
	 * @return bean
	 * @throws DiyExceetion 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public Class<?> mapToBean(Map<String, Object> map, Class<T> cla) throws DiyExceetion, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Field[] fields = cla.getClass().getDeclaredFields();
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
	            clazz = cla.getClass();
            	//获取map中的内容
	            mapKey=str.getKey();
				if(fieldName.equals(mapKey))
			   {
					mapValue = str.getValue();
			   }
				else //若是一个循环后仍未找到对应说明map中混入了不属于实体类的内容
			   {
					if (k==fields.length) 
					{
						throw new DiyExceetion("传入的实体类:"+cla.getName()+"与传入的map内容不对应",-1);
					}
					continue;
			   }
				if("" != mapValue.toString().trim())
				{
					
				 try {
		                method = clazz.getMethod(setMethodName, new Class[] { mapValue.getClass() });
		                System.out.println("map中的value("+mapValue+"，getClass():"+mapValue.getClass());
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
		                   // return;
		                } catch (NoSuchMethodException e) {
		                    e.printStackTrace();
		                    //return;
		                }
		            }
		            if (method == null) {
		            	throw new DiyExceetion("method为空",-1);
		            	//return;
		            }
		            method.invoke(cla, new Object[] { mapValue });
				}
			}
        }
		return cla;
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
	 */
	public  <T> T mapToBean2(Map<String, Object> map, T class1) throws DiyExceetion, IllegalAccessException, IllegalArgumentException, InvocationTargetException
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
					mapValue = str.getValue();
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
		                System.out.println("map中的value("+mapValue+"，getClass():"+mapValue.getClass());
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
