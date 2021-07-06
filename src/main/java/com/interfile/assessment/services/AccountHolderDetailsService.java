package com.interfile.assessment.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.interfile.assessment.entity.AccountHolderDetails;
import com.interfile.assessment.repo.AccountHolderDetailsRepo;

@Service
public class AccountHolderDetailsService {
	@Autowired
	AccountHolderDetailsRepo accountHolderDetailsRepo;

	public AccountHolderDetails create(Integer id, String mobileNumber, String homeNumber, String workNumber,
			String address1, String address2, String address3, String postalCode) {
		try {
			return accountHolderDetailsRepo.save(new AccountHolderDetails(id, mobileNumber, homeNumber, workNumber,
					address1, address2, address3, postalCode));
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	public AccountHolderDetails create(AccountHolderDetails accountHolderDetails) {
		try {
			return accountHolderDetailsRepo.save(accountHolderDetails);
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	public List<AccountHolderDetails> findAll() {
		try {
			return (List<AccountHolderDetails>) accountHolderDetailsRepo.findAll();
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	public AccountHolderDetails findById(int id) {
		try {
			return accountHolderDetailsRepo.findById(id).get();
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	public AccountHolderDetails update(AccountHolderDetails accountHolderDetails) {
		try {
			return accountHolderDetailsRepo.save(accountHolderDetails);
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	public boolean delete(AccountHolderDetails accountHolderDetails) {
		try {
			accountHolderDetailsRepo.delete(accountHolderDetails);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
}
