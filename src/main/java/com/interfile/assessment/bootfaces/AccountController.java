package com.interfile.assessment.bootfaces;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.interfile.assessment.entity.Account;
import com.interfile.assessment.services.AccountService;

@Scope(value = "session")
@Component(value = "accountController")
@ELBeanName(value = "accountController")
@Join(path = "/account", to = "/account-form.jsf")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	HomeController homeController;
	
	private String test;
	
	@Deferred
    @RequestAction
    @IgnorePostback
	public void setTest() {
		System.out.println("Setting data" + homeController.getAccount());
		this.test = homeController.getAccount();
	}

	public String getTest() {
		return test;
	}

	public void save() {
		System.out.println("Hello, world");
	}
}
