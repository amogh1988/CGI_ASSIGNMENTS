package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Account;
import com.dao.AccountRepo;

@Service
public class AccountService {

	@Autowired
	AccountRepo accrepo;

	public String createAccount(Account account) {

		if (account.getAmount() <= 1000) {
			return "Please deposit amount greater than 1000";
		}
		accrepo.save(account);
		return "saved successfully";

	}

	public String deposite(Account account) {

		if (account.getAmount() <= 1000) {
			return "Please deposit amount greater than 1000";
		}

		if (account.getAmount() >= 50000) {
			return "Please submit PAN card";
		}

		accrepo.save(account);
		return null;
	}

	public String withdraw(Account account) {

		Optional<Account> acc = accrepo.findById(account.getAccountId());

		if (acc.isPresent()) {
			Account a = acc.get();
			if (a.getAmount() <= account.getAmount()) {
				return "Amount cannt be dispatch";
			} else if (a.getAmount() <= 1000) {
				return "Please maintain minimum balance of rs 1000";
			} else {
				float balance = a.getAmount() - account.getAmount();
				account.setAmount(balance);
				accrepo.save(account);
				return "Amount withdrawn successfauly";
			}
		} else {
			return "Invalid Account Info";
		}

	}

	public String checkbalance(Account accnt) {

		Optional<Account> acc = accrepo.findById(accnt.getAccountId());

		if (acc.isPresent()) {
			Account a = acc.get();
			return "Balance Amount is" + a.getAmount() + " for Account no :" + a.getAccountId();
		} else {
			return "Invalid Account Info";
		}

	}

}
