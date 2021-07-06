package com.interfile.assessment.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.interfile.assessment.entity.Bills;

public interface BillsRepo extends PagingAndSortingRepository<Bills, Integer> {}
