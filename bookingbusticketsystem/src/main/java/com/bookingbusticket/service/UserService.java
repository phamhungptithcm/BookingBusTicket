package com.bookingbusticket.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bookingbusticket.entity.User;
import com.bookingbusticket.helper.Login;

public interface UserService {
	public User save(User entity);

	public void delete(Integer id);

	public User update(User entity);

	public List<User> findAll();

	public User findById(String id);

	public User login(Login acc);

	public User register(User entity);

	int setRole(User user);

	User checkUserName(String userName);

	List<User> listAllUserName();

	User getOne(int id);

	Page<User> getAllPagination(int pageIn, int size);

	Page<User> filterByRolePagination(int roleId, int pageIn, int size);

	Page<User> findByUserNamePagination(String userName, Pageable pageable);

	Page<User> findByEmailPagination(String email, Pageable pageable);

	public Boolean forgotPassword(String email, String username);
}
