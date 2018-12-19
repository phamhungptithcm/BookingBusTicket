import { Component, OnInit } from '@angular/core';
import { TicketServiceImp } from 'src/app/service/ticket/ticket.service';
import { PagerService } from 'src/app/service/pager.service';
import { Pager } from 'src/app/models/pager';
import { TicketdetailServiceImp } from 'src/app/service/ticketdetail/ticketdetail.service';
import { TicketDetail } from 'src/app/models/ticketdetail';

@Component({
  selector: 'app-tickets',
  templateUrl: './tickets.component.html',
  styleUrls: ['./tickets.component.css']
})
export class TicketsComponent implements OnInit {
  constructor(
    private pagerService:PagerService,
    private ticketDetailService:TicketdetailServiceImp) { }

  quantity:number;
  // pager object
  pager: any = {};
  pagerShit:Pager;
  // paged items
  bookedTickets: TicketDetail[];
 
  ngOnInit() {
    this.getPagingTicketDetail(null);
  }
  
  getPagingTicketDetail(page:number){
    if(page==null){
      page=0;
    }
    this.ticketDetailService.getPagingTicketDetails(page).subscribe(
      data=>{this.pagerShit =data
      this.setPage(1);
      })
  }
  setPage(page: number) {
    // get pager object from service
    this.pager = this.pagerService.getPager(this.pagerShit.totalElements, page);
    page=--page;
    this.ticketDetailService.getPagingTicketDetails(page).subscribe(
      data=>{this.pagerShit =data
        this.bookedTickets = this.pagerShit.content;
      console.log(page)}
    )
    
}

  pageThisShit(){
    this.quantity=this.pagerShit.totalElements;
    this.setPage(1);
  }
}
