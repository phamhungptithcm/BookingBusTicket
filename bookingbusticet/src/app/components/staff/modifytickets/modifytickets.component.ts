import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route } from '@angular/router';
import { DataService } from 'src/app/service/data.service';
import { TicketdetailServiceImp } from 'src/app/service/ticketdetail/ticketdetail.service';
import { TicketServiceImp } from 'src/app/service/ticket/ticket.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-modifytickets',
  templateUrl: './modifytickets.component.html',
  styleUrls: ['./modifytickets.component.css']
})
export class ModifyticketsComponent implements OnInit {
  displayedColumns: string[] = ['ticketIdforAngular', 'ticketStatus','View'];
  message:string;
  ticketDetails;
  public isModel;
  ticketsWithUpdatedStatus;
  allTicketsWithSelectedTripId;
  constructor(private route:ActivatedRoute,
    private ticketDetailService:TicketdetailServiceImp,
    private ticketServiceImp:TicketServiceImp) { }
  tripid;
  pipe;
  myFormattedDate;
  validDate;


  
  ngOnInit() {
    this.pipe = new DatePipe('en-US');

    //Get today's Date
    var today = new Date();
    today = this.pipe.transform(today, 'yyyy-MM-dd');


    var selectedDate = localStorage.getItem("original-date")
    this.myFormattedDate = this.pipe.transform(selectedDate, 'yyyy-MM-dd');  
    console.log("today : " + today);
    console.log("selectedDate  " + this.myFormattedDate)
    var toDayDate= convertDate(today);
    var selectedDates=convertDate(this.myFormattedDate);
    if(toDayDate>selectedDates){
      this.validDate=false;
    }else{
      this.validDate=true;
    }
    
    this.tripid= +this.route.snapshot.paramMap.get('id'); 
  
    this.getAllTicketsByBusID()
  }


    onClick(value){
      this.isModel=value;
    }
 




  getAllTicketsByBusID(){
    this.ticketServiceImp.findByBusIdKhai(this.tripid,this.myFormattedDate).subscribe(
      data=>{this.allTicketsWithSelectedTripId=data
        localStorage.removeItem("date")
            }
    )
  }

  cancelTicket(val:any){
    console.log(this.myFormattedDate,val)
    this.ticketDetailService.cancelBookedTicket(this.myFormattedDate,val).subscribe();
  }
  
 
}
function convertDate(d) {
  var parts = d.split('-');
  return new Date(parts[2], parts[1], parts[0]);
}