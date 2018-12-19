package com.bookingbusticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookingbusticket.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer>{
	@Query("From Route r WHERE r.provinceFrom.provinceId=:from AND r.provinceTo.provinceId=:to")
	public Route findByFromAndTo(@Param("from") Integer from, @Param("to") Integer to);
	
	
public Route findByProvinceFromProvinceIdAndProvinceToProvinceId(Integer from, Integer to);
	
	@Query("SELECT r FROM Route r where r.provinceFrom.provinceId=:fId and r.provinceTo.provinceId=:tId")
	public Route findRouteId(@Param(value="fId") Integer fId,@Param(value="tId")Integer tId);
	
}


