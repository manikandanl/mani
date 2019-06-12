package com.employee.service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
//import com.mysql.cj.x.protobuf.MysqlxCrud.Order.Direction;
@Component
public class EmployeeService {
	//private static final int PAGESIZE = 20	;
	
	@Autowired
	EmployeeRepository Repository;
    public Employee insertEmployees(Employee add) {
	return Repository.save(add);
      }
    public List<Employee> getAll(){
	return (List<Employee>) Repository.findAll();
	  }
    public Optional<Employee> getEmployeeById(Long id){
	return Repository.findById((long) id);
	  }
    public Employee deletes(Employee em) {
		Repository.delete(em);
		return(em);	
      }
    public void deleteAllEmployees() {
    Repository.deleteAll();
      }
    public Employee updateEmployee(Employee emp) {
    return Repository.save(emp);
    }
    

    protected PagingAndSortingRepository<Employee, Long> getDao() {
        return Repository;
    }
    public List<Employee> getPage(@RequestParam int pageNumber,int PAGESIZE) {
    	
    PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE, Sort.Direction.ASC, "id");
	 return Repository.findAll(request).getContent();
      } 
    
    
    public Page<Employee> findJsonDataByCondition(String orderBy, String direction, int page, int size) {
    	Sort sort = null;
    	if (direction.equals("ASC")) {
    	sort = new Sort(new Sort.Order(Direction.ASC, orderBy));
    	}
    	if (direction.equals("DESC")) {
    	sort = new Sort(new Sort.Order(Direction.DESC, orderBy));
    	}
    	Pageable pageable = (Pageable) new PageRequest(page, size, sort);
    	Page<Employee> data = Repository.findAll(pageable);
    	return data;
    	     }
}

