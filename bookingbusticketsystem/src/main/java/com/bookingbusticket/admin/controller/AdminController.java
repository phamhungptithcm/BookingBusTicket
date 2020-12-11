package com.bookingbusticket.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("${admin.context.path}")
public class AdminController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> findAll(){
		return userService.findAll();
	}
	
	//Pagination
	@RequestMapping("/users")
	public Page<User> findAllUserPagination(@RequestParam int pageIn, @RequestParam int size) {
		return userService.getAllPagination(pageIn, size);
	}
	
	@GetMapping("/users/{id}")
	public User findOneUser(@PathVariable("id") int id) {
		return userService.getOne(id);
	}
	
	//Pagination
	@RequestMapping("/users/filter")
	public Page<User> filterByRolePagination(@RequestParam int roleId, @RequestParam int pageIn, @RequestParam int size) {
		return userService.filterByRolePagination(roleId, pageIn, size);
	}
	
	//Pagination
	@GetMapping("/users/findByUserName/{userName}")
	public Page<User> findByUserName(@PathVariable("userName") String userName, Pageable pageable) {
		return userService.findByUserNamePagination(userName, pageable);
	}
	
	//Pagination
	@GetMapping("/users/findByEmail/{email}")
	public Page<User> findByEmail(@PathVariable("email") String email, Pageable pageable) {
		return userService.findByEmailPagination(email, pageable);
	}
	
	@PostMapping("/users/add")
	public User create(@RequestBody User user) {
		return userService.save(user);
	}
	
	@PostMapping("/users/update")
	public User update(@RequestBody User user) {
		return userService.update(user);				
	}
	
	@PostMapping("/users/setRole")
	public int setRole(@RequestBody User user) {
		return userService.setRole(user);				
	}
	
	@GetMapping("/users/add")
	public List<User> listAllUserName() {
		return userService.listAllUserName();
	}
	
}
