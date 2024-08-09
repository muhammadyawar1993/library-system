package com.assignment.librarysystem.service.impl;

import com.assignment.librarysystem.model.Borrower;
import com.assignment.librarysystem.repository.BorrowerRepository;
import com.assignment.librarysystem.response.ApiResponse;
import com.assignment.librarysystem.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class BorrowerServiceImpl implements BorrowerService {
    @Autowired
    private BorrowerRepository borrowerRepository;

    @Override
    public ApiResponse<Borrower> registerBorrower(Borrower borrower) {
        Borrower existingBorrower = borrowerRepository.findByEmail(borrower.getEmail());
        if (!ObjectUtils.isEmpty(existingBorrower)) {
            return new ApiResponse<>(true, "Borrower with the same details already exist", existingBorrower);
        }

        Borrower savedBorrower = borrowerRepository.save(borrower);
        return new ApiResponse<>(true, "Borrower registered successfully", savedBorrower);
    }

    @Override
    public ApiResponse<List<Borrower>> getAllBorrowers() {
        List<Borrower> borrowers = borrowerRepository.findAll();
        return new ApiResponse<>(true, "Borrowers retrieved successfully", borrowers);
    }
}
