package com.chillax.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chillax.dto.Area;
import com.chillax.service.StandardService;

@Controller
@Resource
@ResponseBody
public class Standard {
	@Autowired
	private StandardService standardService;

	@RequestMapping("/standardAction_add")
	public String addstandard(Area area, HttpServletRequest request, Model model ,@RequestBody JSONObject obj ) {
		String data = obj.toJSONString();
		JSONObject json = JSON.parseObject(data);
		String createArr = json.getString("createArr");
		String modifyArr = json.getString("modifyArr");
		
		
		String name = request.getParameter("name");
		String minWeight = request.getParameter("minWeight");
		request.getParameterValues("minWeight");
		System.out.println("*****************这是前台输入的名字名字"+name+"这里是最小重量"+minWeight+"******************");
		area.setCitycode(name);
		 standardService.addstandard(area);

		return "SUCCESS";
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