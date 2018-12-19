package com.bookingbusticket.service;

import java.util.List;

import com.bookingbusticket.entity.Province;

public interface ProvinceService {
	public Province save(Province entity);

	public void delete(Integer id);

	public Province update(Province entity);

	public List<Province> findAll();

	public Province finfById(Integer id);

	public List<Province> findByProvinceTo(Integer id);

	public Iterable<Province> findRemainingProvinces(Integer id);

	public Iterable<Province> findByProvinceTo(String name, Integer id);

	public Iterable<Province> findByProvinceFrom(String name);
	
}
