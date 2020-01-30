package com.rxsoft.crm.service.impl;

import java.util.List;

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
	public PageBean<Customer> findByPage(DetachedCriteria criteria, Integer currPage,Integer pageSize) {
		PageBean<Customer> bean=new PageBean<Customer>();
		//封装当前页
		bean.setCurrPage(currPage);
		//封装每页显示的记录数
		bean.setPageSize(pageSize);
		//封装总记录数
		//调用DAO
		Integer totalCount = customerDao.findCount(criteria);
		bean.setTotalCount(totalCount);
		//封装总页数
		Double tc = totalCount.doubleValue();
		Double ceil = Math.ceil(tc/pageSize);
		bean.setTotalPage(ceil.intValue());
		//封装每页显示数据的集合
		Integer begin=(currPage-1)*pageSize;
		List<Customer> list = customerDao.findByPage(criteria,begin,pageSize);
		bean.setList(list);
		return bean;
	}
	
}
