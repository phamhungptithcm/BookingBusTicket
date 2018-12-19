import { Component, OnInit, Input } from '@angular/core';
import { Ticket } from 'src/app/models/ticket';
import { DataService } from 'src/app/service/data.service';
import { OrderServiceImp } from 'src/app/service/order/order.service';
import { Order } from 'src/app/models/order';
import { User } from 'src/app/models/user';
import { OrderStatus } from 'src/app/models/orderstatus';
import { TicketdetailServiceImp } from 'src/app/service/ticketdetail/ticketdetail.service';
import { TicketDetail } from 'src/app/models/ticketdetail';
import { DatePipe } from '@angular/common';
import { UserService } from 'src/app/service/user/user.service';

@Component({
  selector: 'app-updateseat',
  templateUrl: './updateseat.component.html',
  styleUrls: ['./updateseat.component.css']
})
export class UpdateseatComponent implements OnInit {
  message:string;
  validUser=false;
  something:string;
  validDate;
  pipe;
  username:string;
  user:User;
  currentUser:User;
  myFormattedDate;
  password:string;
  order:Order;
  @Input() ticket:Ticket;
  constructor(private orderService:OrderServiceImp,
    private userService:UserService
    ,private ticketDetailService:TicketdetailServiceImp) { }

  ngOnInit() {
    
    this.pipe = new DatePipe('en-US');

    //Get today's Date
    var today = new Date();
    today = this.pipe.transform(today, 'dd/MM/yyyy');


    var selectedDate = localStorage.getItem("original-date")
    this.myFormattedDate = this.pipe.transform(selectedDate, 'dd/MM/yyyy');  


    
  }
  submit(){
    var orderStatus  = new OrderStatus();
    orderStatus.id =3;
    var order:Order =new Order();
        order.user=this.user;
       order.orderStatus = orderStatus;
        order.amount=1;
       

    var ticketDetail:TicketDetail = new TicketDetail(
        this.myFormattedDate,
        this.user.fullName,
        this.user.fullName,
        this.user.gender,
        20,
        this.ticket.ticketId,
        this.ticket,
        );
        this.orderService.createOrder(order).then(
          data => {
            ticketDetail.order=data
            ticketDetail.status=true;
            this.ticketDetailService.createTicketDetail(ticketDetail).subscribe()
          }
        )
        
        
   
  }
  checkUser(){
    this.userService.findByUserName(this.username).subscribe(
      data=>{this.user=data
            if(this.user!=null){
              this.something=this.username;
              this.validUser=true;
            }else{
              this.validUser=false;
            }
      }
    )
    
  }

    createTicketDetail(ticketDetail:TicketDetail,data:Order){
      this.ticketDetailService.createTicketDetail(ticketDetail).subscribe()
    }
}
