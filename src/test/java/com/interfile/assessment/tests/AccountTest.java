package com.interfile.assessment.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.interfile.assessment.entity.Account;
import com.interfile.assessment.services.AccountService;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTest {
	@Autowired
	AccountService accountService;

	int id = 1;
	String accNumber = "123456789";
	String name = "Holder1";

	@Test
	void testCreate() {
		Account account = accountService.create(id, accNumber, name);
		assertNotNull(account);
		accountService.delete(account);
	}
	
	@Test
	void findAll() {
		Account account = accountService.create(id, accNumber, name);
		List<Account> accounts = accountService.findAll();
		assertNotNull(accountService.findAll());
		assertEquals(1, accounts.size());
		accountService.delete(account);
	}
	
	@Test
	void testFindById() {
		Account account = accountService.create(id, accNumber, name);
		Account searchedAccount = accountService.findById(id);
		assertNotNull(searchedAccount);
		assertEquals(searchedAccount.getAccountHolder(), account.getAccountHolder());
		accountService.delete(account);
	}
	
	@Test
	void update() {
		accountService.create(id, accNumber, name);		
		Account updateAccount = accountService.update(new Account(id, "09876", "New Holder"));
		assertEquals(accountService.findById(id).getId(), updateAccount.getId());
		assertEquals(accountService.findById(id).getAccountNumber(), updateAccount.getAccountNumber());
		assertEquals(accountService.findById(id).getAccountHolder(), updateAccount.getAccountHolder());
		accountService.delete(updateAccount);
	}
	
	@Test
	void findAllAfterDeletes() {
		Account account = accountService.create(id, accNumber, name);
		List<Account> accounts = accountService.findAll();
		assertNotNull(accountService.findAll());
		assertEquals(0, accounts.size());
		accountService.delete(account);
	}
}
