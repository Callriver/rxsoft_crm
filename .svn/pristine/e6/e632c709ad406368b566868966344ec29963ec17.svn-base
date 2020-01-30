package com.rxsoft.crm.web.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.rxsoft.crm.bean.User;
import com.rxsoft.crm.service.UserService;
/**
 * 用户管理的Action类
 * @author lijunqiang
 *
 */
public class UserAction  extends ActionSupport implements ModelDriven<User>{
	//模型驱动使用的对象
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	//注入Service
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 用户注册的方法
	 */
	public String regist() {
		userService.regist(user);
		return "login";
	}
	/**
	 * 用户登录的方法
	 * @return
	 */
	public String login() {
		//调用业务层查询用户
		User existUser=userService.login(user);
		if (existUser==null) {
			//登录失败
			//添加错误信息
			this.addActionError("用户名或密码错误!");
			return "login";
		}else {
			//登录成功
			//ServletActionContext.getRequest().getSession().setAttribute(name, value);
			ActionContext.getContext().getSession().put("existUser", existUser);
			return "success";
		}
	}
}
