package com.assignment.librarysystem.service;

import com.assignment.librarysystem.model.Borrower;
import com.assignment.librarysystem.response.ApiResponse;

import java.util.List;

public interface BorrowerService {
    ApiResponse<Borrower> registerBorrower(Borrower borrower);
    ApiResponse<List<Borrower>> getAllBorrowers();
}
