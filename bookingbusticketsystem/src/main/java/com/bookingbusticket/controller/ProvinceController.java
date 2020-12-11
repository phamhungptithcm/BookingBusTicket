package com.bookingbusticket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookingbusticket.service.ProvinceService;

@RestController
@RequestMapping("${unsecure.user.context.path}/province")
public class ProvinceController {
	
	private Logger logger = LoggerFactory.getLogger(ProvinceController.class);
	@Autowired
	private ProvinceService provinceService;
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.ok(provinceService.findAll());
		} catch (Exception e) {
			logger.error("Error findAllProvince >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProvinceById(@PathVariable("id") Integer id)
	{
		try {
			return ResponseEntity.ok(provinceService.finfById(id));
		} catch (Exception e) {
			logger.error("Error getProvinceById >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	@GetMapping("/provincet")
	public ResponseEntity<?> findByProvinceTo(@RequestParam("id") Integer id)
	{
		try {
			return ResponseEntity.ok(provinceService.findByProvinceTo(id));
		} catch (Exception e) {
			logger.error("Error findByProvinceTo >> " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
