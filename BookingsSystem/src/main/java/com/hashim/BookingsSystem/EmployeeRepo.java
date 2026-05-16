package com.hashim.BookingsSystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public interface EmployeeRepo extends JpaRepository<Employee, Integer> {}
