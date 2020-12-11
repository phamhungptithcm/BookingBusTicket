package com.bookingbusticket.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bookingbusticket.entity.User;
import com.bookingbusticket.helper.Login;

public interface UserService {
	public User save(User entity) throws Exception;

	public void delete(Integer id) throws Exception;

	public User update(User entity) throws Exception;

	public List<User> findAll() throws Exception;

	public User findById(String id) throws Exception;

	public User login(Login acc) throws Exception;

	public User register(User entity) throws Exception;

	int setRole(User user) throws Exception;

	User checkUserName(String userName) throws Exception;

	List<User> listAllUserName() throws Exception;

	User getOne(int id) throws Exception;

	Page<User> getAllPagination(int pageIn, int size) throws Exception;

	Page<User> filterByRolePagination(int roleId, int pageIn, int size) throws Exception;

	Page<User> findByUserNamePagination(String userName, Pageable pageable) throws Exception;

	Page<User> findByEmailPagination(String email, Pageable pageable) throws Exception;

	public Boolean forgotPassword(String email, String username) throws Exception;
}
