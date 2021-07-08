package com.interfile.assessment.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interfile.assessment.entity.Account;
import com.interfile.assessment.entity.Bills;
import com.interfile.assessment.repo.BillsRepo;

@Service
public class BillsService {
	@Autowired
	BillsRepo billsRepo;

	public Bills create(Integer id, String billDate, String period, String charges, String outstanding, String dueDate, Account account) {
		try {
			return billsRepo.save(new Bills(id, billDate, period, charges, outstanding, dueDate, account));
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	public Bills create(Bills bills) {
		try {
			return billsRepo.save(bills);
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	public List<Bills> findAll() {
		try {
			return (List<Bills>) billsRepo.findAll();
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	public Bills findById(int id) {
		try {
			return billsRepo.findById(id).get();
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
	
	public List<Bills> findByAccount(Account account) {
		try {
			return billsRepo.findByAccount(account);
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	public Bills update(Bills bills) {
		try {
			return billsRepo.save(bills);
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	public boolean delete(Bills bills) {
		try {
			billsRepo.delete(bills);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
}
