package com.chillax.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.formula.functions.T;
//这里不能引入对象
//import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chillax.dto.Standard;
import com.chillax.service.StandardService;
import com.sun.mail.iap.Response;

import bease.BaseController;
import bease.DiyExceetion;

@SuppressWarnings("all")
@Controller
@Resource
@ResponseBody
public class StandardController extends BaseController {
	@Autowired
	private StandardService standardService;
	Object standardOut;

	// start 取派标准数据添加
	@RequestMapping("/standardAction_add")
	public JSONObject addstandard(Standard standard, HttpServletRequest request, Model model)
			throws InstantiationException, IllegalAccessException, InvocationTargetException {
		JSONObject jsonObject = new JSONObject();
		try {
			if (null == standard.getId() || "" == standard.getId().toString().trim()) {
				standard.setId(getTime());
			}
			System.out.println("传入的内容是" + standard.toString());
			standardService.addstandard(standard);
			jsonObject.put("success", "success");
		} catch (Exception e) {
			jsonObject.put("error", "error");
			System.out.println("json内容：" + jsonObject.toString());
			jsonObject.clear();
			System.out.println("clear后的json内容：" + jsonObject.toString());
			jsonObject.put("error", "error");
		}
		return jsonObject;
	}
	// end

	//start取派标准的查询
	@RequestMapping("/standardAction_findByPage")
	public List<Standard> findByPage(Standard standard, HttpServletRequest request, Model model)
			throws InstantiationException, IllegalAccessException, InvocationTargetException, DiyExceetion {
		JSONObject jsonObject = new JSONObject();
		List<Standard>standardList = null;
		System.out.println("standrad类："+standard);
		try {
			//调用查询后台
			standardList = standardService.findByPage(standard, request, model);
			if (standardList.isEmpty()) {
				throw new DiyExceetion("查询数据为空", 0);
			}
			System.out.println("standardList" + standardList.toString());
//			for (Standard aa : standardList) {
//				standard.get
//			}
//			jsonObject.putAll(standardMap);
			//			for (Entry<String, String> entry : ((JSONObject) standardMap).entrySet()) {
//				System.out.println("返回的查询类key=" + entry.getKey() + "\t 值value=" + entry.getValue());
//				jsonObject.put(entry.getKey(), entry.getValue());
//			}
			System.out.println("jsonObject内容" + jsonObject.toString());
			
		} catch (Exception e) {
			System.out.println("调用后台发生异常");
			e.printStackTrace();
			//throw new DiyExceetion("调用后台发生异常", 0);
		}
		return standardList;
	}
	//end
	
	//start 测试类
	
	public JSONObject test(Standard standard, HttpServletRequest request, Model model)
			throws InstantiationException, IllegalAccessException, InvocationTargetException {
		// 第一种方式使用实体类接收数据,实现方式不明
		System.out.println("standard内容:" + standard.toString());
		// 第二种方式使用model接收数据,实现方式不明,内容与实体类相同
		System.out.println("model内容:" + model.toString());
		// 第三种方式使用serverlet获取单个字段
		standard.setId(Integer.valueOf(request.getParameter("id")));
		standard.setMaxLength(Double.valueOf(request.getParameter("maxLength")));
		// 第四种方式使用servicelet获取map
		Map<String, Object> map = getMap(request.getParameterMap());
		for (Entry<String, Object> entry : map.entrySet()) {
			System.out.println("key=" + entry.getKey() + "\tvalue=" + entry.getValue());
		}
		try {
			Integer seconds = (int) (System.currentTimeMillis() / 1000);
			Object standardOut = mapToBean(map, standard);

		} catch (IllegalArgumentException | DiyExceetion e) {
			System.out.println("test-----fail");
			e.printStackTrace();
		}

		JSONObject jsonObject = new JSONObject();

		try {
			standardService.addstandard(standardOut);
			jsonObject.put("success", "success");

		} catch (Exception e) {
			jsonObject.put("error", "error");
		}
		return jsonObject;
	}
	//end
	
}