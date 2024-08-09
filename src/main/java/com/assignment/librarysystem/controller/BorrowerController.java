package com.assignment.librarysystem.controller;

import com.assignment.librarysystem.model.Borrower;
import com.assignment.librarysystem.service.BorrowerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrowers")
public class BorrowerController {
    @Autowired
    private BorrowerService borrowerService;

    @Operation(summary = "Register a new borrower")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Borrower registered successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public com.assignment.librarysystem.response.ApiResponse<Borrower> registerBorrower(@RequestBody Borrower borrower) {
        return borrowerService.registerBorrower(borrower);
    }

    @Operation(summary = "Get all borrowers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Borrowers retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public com.assignment.librarysystem.response.ApiResponse<List<Borrower>> getAllBorrowers() {
        return borrowerService.getAllBorrowers();
    }
}
