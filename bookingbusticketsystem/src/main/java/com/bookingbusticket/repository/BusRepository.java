package com.bookingbusticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookingbusticket.entity.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {
	
	@Query("Select t.bus FROM Trip t WHERE t.tripId=:id")
	public Bus findByTripId(@Param("id") Integer tripId);
}
