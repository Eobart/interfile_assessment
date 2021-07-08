package com.interfile.assessment.bootfaces;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.interfile.assessment.entity.Account;
import com.interfile.assessment.services.AccountService;
import com.interfile.assessment.services.UtilService;

import java.io.File;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.servlet.annotation.MultipartConfig;

@MultipartConfig
@Scope(value = "session")
@Component(value = "homeController")
@ELBeanName(value = "homeController")
@Join(path = "/", to = "/home-form.jsf")
@SessionScoped
public class HomeController {
	
	@Autowired
	private UtilService utilService;
	private UploadedFile file;
	
	public UploadedFile getFile() {
		return file;
	}
	
	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void upload() {
		utilService.processXML(new File("C:\\accounts\\StatementMultiple.xml"));
		utilService.processXML(new File("C:\\accounts\\StatementSingle.xml"));
	}

	// Accounts
	@Autowired
	private AccountService accountService;
	
	private List<Account> accounts;
	
	private String account;
	
	public void setAccount(String account) {
		System.out.println("Account Selected");
		this.account = account;
	}
	
	public String getAccount() {
		return this.account;
	}
	
	@Deferred
    @RequestAction
    @IgnorePostback
    public void loadData() {
		accounts = accountService.findAll();
		System.out.println(accounts.size());
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}
}
