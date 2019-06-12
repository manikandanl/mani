package com.employee.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.OrderBy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
//import com.mysql.cj.x.protobuf.MysqlxCrud.Order.Direction;




@RestController
@RequestMapping("Employee")
public class EmployeeControl {
	//private static final int Pageable =5 ;
	
	@Autowired
	EmployeeService Service;
	@Autowired 
	EmployeeRepository Repository;
	
    @PostMapping("add")
	public Employee insertEmployee(@RequestBody Employee add) {
		return Service.insertEmployees(add);
	}
	@GetMapping("viewall")
	public List<Employee> getAll(){
		return Service.getAll();
	}

    @RequestMapping(value= "view/{id}", method= RequestMethod.GET)
		public Employee getEmployeeById(@PathVariable Long id) throws Exception{
        Optional<Employee> emp =  Service.getEmployeeById(id);
        if(!emp.isPresent())
            throw new Exception("not find employeeid- " + id);
            return emp.get();
    }
    @PostMapping("deleteall")
    public void deleteAllEmployees() {
	Service.deleteAllEmployees();
    }
   //@PutMapping("update")
   @RequestMapping(value= "/update/{id}", method= RequestMethod.PUT)
    public Employee updateEmployee(@RequestBody Employee updemp, @PathVariable Long id) throws Exception {
    Optional<Employee> emp =  Service.getEmployeeById(id);
    System.out.print("update???");
    if (!emp.isPresent())
        throw new Exception("not find employee id- " + id);
    if(updemp.getEmployeeName() == null || updemp.getEmployeeName().isEmpty())
        updemp.setEmployeeName(emp.get().getEmployeeName());
    updemp.setId(id);
    return Service.updateEmployee(updemp);
    }
   @RequestMapping(value= "delete/{id}", method= RequestMethod.DELETE)
   public Employee delete(@RequestBody Employee emp) {
	return Service.deletes(emp);
   } 
   @RequestMapping(value = "/customers", method = RequestMethod.GET)
   public List<Employee> viewEmployee(@RequestParam(name = "p", defaultValue = "1") int pageNumber,int PAGESIZE) {
	   
	   System.out.println("------"+pageNumber+PAGESIZE);
     List<Employee> employees = Service.getPage(pageNumber, PAGESIZE);
     return employees ;
   
		   
		
   }
		   }





