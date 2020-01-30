package com.rxsoft.crm.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.rxsoft.crm.bean.User;
import com.rxsoft.crm.dao.UserDao;
import com.rxsoft.crm.service.UserService;
import com.rxsoft.crm.utils.MD5Utils;
@Transactional
public class UserServiceImpl implements UserService {
	//注入DAO
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	//业务层注册用户的方法
	public void regist(User user) {
		//对密码进行加密处理
		String password=MD5Utils.md5(user.getUser_password());
		user.setUser_password(password);
		user.setUser_state("1");
		userDao.save(user);
	}

	@Override
	//业务层用户登录的方法
	public User login(User user) {
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		return userDao.login(user);
	}
	
}
