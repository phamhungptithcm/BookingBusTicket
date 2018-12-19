package com.bookingbusticket.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookingbusticket.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	public User findByUserName(String username);
	
	List<User> findByUserRole(int roleId);

	Page<User> findByUserNameContaining(String userName, Pageable pageable);
	
	Page<User> findByEmailContaining(String email, Pageable pageable);
	
	@Modifying
	@Query("update User u set u.userRole = ?1 where u.userName = ?2")
	int setRole(int roleId, String userName);
	
	@Query("select userName from User")
	List<User> listAllUserName();
	
	User findByUserId(int id);
	
	@Query("select u from User u")
	Page<User> getAllPagination(Pageable pageable);
	
	@Query("select u from User u where u.userRole = ?1")
	Page<User> filterByRolePagination(int roleId, Pageable pageable);
}
