package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.entities.Comment;
import com.entities.User;
import com.services.CommentServices;
import com.services.PostServices;
import com.services.UserServices;
import com.untils.NumberUntils;

@Controller
public class CommentController {
	
	@Autowired
	UserServices userServices;
	
	@Autowired
	PostServices postServices;
	
	@Autowired
	CommentServices commentServices;
	
	
//	@GetMapping("/commentmm")
//	public String commentmm(HttpSession session,ModelMap map){
//		User user= null;
//		user=(User) session.getAttribute("User");
//		if(user!=null){
//			List<Comment> listCommnet=commentServices.getListCommentBiIDUser(user.getIdUser());
//			map.addAttribute("listCommnet", listCommnet);
//			return "commentmm";
//		}
//		return "redirect:/login";
//	}
	
	@GetMapping("/comment/{id}")
	public String getListComm(@PathVariable("id") String id,HttpSession session,ModelMap map) {
		User user= null;
		user=(User) session.getAttribute("User");
		if(user!=null && NumberUntils.isNumm(id)){
			List<Comment> listCommnet=commentServices.getListCommentByIDPost(Integer.parseInt(id));
			map.addAttribute("listCommnet", listCommnet);
			return "commentmm";
//			return "redirect:/comment/"+id;	
		}
		return "redirect:/login";
		
	}
	
	@GetMapping("deletecomment/{id}")
	public String deletecomment(@PathVariable("id") String id, ModelMap map) {
		if(id!=null && NumberUntils.isNumm(id)){
			Comment comm=null;
			comm=commentServices.getById(Integer.parseInt(id));
			if(comm!=null) {
				boolean temp=commentServices.deleteCommend(Integer.parseInt(id));
//				return "redirect:/commentmm";
				return "redirect:/comment/"+id;	
			}
		}
		return "redirect:/";
	}
	@GetMapping("aprovecomment/{id}")
	public String aprovecomment(@PathVariable("id") String id, ModelMap map) {
		if(id!=null && NumberUntils.isNumm(id)){
			Comment comm=null;
			comm=commentServices.getById(Integer.parseInt(id));
			if(comm!=null) {
				commentServices.ApproveCommend(Integer.parseInt(id));
//				return "redirect:/commentmm";
				return "redirect:/comment/"+id;	
			}
		}
		return "redirect:/";
	}

}
