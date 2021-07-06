package com.interfile.assessment.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.interfile.assessment.entity.AccountHolderDetails;

public interface AccountHolderDetailsRepo extends PagingAndSortingRepository<AccountHolderDetails, Integer> {}
