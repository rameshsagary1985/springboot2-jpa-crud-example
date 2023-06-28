package net.guides.springboot2.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.companyname.demo.exception.ResourceNotFoundException;

import net.guides.springboot2.demo.model.Employee;
import net.guides.springboot2.demo.repository.EmployeeRepository;
@Service
public class EmployeeService {
	
	
	@Autowired
    private EmployeeRepository employeeRepository;
  // return ResponseEntity.ok().body(employee);
	
	/*
	 * @Autowired(required=true) public void
	 * setEmployeeRepository(EmployeeRepository employeeRepository){
	 * this.employeeRepository = employeeRepository; }
	 */

	
	/*
	 * @CacheEvict(value="twenty-second-cache", key =
	 * "'StudentInCache'+#employeeId", condition =
	 * "#isCacheable == null || !#isCacheable", beforeInvocation = true)
	 * 
	 * @Cacheable(value="twenty-second-cache", key = "'StudentInCache'+#employeeId",
	 * condition = "#isCacheable != null && #isCacheable")
	 */
	public Employee FetchEmployee(Long employeeId) throws ResourceNotFoundException {
		return employeeRepository.findById(employeeId)
		 .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
	}
	
	

}
