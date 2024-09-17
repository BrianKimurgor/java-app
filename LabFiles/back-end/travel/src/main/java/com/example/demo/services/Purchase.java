package com.example.demo.services;

import com.example.demo.entities.Customer;
import com.example.demo.entities.VacationPackage;
import lombok.Data;

import java.util.List;

@Data
public class Purchase {
    private Customer customer;
    private List<VacationPackage> vacationPackages;
}
