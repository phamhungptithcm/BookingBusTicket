import { Component, OnInit, ViewChild } from '@angular/core';
import { TicketDetail } from 'src/app/models/ticketdetail';
import { TicketdetailServiceImp } from 'src/app/service/ticketdetail/ticketdetail.service';
import { Bus } from 'src/app/models/bus';
import { BusServiceImp } from 'src/app/service/bus/bus.service';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { PagerService } from 'src/app/service/pager.service';
import { Pager } from 'src/app/models/pager';

@Component({
  selector: 'app-viewtickets',
  templateUrl: './viewtickets.component.html',
  styleUrls: ['./viewtickets.component.css']
})
export class ViewticketsComponent implements OnInit {
  isModal = false;
  buses: Bus[];
  busId:number;
  searchKey: string;
  bookedTickets: TicketDetail[];
  displayedColumns: string[] = ['firstName', 'lastName', 'departureDate', 'busId', 'ticketId', 'View'];
  constructor(
    private ticketDetailService: TicketdetailServiceImp,
    private pagerService: PagerService,
    private busService: BusServiceImp) { }
  ngOnInit() {
    this.searchKey=null;
    this.busId=0;
    this.busService.findAll().subscribe(
      data => this.buses = data

    )
    this.getPagingTicketDetail(null);
  }

  
  onChange(val: any) {
    this.busId=val;
    console.log(this.busId);
    this.getPagingTicketDetailByBusId(val)
      
  }

  searchTicket() {
    this.ticketDetailService.searchTicketsByName(this.searchKey).subscribe(
      data => this.bookedTickets = data
    )

  }


  quantity: number;
  // pager object
  pager: any = {};
  pagerShit: Pager;
  // paged items
  page:number;


  getPagingTicketDetail(page: number) {
    if (page == null) {
      page = 0;
    }
    this.ticketDetailService.getPagingTicketDetails(page).subscribe(
      data => {
        this.pagerShit = data
        console.log(this.pagerShit);
        this.setPage(1);
      })
  }
  setPage(page: number) {
  
    // get pager object from service
    if(this.busId==0){
      this.pager = this.pagerService.getPager(this.pagerShit.totalElements, page);
    page = --page;
    this.page=page;
    this.ticketDetailService.getPagingTicketDetails(page).subscribe(
      data => {
        this.pagerShit = data
        this.bookedTickets = this.pagerShit.content;
        console.log(page)
      }
    );
    }else{
      this.pager = this.pagerService.getPager(this.pagerShit.totalElements, page);
      page = --page;
      this.page=page;
      console.log('DJKAJLKAHDKLAHDLJKAHDOUEQPOJQLKENQE       '+this.busId)
      this.ticketDetailService.getPagingTicketDetailsByBusId(page,this.busId).subscribe(
        data => {
          this.pagerShit = data
          this.bookedTickets = this.pagerShit.content;
          console.log('dasdasdasdsadasda'+data)
        }
      );
    }
  }

  getPagingTicketDetailByBusId(page: number) {
    if (page == null) {
      page = 0;
    }
    this.ticketDetailService.getPagingTicketDetailsByBusId(page,this.busId).subscribe(
      data => {
        this.pagerShit = data
        this.setPage(1);
      })
  }
  


  
  cancel(ticketDetail:TicketDetail) {
    console.log(ticketDetail);
    this.ticketDetailService.update(ticketDetail).subscribe(ticketDetail => {
      
      this.bookedTickets = this.bookedTickets.filter(data => data.ticketDetailId !== ticketDetail.ticketDetailId);
    });
  }

  update(a:number){
    alert(a);
  }
}
