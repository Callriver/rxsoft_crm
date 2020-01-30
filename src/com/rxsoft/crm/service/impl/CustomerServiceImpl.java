package com.rxsoft.crm.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.rxsoft.crm.bean.Customer;
import com.rxsoft.crm.bean.PageBean;
import com.rxsoft.crm.dao.CustomerDao;
import com.rxsoft.crm.service.CustomerService;
@Transactional
public class CustomerServiceImpl implements CustomerService{
	//注入持久层对象
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
	}
	/**
	 * 根据页数查数据
	 */
	@Override
	public PageBean<Customer> findByPage(DetachedCriteria criteria, Integer currPage) {
		PageBean<Customer> bean=new PageBean<Customer>();
		return null;
	}
	
}
