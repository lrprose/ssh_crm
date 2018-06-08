package com.rose.service.impl;

import java.util.List;

import com.rose.dao.BaseDictDao;
import com.rose.domain.BaseDict;
import com.rose.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {

	private BaseDictDao bdd;
	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		return bdd.getListByTypeCode(dict_type_code);
	}
	
	public void setBdd(BaseDictDao bdd) {
		this.bdd = bdd;
	}

}
