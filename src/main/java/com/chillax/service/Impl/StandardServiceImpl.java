package com.chillax.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chillax.dao.StandardDao;
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
}
