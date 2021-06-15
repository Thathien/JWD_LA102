package com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entities.Post;
import com.entities.User;
import com.impl.PostImpl;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PostDao implements PostImpl{
	@Autowired
	SessionFactory sessionFactory;


	@Override
	@Transactional
	public boolean add(Post post) {
		Session session = null;
		try {
			session=sessionFactory.getCurrentSession();
			session.save(post);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	@Transactional
	public boolean update(Post post) {
		Session session = null;
		try {
			session=sessionFactory.getCurrentSession();
			session.update(post);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	@Transactional
	public boolean delete(Post post) {
		Session session = null;
		try {
			session=sessionFactory.getCurrentSession();
			session.delete(post);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@Override
	@Transactional
	public boolean delete(List<Integer> list) {
//		if(!list.isEmpty() && list.size()>0){
//			Post post=null;
//			for (Integer integer : list) {
//				post=getById(integer);
//				if(post!=null){
//					
//				}
//			}
//		}
			return false;
	}

	@Override
	@Transactional
	public Post getById(int id) {
		Post post=null;
		Session session = null;
		session=sessionFactory.getCurrentSession();
		post=(Post) session.get(Post.class,id);
		return post;
		
	}

	@Override
	@Transactional
	public boolean publishedPost(int id) {
		Session session = null;
		session=sessionFactory.getCurrentSession();
		int kq=session.createQuery("update Post set status=active where id=:id").setParameter("id", id).executeUpdate();
		if(kq>0){
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean unPublishedPost(int id) {
		Session session = null;
		session=sessionFactory.getCurrentSession();
		int kq=session.createQuery("update Post set status=unactive where id=:id").setParameter("id", id).executeUpdate();
		if(kq>0){
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public List<Post> getAllList() {
		Session session = null;
		session=sessionFactory.getCurrentSession();
		List<Post> posts=null;
		posts=session.createQuery("from Post").list();
		return posts;
	}

	@Override
	@Transactional
	public List<Post> getAllListByIDAcc(int id) {
		List<Post> posts=null;
		Session session = null;
		session=sessionFactory.getCurrentSession();
		posts=session.createQuery("from Post  where author_id=:id")
									.setParameter("id", id).list();
		return posts;
	}

	@Override
	@Transactional
	public List<Post> getTopNewPost() {
		Session session = null;
		session=sessionFactory.getCurrentSession();
		List<Post> posts=session.createQuery("from Post order by updateTime DESC").setMaxResults(2).list();
		return posts;
	}

}
