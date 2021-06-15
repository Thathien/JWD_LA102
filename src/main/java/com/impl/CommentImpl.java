package com.impl;

import java.util.List;

import com.entities.Comment;

public interface CommentImpl {
	public boolean add(Comment comment);
	public void ApproveCommend(List<Integer> listComent);
	public void ApproveCommend(int id);
	public boolean deleteCommend(List<Integer> listComent);
	public boolean deleteCommend(int id);
	public Comment getById(int id);
	public List<Comment> getListCommentByIDPost(int id);
	public List<Comment> getListCommentBiIDUser(int id);
}
