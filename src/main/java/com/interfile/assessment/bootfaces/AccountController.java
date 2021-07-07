package com.interfile.assessment.bootfaces;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.interfile.assessment.services.AccountService;

@Scope(value = "session")
@Component(value = "accountController")
@ELBeanName(value = "accountController")
@Join(path = "/account", to = "/account-form.jsf")
public class AccountController {
	@Autowired
	private AccountService accountService;

	public void save() {
		System.out.println("Hello, world");
	}
}
