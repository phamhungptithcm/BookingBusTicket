package com.bookingbusticket.serviceimp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingbusticket.entity.Province;
import com.bookingbusticket.repository.ProvinceRepository;
import com.bookingbusticket.service.ProvinceService;

@Service
@Transactional
public class ProvinceServiceImp implements ProvinceService{
	@Autowired
	private ProvinceRepository provinceRepository;
	
	@Override
	public Province save(Province entity) {
		return provinceRepository.save(entity);
		
	}

	@Override
	public void delete(Integer id) {
		provinceRepository.deleteById(id);
		
	}

	@Override
	public Province update(Province entity) {
		return provinceRepository.save(entity);
		
	}

	@Override
	public List<Province> findAll() {
		
		return provinceRepository.findAll();
	}

	@Override
	public Province finfById(Integer id) {
		Province p = provinceRepository.findById(id).get();
		if(p != null) {
			return p;
		}
		return null;
	}

	@Override
	public List<Province> findByProvinceTo(Integer id) {
		return provinceRepository.findByProvinceTo(id);
	}

	@Override
	public Iterable<Province> findByProvinceTo(String name, Integer id) {
		return provinceRepository.findByProvinceTo(id,name);
	}

	
	@Override
	public Iterable<Province> findByProvinceFrom(String name) {
		return provinceRepository.findByProvinceFrom(name);
	}

	@Override
	public Iterable<Province> findRemainingProvinces(Integer id) {
		return provinceRepository.findRemainingProvinces(id);
	}
}
