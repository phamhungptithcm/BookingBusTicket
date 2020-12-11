package com.bookingbusticket.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookingbusticket.entity.User;
import com.bookingbusticket.service.UserService;

@RestController
@RequestMapping("${secure.admin.context.path}")
public class AdminController {
	
	private Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		try {
			return ResponseEntity.ok(userService.findAll());
		} catch (Exception e) {
			logger.error("Error findAll >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	//Pagination
	@RequestMapping("/users")
	public ResponseEntity<?>  findAllUserPagination(@RequestParam int pageIn, @RequestParam int size) {
		try {
			return ResponseEntity.ok(userService.getAllPagination(pageIn, size));
		} catch (Exception e) {
			logger.error("Error findAllUserPagination >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<?>  findOneUser(@PathVariable("id") int id) {
		try {
			return ResponseEntity.ok(userService.getOne(id));
		} catch (Exception e) {
			logger.error("Error findOneUser >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	//Pagination
	@RequestMapping("/users/filter")
	public ResponseEntity<?>  filterByRolePagination(@RequestParam int roleId, @RequestParam int pageIn, @RequestParam int size) {
		try {
			return ResponseEntity.ok(userService.filterByRolePagination(roleId, pageIn, size));
		} catch (Exception e) {
			logger.error("Error filterByRolePagination >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	//Pagination
	@GetMapping("/users/findByUserName/{userName}")
	public ResponseEntity<?>  findByUserName(@PathVariable("userName") String userName, Pageable pageable) {
		try {
			return ResponseEntity.ok(userService.findByUserNamePagination(userName, pageable));
		} catch (Exception e) {
			logger.error("Error findByUserName >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	//Pagination
	@GetMapping("/users/findByEmail/{email}")
	public ResponseEntity<?>  findByEmail(@PathVariable("email") String email, Pageable pageable) {
		try {
			return ResponseEntity.ok(userService.findByEmailPagination(email, pageable));
		} catch (Exception e) {
			logger.error("Error findByEmail >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@PostMapping("/users/add")
	public ResponseEntity<?>  create(@RequestBody User user) {
		try {
			return ResponseEntity.ok(userService.save(user));
		} catch (Exception e) {
			logger.error("Error create >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@PostMapping("/users/update")
	public ResponseEntity<?>  update(@RequestBody User user) {
		try {
			return ResponseEntity.ok(userService.update(user));
		} catch (Exception e) {
			logger.error("Error update >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}				
	}
	
	@PostMapping("/users/setRole")
	public ResponseEntity<?>  setRole(@RequestBody User user) {
		try {
			return ResponseEntity.ok(userService.setRole(user));
		} catch (Exception e) {
			logger.error("Error setRole >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}				
	}
	
	@GetMapping("/users/add")
	public ResponseEntity<?> listAllUserName() {
		try {
			return ResponseEntity.ok(userService.listAllUserName());
		} catch (Exception e) {
			logger.error("Error listAllUserName >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
}
