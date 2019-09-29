package com.chillax.controller;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
//这里不能引入对象
//import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.chillax.dto.Area;
import com.chillax.service.StandardService;

import bease.BaseController;
import bease.DiyExceetion;

@SuppressWarnings("all")
@Controller
@Resource
@ResponseBody
public class Standard extends BaseController{
	@Autowired
	private StandardService standardService;
	Object areaOut;
	@SuppressWarnings("unchecked")
	@RequestMapping("/standardAction_add")
	public JSONObject addstandard (Area area, HttpServletRequest request, Model model ) throws InstantiationException, IllegalAccessException, InvocationTargetException
	{
		//转换Map格式
	 
		Map<String, Object> map = getMap(request.getParameterMap());
		for(Entry<String, Object> entry:map.entrySet()){
			System.out.println("key="+entry.getKey()+"\tvalue="+entry.getValue());
		}
		
		try {
			Integer seconds = (int) (System.currentTimeMillis() / 1000);
			
			//map.put("id",  (int) System.currentTimeMillis() / 1000);
			areaOut = mapToBean(map,area);
			
		} catch (IllegalArgumentException | DiyExceetion e) {
			System.out.println("test-----fail");
			e.printStackTrace();
		}

		JSONObject jsonObject = new JSONObject();
		
		try {
			standardService.addstandard(areaOut);
			jsonObject.put("success", "success");
			
		} catch (Exception e) {
			jsonObject.put("fail", "fail");
		}
		return jsonObject;
	} 
	
	private  Class<?> getClassforme(Class<?> cls,Map<String, Object>returnMap) {
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
	
	//map装bean
	public static <T> T mapToObject(Map<String,Object> map,Class<T> clz) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		//创建JavaBean对象
		T obj = null;
		try {
			obj = clz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取指定类的BeanInfo对象
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(clz, Object.class);
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取所有的属性描述器
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for(PropertyDescriptor pd:pds){
			Object value = map.get(pd.getName());
			Method setter = pd.getWriteMethod();
			setter.invoke(obj, value);
		}
		return  obj;
	}
}

/*	if (StringUtils.isNullOrEmpty(createArr)) {
			JSONArray createArray = JSONArray.parseArray(createArr);
			for (int i = 0; i < createArray.size(); i++) {
				Integer tempId = JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getInteger("id");
				String name = JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getString("name");
				String minWeight = JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getString("minWeight");
				String maxWeight = JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getString("maxWeight");
				String minLength = JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getString("minLength");
				String maxLength = JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getString("maxLength");
				// 创建热门搜索对象
				Area area1 = new Area();
				area1.setId(tempId);
				area1.setCitycode(minWeight);
				area1.setDistrict(maxWeight);
				area1.setCity(minLength);
				area1.setProvince(maxLength);
				// area1.setCreateDate(new Date());
				// area1.setDelFlag("0");
				// 添加热门搜索信息
				// countAddHotSearch = hotSearchService.addHotSearchSelective(hotSearch);
			} 
		}*/