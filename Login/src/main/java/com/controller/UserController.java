package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.User;
import com.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	User user;

	@RequestMapping(value = "usersignin", method = RequestMethod.POST)
	public ModelAndView userLogin(HttpServletRequest req) { // DI for request object
		String emailid = req.getParameter("emailid");
		String password = req.getParameter("password");
		ModelAndView mav = new ModelAndView();
		user.setEmailid(emailid);
		user.setPassword(password);
		User loginUser=userService.loginUser(user);
		System.out.println(loginUser);
		System.out.println(user);
		if(loginUser!=null) {
			if(loginUser.getUsertyp().equalsIgnoreCase("Admin")) {
				mav.setViewName("Admin.jsp");
				return mav;
			}
			else if(loginUser.getUsertyp().equalsIgnoreCase("Customer")) {
				mav.setViewName("Customer.jsp");
				return mav;
			}
			else {
				mav.setViewName("login.jsp");
			}
				
		}
		

		return mav;
	}

	@RequestMapping(value = "usersignup", method = RequestMethod.GET)
	public ModelAndView gotoSignupPage(HttpServletRequest req) { // DI for request object
		ModelAndView mav = new ModelAndView();
		mav.setViewName("signup.jsp");

		return mav;
	}

	@RequestMapping(value = "usersignin", method = RequestMethod.GET)
	public ModelAndView gotoSignInPage(HttpServletRequest req) { // DI for request object
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login.jsp");

		return mav;
	}

	@RequestMapping(value = "usersignup", method = RequestMethod.POST)
	public ModelAndView createUser(HttpServletRequest req) { // DI for request object
		String emailid = req.getParameter("emailid");
		String password = req.getParameter("password");
		String usertyp = req.getParameter("usertype");
		user.setEmailid(emailid);
		user.setPassword(password);
		user.setUsertyp(usertyp);
		String msg = userService.createNewUser(user);
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName("signup.jsp");
		return mav;
	}

}
