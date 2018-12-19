import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { BusServiceImp } from './bus/bus.service';
import { OrderServiceImp } from './order/order.service';
import { OrderstatusServiceImp } from './orderstatus/orderstatus.service';
import { ProvinceServiceImp } from './province/province.service';
import { RouteServiceImp } from './route/route.service';
import { TicketServiceImp } from './ticket/ticket.service';
import { TicketdetailServiceImp } from './ticketdetail/ticketdetail.service';
import { TripServiceImp } from './trip/trip.service';
import { UserService } from './user/user.service';
@NgModule({
  declarations: [

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    BusServiceImp,
    OrderServiceImp,
    OrderstatusServiceImp,
    ProvinceServiceImp,
    RouteServiceImp,
    TicketServiceImp,
    TicketdetailServiceImp,
    TripServiceImp,
    UserService
  ],
  bootstrap: []
})
export class ServiceModule { }