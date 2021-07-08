package com.interfile.assessment.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.interfile.assessment.entity.Account;
import com.interfile.assessment.entity.Bills;
import com.interfile.assessment.repo.BillsRepo;
import com.interfile.assessment.services.AccountService;
import com.interfile.assessment.services.BillsService;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTest {
	@Autowired
	AccountService accountService;
	@Autowired 
	BillsService billsService;

	int id = 1;
	String accNumber = "123456789";
	String name = "Holder1";
	String mobileNumber = "000 000 0000";
	String homeNumber = "111 111 1111";
	String workNumber = "222 222 2222";
	String address1 = "22 Benjamin ave";
	String address2 = "Olivedale";
	String address3 = "Gauteng";
	String postalCode = "11111";

	@Test
	void testCreateWithBills() {
		List<Bills> billsList = new ArrayList<Bills>();
		Account account = accountService.create(new Account(id, accNumber, name, mobileNumber, homeNumber, workNumber, address1, address2, address3, postalCode));
		billsList.add(new Bills(1, "2019-01-01", "2019-01-01 to 2019-01-02", "R200", "R200", "2021-01-01", account));
		billsList.add(new Bills(2, "2012-01-01", "2012-01-01 to 2012-01-02", "R300", "R100", "2027-01-01", account));
		for (Bills bills : billsList) {
			billsService.create(bills);
		}
		assertNotNull(account);
		accountService.delete(account);
	}
	
	@Test
	void testFindAll() {
		Account account = accountService.create(id, accNumber, name, mobileNumber, homeNumber, workNumber, address1, address2, address3, postalCode);
		List<Account> accounts = accountService.findAll();
		assertNotNull(accountService.findAll());
		assertEquals(1, accounts.size());
		accountService.delete(account);
	}
	
	@Test
	void testFindById() {
		Account account = accountService.create(id, accNumber, name, mobileNumber, homeNumber, workNumber, address1, address2, address3, postalCode);
		Account searchedAccount = accountService.findById(id);
		assertNotNull(searchedAccount);
		assertEquals(searchedAccount.getAccountHolder(), account.getAccountHolder());
		accountService.delete(account);
	}
	
	@Test
	void testUpdate() {
		Account account = accountService.create(id, accNumber, name, mobileNumber, homeNumber, workNumber, address1, address2, address3, postalCode);		
		Account updateAccount = accountService.update(new Account(id, "09876", "New Holder", "999 999 9999", "888 888 8888", "777 777 7777", "435 Fir ave", "Randburg", "Johannesburg", "555555"));
		assertEquals(accountService.findById(id).getId(), updateAccount.getId());
		assertEquals(accountService.findById(id).getAccountNumber(), updateAccount.getAccountNumber());
		assertEquals(accountService.findById(id).getAccountHolder(), updateAccount.getAccountHolder());
		assertEquals(accountService.findById(id).getMobileNumber(), updateAccount.getMobileNumber());
		assertEquals(accountService.findById(id).getHomeNumber(), updateAccount.getHomeNumber());
		assertEquals(accountService.findById(id).getWorkNumber(), updateAccount.getWorkNumber());
		assertEquals(accountService.findById(id).getAddress1(), updateAccount.getAddress1());
		assertEquals(accountService.findById(id).getAddress2(), updateAccount.getAddress2());
		assertEquals(accountService.findById(id).getAddress3(), updateAccount.getAddress3());
		assertEquals(accountService.findById(id).getPostalCode(), updateAccount.getPostalCode());
		accountService.delete(updateAccount);
	}
	
	@Test
	void findAllAfterDeletes() {
		List<Account> accounts = accountService.findAll();
		assertNotNull(accountService.findAll());
		assertEquals(0, accounts.size());
	}
}
