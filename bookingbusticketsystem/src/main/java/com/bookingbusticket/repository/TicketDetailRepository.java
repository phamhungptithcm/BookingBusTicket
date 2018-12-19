package com.bookingbusticket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookingbusticket.entity.TicketDetail;

@Repository
public interface TicketDetailRepository extends JpaRepository<TicketDetail, Integer> {
	public List<TicketDetail> findByOrderUserUserId(Integer userId);

	@Query(value = "SELECT * FROM ticketdetails AS t INNER JOIN orders AS o ON t.order_Id = o.order_Id where o.user_Id=:id AND t.Departure_Date >=:date", nativeQuery=true)
	public List<TicketDetail> findByUserId(@Param("id") Integer userId, @Param("date") String date);
	
	public List<TicketDetail> findByDepartureDateAndTicketBusBusIdAndStatus(Date date, Integer busId,Boolean stt);
	public List<TicketDetail> findByDepartureDateAndTicketBusBusIdOrderByDepartureDateAsc(Date date, Integer busId);
	
public Iterable<TicketDetail> findAllByTicketBusBusId(Integer id);
	
	public Iterable<TicketDetail> findByLastName(String lastName);


	@Query("FROM TicketDetail t WHERE t.firstName like %:name%")
	public Page<TicketDetail> findByName(Pageable pageable,@Param("name") String name);
	

	public Iterable<TicketDetail> findAllByDepartureDate(Date date);
	Page<TicketDetail> findAllByStatus(Pageable pageable,boolean status);
	@Query("select count(t.ticketDetailId) from TicketDetail t")
	public int getTicketDetailQuantity();
	List<TicketDetail> findByStatus(boolean status);
	
	public Page<TicketDetail> findAll(Pageable pageable);


	public Page<TicketDetail> findByTicketBusBusId(Pageable pageable, int id);
	
	public void deleteByDepartureDateAndTicketTicketId(Date date,int id);
	
	List<TicketDetail> findByDepartureDateAndTicketBusBusId(Date date,Integer bId);

	List<TicketDetail> findByStatusAndDepartureDate(boolean status, Date date);
	
	TicketDetail findByDepartureDateAndTicketTicketId(Date date, int ticketId);
	
}
