package com.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entities.Post;
import com.entities.User;
import com.modal.PostModal;
import com.modal.PostUpdateModal;
import com.services.CommentServices;
import com.services.PostServices;
import com.services.UserServices;
import com.untils.NumberUntils;

@Controller
public class PostController {
	@Autowired
	UserServices userServices;
	
	@Autowired
	PostServices postServices;
	
	@Autowired
	CommentServices commentServices;
	
	@RequestMapping(path = "/addpost", method = RequestMethod.GET)
	public String createpost(Model model,HttpSession session) {
		User user= null;
		user=(User) session.getAttribute("User");
		if(user!=null){
			model.addAttribute("PostModal", new PostModal());
			return "addpost";
		}
		return "redirect:/login";
	}
	
	@RequestMapping(path = "/addpost", method = RequestMethod.POST)
	public String createposts( ModelMap map,HttpSession session,@Valid @ModelAttribute("PostModal") PostModal postModal,BindingResult br) {
		if(br.hasErrors()){
			return "addpost";
		}else{
			User user= null;
			user=(User) session.getAttribute("User");
			if(user!=null){
				Post post= new Post();
				post.setContent(postModal.getContent());
				post.setTags(postModal.getTags());
				post.setTitle(postModal.getTitle());
				post.setStatus(postModal.getStatus());
				post.setUser(user);
				post.setCreateTime(new Date());
				post.setUpdateTime(new Date());
				boolean temp=postServices.add(post);
				return "redirect:/";
			}
			return "redirect:/login";
		}
	}
	
	@RequestMapping(path = "/postmm", method = RequestMethod.GET)
	public String postMM(HttpSession session,Model map) { 
		User user=null;
		user=(User)session.getAttribute("User");
		if(user!=null){
			List<Post> listPostUser=postServices.getAllListByIDAcc(user.getIdUser());
			map.addAttribute("listPostUser", listPostUser);
			return "postmm"; 
		}
		return "redirect:/login";
	    
	}
	@RequestMapping(path = "/edit/updatepost", method = RequestMethod.POST)
	public String updatepost(HttpSession session,ModelMap map,@Valid @ModelAttribute("PostModalUpdate")PostUpdateModal postUpdateModals ,BindingResult br) {
//		if(br.hasErrors()){
//			return "forward:/edit/"+postUpdateModals.getId();	
//		}else{
//		User user= null;
//			user=(User) session.getAttribute("User");
//			System.out.println(postUpdateModals.toString());
//			if(user!=null){
//				Post post= new Post();
//				post.setIdPost(Integer.parseInt(postUpdateModals.getId()));
//				post.setContent(postUpdateModals.getContent());
//				post.setTags(postUpdateModals.getTags());
//				post.setTitle(postUpdateModals.getTitle());
//				post.setStatus(postUpdateModals.getStatus());
//				post.setUser(user);
//				post.setCreateTime(new Date());
//				post.setUpdateTime(new Date());
//				boolean temp=postServices.update(post);
//				
//				return "redirect:/postmm";
//			}
//			return "redirect:/login";
//		}
		
		User user= null;
		user=(User) session.getAttribute("User");
		System.out.println(postUpdateModals.toString());
		if(user!=null){
			Post post= new Post();
			post.setIdPost(Integer.parseInt(postUpdateModals.getId()));
			post.setContent(postUpdateModals.getContent());
			post.setTags(postUpdateModals.getTags());
			post.setTitle(postUpdateModals.getTitle());
			post.setStatus(postUpdateModals.getStatus());
			post.setUser(user);
			post.setCreateTime(new Date());
			post.setUpdateTime(new Date());
			boolean temp=postServices.update(post);
			
			return "redirect:/postmm";
		}
		return "redirect:/login";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") String id, ModelMap map) {
		if(id!=null && NumberUntils.isNumm(id)){
			int idPost=Integer.parseInt(id);
			Post post=null;
			post=postServices.getById(idPost);
			if(post!=null) {
				boolean temp=postServices.delete(post);
				return "redirect:/postmm";
			}
		}
		return "redirect:/";
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap map) {
		if(id!=null && NumberUntils.isNumm(id)){
			int idPost=Integer.parseInt(id);
			Post post=null;
			post=postServices.getById(idPost);
			if(post!=null) {
				map.addAttribute("PostModalUpdate", new PostUpdateModal());
				map.addAttribute("postEdit", post);
				return "editpost";
			}
		}
		return "redirect:/";
	}
	
}
