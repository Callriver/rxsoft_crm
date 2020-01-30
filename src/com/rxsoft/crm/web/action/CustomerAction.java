package com.rxsoft.crm.web.action;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.rxsoft.crm.bean.Customer;
import com.rxsoft.crm.bean.PageBean;
import com.rxsoft.crm.bean.User;
import com.rxsoft.crm.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	//模型驱动使用的对象
	private Customer customer=new Customer();

	@Override
	public Customer getModel() {
		return customer;
	}
	
	//注入业务层对象
	CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	//使用set方法的方式接收数据
	private Integer currPage=1;
	//每页显示数量
	private Integer pageSize=3;
	
	public void setCurrPage(Integer currPage) {
		if (currPage==null) {
			currPage = 1;
		}
		this.currPage = currPage;
	}
	
	
	public void setPageSize(Integer pageSize) {
		if (pageSize==null) {
			pageSize = 3;
		}
		this.pageSize = pageSize;
	}


	/**
	 * 客户管理:跳转到添加客户页面
	 */
	public String saveUI() {
		return "saveUI";
	}
	/**
	 * 保存客户
	 * @return
	 */
	public String save() {
		customerService.save(customer);
		return "findAll";
	}
	/**
	 * 分页查询客户
	 * @return
	 */
	public String findAll() {
		//接收分页参数
		//最好使用DetachedCriteria对象(条件查询 带分页)
		DetachedCriteria criteria=DetachedCriteria.forClass(Customer.class);
		PageBean<Customer> pageBean = customerService.findByPage(criteria,currPage,pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	

}
