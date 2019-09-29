package bease;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
 
public class ListToModel {
    public static void main(String[] args) {
        List<Object> userList = new ArrayList<Object>();
        userList.add("tom");
        userList.add("男");
        userList.add(18);
        User user = new User();
        try {
            listToModel(userList, user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user.getName() + "; " + user.getGender() + "; " + user.getAge());
 
    }
    
    //把list内容逐个取出来放进User实体类中
    public static <T> void listToModel(List<Object> list, T t) throws Exception {
        Field[] fields = t.getClass().getDeclaredFields();
        if (list.size() != fields.length) {
            return;
        }
        for (int k = 0, len = fields.length; k < len; k++) {
            // 根据属性名称,找寻合适的set方法
            String fieldName = fields[k].getName();
            String setMethodName = "set" + fieldName.substring(0, 1).toUpperCase()+ fieldName.substring(1);
            
            Method method = null;
            Class<?> clazz = t.getClass();
            try {
            	Class<? extends Object> class66 = list.get(k).getClass();
            	System.out.println(class66);
            	
                method = clazz.getMethod(setMethodName, new Class[] { list.get(k).getClass() });
                System.out.println("list.get("+k+").getClass():"+list.get(k).getClass());
            } catch (SecurityException e1) {
                e1.printStackTrace();
                return;
            } catch (NoSuchMethodException e1) {
                String newMethodName = "set" + fieldName.substring(0, 1).toLowerCase()
                        + fieldName.substring(1);
                try {
                    method = clazz.getMethod(newMethodName, new Class[] { list.get(k).getClass() });
                } catch (SecurityException e) {
                    e.printStackTrace();
                    return;
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (method == null) {
                return;
            }
            method.invoke(t, new Object[] { list.get(k) });
        }
    }
}
class User{
	private String name;
	private String gender;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}