package com.chillax.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.chillax.dto.Standard;

public interface StandardDao { 

	void  addStandard(Object areaOut);

	List<Standard> findByPage(Standard standard);

}
