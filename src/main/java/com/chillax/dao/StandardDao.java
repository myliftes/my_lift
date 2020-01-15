package com.chillax.dao;

import java.util.List;

import com.chillax.dto.Standard;

public interface StandardDao { 

	void  addStandard(Object areaOut);

	List<Standard> findByPage(Standard standard);

}
