package com.rxsoft.crm.service;

import com.rxsoft.crm.bean.User;

public interface UserService {

	void regist(User user);

	User login(User user);

}
