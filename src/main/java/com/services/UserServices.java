package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.entities.User;
import com.impl.UserImpl;
import com.modal.LoginModal;

@Service
public class UserServices implements UserImpl {

	@Autowired
	@Qualifier("userDao")
	UserDao userDao;

	public User login(LoginModal loginModal) {
		// TODO Auto-generated method stub
		return userDao.login(loginModal);
	}

}
