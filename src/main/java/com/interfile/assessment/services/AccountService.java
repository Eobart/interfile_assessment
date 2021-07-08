package com.interfile.assessment.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.interfile.assessment.entity.Account;
import com.interfile.assessment.repo.AccountRepo;

@Service
public class AccountService {
	@Autowired
	AccountRepo accountRepo;

	// Create an entry in the db via the repo
	public Account create(int id, String accountNumber, String accountHolder, String mobileNumber, String homeNumber,
			String workNumber, String address1, String address2, String address3, String postalCode) {
		try {
			return accountRepo.save(new Account(id, accountNumber, accountHolder, postalCode, postalCode, postalCode, postalCode, postalCode, postalCode, postalCode));
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	public Account create(Account account) {
		try {
			return accountRepo.save(account);
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	// Return all the account entries in the db
	public List<Account> findAll() {
		try {
			return (List<Account>) accountRepo.findAll();
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	// Return a single entry by id
	public Account findById(int id) {
		try {
			return accountRepo.findById(id).get();
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	// Update a single entry in the db
	public Account update(Account account) {
		try {
			return accountRepo.save(account);
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	// Delete a single entry in the db
	public boolean delete(Account account) {
		try {
			accountRepo.delete(account);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
}
