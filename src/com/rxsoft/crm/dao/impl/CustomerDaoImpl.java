package com.rxsoft.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.rxsoft.crm.bean.Customer;
import com.rxsoft.crm.dao.CustomerDao;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao{

	@Override
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

	@Override
	/**
	 * 查询总数量
	 */
	public Integer findCount(DetachedCriteria criteria) {
		criteria.setProjection(Projections.rowCount());
		List<Long> list =(List<Long>) this.getHibernateTemplate().findByCriteria(criteria);
		if (list.size()>0) {
			return list.get(0).intValue();
		}
		return null;
	}

	@Override
	/**
	 * 分页查询客户结果集
	 */
	public List<Customer> findByPage(DetachedCriteria criteria, Integer begin, Integer pageSize) {
		criteria.setProjection(null);	//设置条件对象为空
		List<Customer> list = (List<Customer>)this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}
	
}
