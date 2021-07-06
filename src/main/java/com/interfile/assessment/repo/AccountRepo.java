package com.interfile.assessment.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.interfile.assessment.entity.Account;

public interface AccountRepo extends PagingAndSortingRepository<Account, Integer> {}
