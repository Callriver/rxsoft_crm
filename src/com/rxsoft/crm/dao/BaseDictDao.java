package com.rxsoft.crm.dao;

import java.util.List;

import com.rxsoft.crm.bean.BaseDict;

public interface BaseDictDao {

	List<BaseDict> findByTypeCode(String dict_type_code);

}
