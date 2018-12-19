package com.bookingbusticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookingbusticket.entity.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer>{
	
	public List<Trip> findByRouteRouteId(@Param("routeId") Integer id);
	
	public Trip findByBus_BusId(Integer id);
	
	@Query("From  Trip t Join Fetch t.route Where t.route.routeId=:routeId")
	public Iterable<Trip> findByRouteId(@Param("routeId") Integer id);
	
	@Query("SELECT t FROM Trip t JOIN Route r ON t.route.routeId = r.routeId WHERE r.routeId=:id ")
	public Iterable<Trip> getTrips(@Param(value="id")Integer id);
	
//	@Query("SELECT t.tripId FROM Trip t WHERE t.departureTime=:dTime and t.route.routeId=:id")
//	public Integer getTripId(@Param(value="dTime")String dTime,@Param(value="id")Integer id);
	
	
	public Integer findTripIdByDepartureTimeAndRouteRouteId(String dTime,Integer id);
}
