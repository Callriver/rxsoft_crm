package com.rxsoft.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import com.rxsoft.crm.bean.Customer;
import com.rxsoft.crm.bean.PageBean;

public interface CustomerService {

	void save(Customer customer);

	PageBean<Customer> findByPage(DetachedCriteria criteria, Integer currPage);
	
}
