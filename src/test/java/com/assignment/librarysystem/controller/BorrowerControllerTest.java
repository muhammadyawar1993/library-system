package com.assignment.librarysystem.controller;

import com.assignment.librarysystem.model.Borrower;
import com.assignment.librarysystem.response.ApiResponse;
import com.assignment.librarysystem.service.BorrowerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BorrowerControllerTest {

    @Mock
    private BorrowerService borrowerService;

    @InjectMocks
    private BorrowerController borrowerController;

    public BorrowerControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterBorrower() {
        Borrower borrower = new Borrower();
        ApiResponse<Borrower> response = new ApiResponse<>(true, "Borrower registered successfully", borrower);
        when(borrowerService.registerBorrower(borrower)).thenReturn(response);

        ApiResponse<Borrower> result = borrowerController.registerBorrower(borrower);

        assertEquals(response, result);
    }

    @Test
    public void testGetAllBorrowers() {
        Borrower borrower = new Borrower();
        List<Borrower> borrowers = Collections.singletonList(borrower);
        ApiResponse<List<Borrower>> response = new ApiResponse<>(true, "Borrowers fetched successfully", borrowers);
        when(borrowerService.getAllBorrowers()).thenReturn(response);

        ApiResponse<List<Borrower>> result = borrowerController.getAllBorrowers();

        assertEquals(response, result);
    }
}

