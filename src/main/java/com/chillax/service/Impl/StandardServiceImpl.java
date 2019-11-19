package com.chillax.service.Impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.chillax.dao.StandardDao;
import com.chillax.dto.Standard;
import com.chillax.service.StandardService; 

@Service
public class StandardServiceImpl implements StandardService{

	@Autowired 
	private StandardDao standardDao;
	@Override
	public void addstandard(Object areaOut) {
		standardDao.addStandard(areaOut); 
		return;
	}
	@Override
	public List<Standard> findByPage(Standard standard, HttpServletRequest request, Model model) {
		List<Standard> standatdList = standardDao.findByPage(standard);
		return standatdList;
	} 
}
