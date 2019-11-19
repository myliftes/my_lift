package com.chillax.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.chillax.dto.Standard;

@Service
public interface StandardService {

	public void addstandard(Object standard);
 
	public List<Standard> findByPage(Standard standard, HttpServletRequest request, Model model);

}
