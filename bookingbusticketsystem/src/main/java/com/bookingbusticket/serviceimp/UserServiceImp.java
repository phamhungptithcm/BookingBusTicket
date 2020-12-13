package com.bookingbusticket.serviceimp;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookingbusticket.entity.User;
import com.bookingbusticket.helper.Login;
import com.bookingbusticket.helper.Mailer;
import com.bookingbusticket.repository.UserRepository;
import com.bookingbusticket.service.UserService;

@Service
@Transactional
public class UserServiceImp implements UserService, UserDetailsService {
	@Autowired
	UserRepository userRepositoty;

	@Autowired
	private BCryptPasswordEncoder encrypt;
	
	@Autowired
	Mailer mailer;
	@Override
	public User save(User entity) {
		String encode = encrypt.encode(entity.getPassword());
		entity.setPassword(encode);
		return userRepositoty.save(entity);
	}

	@Override
	public void delete(Integer id) {
	}

	@Override
	public User update(User entity) {
		User user = this.findById(entity.getUserName());
		if(!user.getPassword().equals("")) {
			entity.setPassword(entity.getPassword());
		} else {
			entity.setPassword(encrypt.encode(entity.getPassword()));
		}
		return userRepositoty.save(entity);
	}

	@Override
	public List<User> findAll() {
		return userRepositoty.findAll();
	}

	@Override
	public User findById(String id) {
		User cus = userRepositoty.findByUserName(id);
		if (cus == null) {
			return null;
		}
		return cus;
	}

	@Override
	public User login(Login acc) {
		User user = this.findById(acc.getUserName());
		if (!encrypt.matches(acc.getPassword(), user.getPassword())) {
			user = null;
			return user;
		}
		return user;
	}

	private List<SimpleGrantedAuthority> getAuthority(int userRole) {
		String sRole = (userRole == 1 ? "USER" : (userRole == 2 ? "SELLER" : "ADMIN"));
		SimpleGrantedAuthority role = new SimpleGrantedAuthority("ROLE_" + sRole);
		return Arrays.asList(role);
	}

	public User register(User entity) {
		User user = this.findById(entity.getUserName());
		String encode = encrypt.encode(entity.getPassword());
		entity.setPassword(encode);
		System.out.println(entity.getEmail());
		return userRepositoty.save(entity);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepositoty.findByUserName(username);
		if (user == null) {
			return null;
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				this.getAuthority(user.getUserRole()));
	}

	@Override
	public int setRole(User user) {
		return userRepositoty.setRole(user.getUserRole(), user.getUserName());
	}

	@Override
	public User checkUserName(String userName) {
		return userRepositoty.findByUserName(userName);
	}

	@Override
	public List<User> listAllUserName() {
		return userRepositoty.listAllUserName();
	}

	@Override
	public User getOne(int id) {
		return userRepositoty.findByUserId(id);
	}

	@Override
	public Page<User> getAllPagination(@RequestParam int pageIn, @RequestParam int size) {
		Pageable pageable = PageRequest.of(pageIn, size, Sort.by("userId"));
		return userRepositoty.getAllPagination(pageable);
	}

	@Override
	public Page<User> filterByRolePagination(int roleId, int pageIn, int size) {
		Pageable pageable = PageRequest.of(pageIn, size, Sort.by("userId"));

		return userRepositoty.filterByRolePagination(roleId, pageable);
	}

	@Override
	public Page<User> findByUserNamePagination(String userName, Pageable pageable) {
		return userRepositoty.findByUserNameContaining(userName, pageable);
	}

	@Override
	public Page<User> findByEmailPagination(String email, Pageable pageable) {
		return userRepositoty.findByEmailContaining(email, pageable);
	}

	@Override
	public Boolean forgotPassword(String email, String username) {
		User user = userRepositoty.findByUserName(username);
		if(user == null) {
			return false;
		}
		if(!email.equals(user.getEmail())) {
			return false;
		}
		String newpass = this.randomString(8,true,true);
		mailer.send(email, "Forgot password for " + user.getUserName(), "New Password: " + newpass);
		user.setPassword(newpass);
		this.update(user);
		return true;
	}
	
	private String randomString(int length, boolean letter, boolean number) {
		return RandomStringUtils.random(length, letter, number);
	}
}
