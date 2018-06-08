package com.rose.service;

import java.util.List;

import com.rose.dao.BaseDictDao;
import com.rose.domain.BaseDict;

public interface BaseDictService {
	
	List<BaseDict> getListByTypeCode(String dict_type_code);
	
}
