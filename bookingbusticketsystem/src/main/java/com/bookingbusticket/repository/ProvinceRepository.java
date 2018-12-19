package com.bookingbusticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookingbusticket.entity.Province;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer> {
	
	@Query("SELECT r.provinceTo FROM Route r WHERE r.provinceFrom.provinceId=:id")
	public List<Province> findByProvinceTo(@Param("id") Integer id);
	
	@Query("SELECT r.provinceTo From Province p"
			+ " INNER JOIN Route r ON p.provinceId = r.provinceFrom.provinceId"
			+ " WHERE r.provinceFrom.provinceId=:id and r.provinceTo.provinceName like %:name%")
	
	public Iterable<Province> findByProvinceTo(@Param(value="id") Integer id, @Param(value = "name") String name);
	
	@Query("FROM Province p WHERE p.provinceName like %:name%")
	public Iterable<Province> findByProvinceFrom(@Param("name") String name);
	
	@Query("SELECT r.provinceTo FROM Province p JOIN Route r ON r.provinceFrom.provinceId = p.provinceId where r.provinceFrom.provinceId=:id")
	public Iterable<Province> findRemainingProvinces(@Param(value="id") Integer id);
}