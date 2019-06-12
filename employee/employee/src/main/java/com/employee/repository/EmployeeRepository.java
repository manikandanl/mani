package com.employee.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>{

	Page<Employee> findAll(Pageable pageable);
	//Page<Employee> findPaginated(Pageable pageable);
	//List<Employee> getContent();
	//Page<Employee> findAll(Pageable pageable);
	
}
