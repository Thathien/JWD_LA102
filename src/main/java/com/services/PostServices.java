package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dao.PostDao;
import com.entities.Post;
import com.impl.PostImpl;

@Service
public class PostServices implements PostImpl{
	
	@Autowired
	@Qualifier("postDao")
	PostDao postDao;

	@Override
	public boolean add(Post post) {
		// TODO Auto-generated method stub
		return postDao.add(post);
	}

	@Override
	public boolean update(Post post) {
		// TODO Auto-generated method stub
		return postDao.update(post);
	}

	@Override
	public boolean delete(List<Integer> list) {
		// TODO Auto-generated method stub
		return postDao.delete(list);
	}

	@Override
	public Post getById(int id) {
		// TODO Auto-generated method stub
		return postDao.getById(id);
	}

	@Override
	public boolean publishedPost(int id) {
		// TODO Auto-generated method stub
		return postDao.publishedPost(id);
	}

	@Override
	public boolean unPublishedPost(int id) {
		// TODO Auto-generated method stub
		return postDao.unPublishedPost(id);
	}

	@Override
	public List<Post> getAllList() {
		// TODO Auto-generated method stub
		return postDao.getAllList();
	}

	@Override
	public boolean delete(Post post) {
		// TODO Auto-generated method stub
		return postDao.delete(post);
	}

	@Override
	public List<Post> getAllListByIDAcc(int id) {
		// TODO Auto-generated method stub
		return postDao.getAllListByIDAcc (id);
	}

	@Override
	public List<Post> getTopNewPost() {
		// TODO Auto-generated method stub
		return postDao.getTopNewPost();
	}

}
