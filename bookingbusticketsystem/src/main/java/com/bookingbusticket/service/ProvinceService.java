package com.bookingbusticket.service;

import java.util.List;

import com.bookingbusticket.entity.Province;

public interface ProvinceService {
	public Province save(Province entity) throws Exception;

	public void delete(Integer id) throws Exception;

	public Province update(Province entity) throws Exception;

	public List<Province> findAll() throws Exception;

	public Province finfById(Integer id) throws Exception;

	public List<Province> findByProvinceTo(Integer id) throws Exception;

	public Iterable<Province> findRemainingProvinces(Integer id) throws Exception;

	public Iterable<Province> findByProvinceTo(String name, Integer id) throws Exception;

	public Iterable<Province> findByProvinceFrom(String name) throws Exception;
	
}
