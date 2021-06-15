package com.impl;

import java.util.List;

import com.entities.Post;

public interface PostImpl {
	public boolean add(Post post);
	public boolean update(Post post);
	public boolean delete(Post post);
	public boolean delete(List<Integer> list);
	public Post getById(int id);
	public boolean publishedPost(int id);
	public boolean unPublishedPost(int id);
	List<Post> getAllList();
	List<Post> getAllListByIDAcc(int id);
	List<Post> getTopNewPost();
}
