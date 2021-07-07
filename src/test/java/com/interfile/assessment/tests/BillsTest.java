package com.interfile.assessment.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.interfile.assessment.entity.Account;
import com.interfile.assessment.entity.Bills;
import com.interfile.assessment.services.AccountService;
import com.interfile.assessment.services.BillsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class BillsTest {
	@Autowired
	BillsService billsService;
	@Autowired
	AccountService accountService;

	private static Account account;
	
	int account_id = 1;
	String accNumber = "123456789";
	String name = "Holder1";
	String mobileNumber = "000 000 0000";
	String homeNumber = "111 111 1111";
	String workNumber = "222 222 2222";
	String address1 = "22 Benjamin ave";
	String address2 = "Olivedale";
	String address3 = "Gauteng";
	String postalCode = "11111";
	
	int id = 1;
	String billDate = "2018-01-01";
	String period = "2018-01-01 to 2018-01-02";
	String charges = "R100";
	String outstanding = "R100";
	String dueDate = "2020-01-01";
	
	@BeforeAll
	void beforeAll() {
		account = accountService.create(account_id, accNumber, name, mobileNumber, homeNumber, workNumber, address1, address2, address3, postalCode);
	}
	
	@AfterAll
	void afterAll() {
		accountService.delete(account);
	}
	
	@Test
	void testCreate() { 
		Bills bills = billsService.create(id, billDate, period, charges, outstanding, dueDate, account);
		assertNotNull(bills);
		billsService.delete(bills);
	}
	
	@Test
	void testFindAll() {
		Bills bills = billsService.create(id, billDate, period, charges, outstanding, dueDate, account);
		List<Bills> billsList = billsService.findAll();
		assertNotNull(billsService.findAll());
		assertEquals(1, billsList.size());
		billsService.delete(bills);
	}
	
	@Test
	void testFindById() {
		Bills bills = billsService.create(id, billDate, period, charges, outstanding, dueDate, account);
		Bills searchedBill = billsService.findById(id);
		assertNotNull(searchedBill);
		assertEquals(searchedBill.getBillDate(), bills.getBillDate());
		billsService.delete(bills);
	}
	
	@Test
	void testUpdate() {
		billsService.create(id, billDate, period, charges, outstanding, dueDate, account);
		Bills updateBill = billsService.update(new Bills(id, "2019-01-01", "2019-01-01 to 2019-01-02", "R200", "R200", "2021-01-01", account));
		assertEquals(billsService.findById(id).getId(), updateBill.getId());
		assertEquals(billsService.findById(id).getBillDate(), updateBill.getBillDate());
		assertEquals(billsService.findById(id).getPeriod(), updateBill.getPeriod());
		assertEquals(billsService.findById(id).getCharges(), updateBill.getCharges());
		assertEquals(billsService.findById(id).getOutstanding(), updateBill.getOutstanding());
		assertEquals(billsService.findById(id).getDueDate(), updateBill.getDueDate());
		billsService.delete(updateBill);
	}
	
	@Test
	void findAllAfterDeletes() {
		List<Bills> bills = billsService.findAll();
		assertNotNull(billsService.findAll());
		assertEquals(0, bills.size());
	}
}
