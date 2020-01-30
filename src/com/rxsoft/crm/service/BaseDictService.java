package com.rxsoft.crm.service;

import java.util.List;

import com.rxsoft.crm.bean.BaseDict;

public interface BaseDictService {

	List<BaseDict> findByTypeCode(String dict_type_code);
	
}
