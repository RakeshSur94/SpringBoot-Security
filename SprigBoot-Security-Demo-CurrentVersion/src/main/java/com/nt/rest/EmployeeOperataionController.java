package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp-api")
public class EmployeeOperataionController {
	//method level authentication
	@PreAuthorize("hasRole('MECH')")
	@GetMapping("/mech")
	public ResponseEntity<String> mechDepartmentEmp(){
		return new ResponseEntity<String>("Anil Jhon is the HOD", HttpStatus.OK);
	}
	@PreAuthorize("hasRole('OPT')")
	@GetMapping("/opt")
	public ResponseEntity<String> opterationDepartmentEmp(){
		return new ResponseEntity<String>("Satyveer Singh is the HOD", HttpStatus.OK);
	}
	

}
