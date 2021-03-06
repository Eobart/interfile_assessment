package com.interfile.assessment.repo;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.interfile.assessment.entity.Account;
import com.interfile.assessment.entity.Bills;

public interface BillsRepo extends PagingAndSortingRepository<Bills, Integer> {
	List<Bills> findByAccount(Account accoun);
}
