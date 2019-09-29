package bease;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.chillax.dto.Area;

public class MapToBase {
	@SuppressWarnings("all")
	public static void main(String[] args) {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("id", 5);
		returnMap.put("city", "天水");
		returnMap.put("citycode", "first");
		 
		
        Area area = new Area();
        
        try {
        	
        	Area mapToBean = mapToBean(returnMap,area);
        	System.err.println("name:"+((Member) mapToBean).getName());
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(area.getId() + "; " + area.getCity() + "; " + area.getCitycode());
 
    }
    
    //把list内容逐个取出来放进User实体类中
	public static <T> T mapToBean(Map<String, Object> map, T class1) throws DiyExceetion, IllegalAccessException, IllegalArgumentException, InvocationTargetException
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
		            method.invoke(class1, new Object[] { mapValue });
				}
				else
				{
					System.out.println("mapKey:"+mapKey+"，为空");
				}
			}
        }
		return class1;
    }
}