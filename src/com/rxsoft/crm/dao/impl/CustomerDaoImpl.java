package com.rxsoft.crm.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.rxsoft.crm.bean.Customer;
import com.rxsoft.crm.dao.CustomerDao;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao{

	@Override
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}
	
}
