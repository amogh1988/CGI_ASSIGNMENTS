package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Account;
import com.service.AccountService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AccountController {

	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String openIndexPage(Model model, Account account) { // DI
		model.addAttribute("acc", account);
		model.addAttribute("buttonValue", "Store Account Info");
		model.addAttribute("readonly", false);
		return "index";
	}

	@RequestMapping(value = "/withdrawview", method = RequestMethod.GET)
	public String withdraw(Model model, Account account) { // DI
		model.addAttribute("acc", account);
		return "withdraw";
	}

	@RequestMapping(value = "/depositview", method = RequestMethod.GET)
	public String deposite(Model model, Account account) { // DI
		model.addAttribute("acc", account);
		return "deposite";
	}

	@RequestMapping(value = "/checkbalanceview", method = RequestMethod.GET)
	public String checkbalance(Model model) { // DI
		model.addAttribute("acc", new Account());
		return "checkbalance";
	}

	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public String createAccount(Model model, Account account, HttpServletRequest req) {

		String result = "";
		result = accountService.createAccount(account);
		model.addAttribute("msg", result);
		account.setAccountId(0);
		account.setName("");
		account.setAmount(0.0f);
		model.addAttribute("acc", account);
		model.addAttribute("buttonValue", "Store Account Info");
		return "index";
	}

	@RequestMapping(value = "/deposite", method = RequestMethod.POST)
	public String deposite(Model model, Account account, HttpServletRequest req) {
		String result = accountService.deposite(account);
		model.addAttribute("msg", result);
		model.addAttribute("acc", new Account());
		return "deposite";
	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public String withdraw(Model model, Account account, HttpServletRequest req) {
		String result = accountService.withdraw(account);
		model.addAttribute("msg", result);
		model.addAttribute("acc", new Account());
		return "withdraw";
	}

	@RequestMapping(value = "/checkbalance", method = RequestMethod.POST)
	public String checkbalance(Model model, Account account, HttpServletRequest req) {
		String result = "";
		result = accountService.checkbalance(account);
		model.addAttribute("msg", result);

		model.addAttribute("acc", new Account());
		return "checkbalance";
	}

}
