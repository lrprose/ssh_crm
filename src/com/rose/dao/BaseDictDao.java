package com.rose.dao;

import java.util.List;

import com.rose.domain.BaseDict;

public interface BaseDictDao extends BaseDao<BaseDict> {

	List<BaseDict> getListByTypeCode(String dict_type_code);

}
