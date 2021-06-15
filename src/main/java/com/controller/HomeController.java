package com.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.entities.Comment;
import com.entities.Post;
import com.entities.User;
import com.modal.LoginModal;
import com.modal.PostModal;
import com.modal.PostUpdateModal;
import com.services.CommentServices;
import com.services.PostServices;
import com.services.UserServices;
import com.untils.NumberUntils;

@Controller
//@SessionAttributes("User")
public class HomeController {
	
	@Autowired
	UserServices userServices;
	
	@Autowired
	PostServices postServices;
	
	@Autowired
	CommentServices commentServices;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index(Model model) {
		List<Post> listPost = postServices.getTopNewPost();
		model.addAttribute("listPost", listPost);
		return "index";
	}
	
	@RequestMapping(path = "/contact", method = RequestMethod.GET)
	public String contact() {
		return "contact";
	}
	
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String displayLogin(Model model) { 
	    if(!model.containsAttribute("Usermodel")){
	    	model.addAttribute("Usermodel", new LoginModal()); 
	    }
	    return "login"; 
	}
	
//	,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String loginConfirm(ModelMap map, HttpSession session, @Valid @ModelAttribute("Usermodel")  LoginModal dto,BindingResult br) {
			if(br.hasErrors()){
				return "login";
			}else{
				User user=null;
				user=userServices.login(dto);
				if(user!=null) {
					map.addAttribute("User",user);
					session.setAttribute("User",user);
					return "redirect:/";
				}else {
					map.addAttribute("Error","Tài khoản hoặc mật khẩu không hơp lệ");
					return "login";
				}	
			}
			
	}
	
	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) { 
		User user=null;
		user=(User)session.getAttribute("User");
		if(user!=null){
			session.removeAttribute("User");
			System.out.println(user.toString());
				return "redirect:/";
		}
		return "redirect:/login";
	}

	@RequestMapping(path = "/about", method = RequestMethod.GET)
	public String about(Model model) { 
	    return "about"; 
	}

	
}
