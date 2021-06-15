package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dao.CommentDao;
import com.entities.Comment;
import com.impl.CommentImpl;

@Service
public class CommentServices implements CommentImpl{
	
	@Autowired
	@Qualifier("commentDao")
	CommentDao commentDao;

	@Override
	public boolean add(Comment comment) {
		// TODO Auto-generated method stub
		return commentDao.add(comment);
	}

	@Override
	public void ApproveCommend(List<Integer> listComent) {
		commentDao.ApproveCommend(listComent);
		
	}

	@Override
	public boolean deleteCommend(List<Integer> listComent) {
		// TODO Auto-generated method stub
		return commentDao.deleteCommend(listComent);
	}

	@Override
	public void ApproveCommend(int id) {
		// TODO Auto-generated method stub
		commentDao.ApproveCommend(id);
	}

	@Override
	public boolean deleteCommend(int id) {
		// TODO Auto-generated method stub
		return commentDao.deleteCommend(id);
	}

	@Override
	public Comment getById(int id) {
		// TODO Auto-generated method stub
		return commentDao.getById(id);
	}

	@Override
	public List<Comment> getListCommentByIDPost(int id) {
		// TODO Auto-generated method stub
		return commentDao.getListCommentByIDPost(id);
	}

	@Override
	public List<Comment> getListCommentBiIDUser(int id) {
		// TODO Auto-generated method stub
		return commentDao.getListCommentBiIDUser(id);
	}

}
