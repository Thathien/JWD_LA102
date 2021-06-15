package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entities.User;
import com.impl.UserImpl;
import com.modal.LoginModal;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDao implements UserImpl {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	@Override
	public User login(LoginModal loginModal) {
		User user = null;
		Session session = sessionFactory.getCurrentSession();
		List<User> listUser = null;
		listUser = session.createQuery("from User where username=:user and password=:pass")
					      .setParameter("user", loginModal.getUsername())
					      .setParameter("pass", loginModal.getPassword())
					      .list();
		if (listUser != null && listUser.size() > 0) {
			user = listUser.get(0);
		}

		return user;
	}

}
