package com.bookingbusticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookingbusticket.entity.Province;
import com.bookingbusticket.service.ProvinceService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/user/province")
public class ProvinceController {
	@Autowired
	private ProvinceService provinceService;
	
	@GetMapping
	public Iterable<Province> findAll() {
		return provinceService.findAll();
	}
	
	@GetMapping("/{id}")
	public Province getProvinceById(@PathVariable("id") Integer id)
	{
		return provinceService.finfById(id);
	}
	@GetMapping("/provincet")
	public Iterable<Province> findByProvinceTo(@RequestParam("id") Integer id)
	{
		return provinceService.findByProvinceTo(id);
	}
}
