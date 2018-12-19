import { Component, OnInit, Input } from '@angular/core';
import { TicketDetail } from 'src/app/models/ticketdetail';
import { TripServiceImp } from 'src/app/service/trip/trip.service';
import { Trip } from 'src/app/models/trip';
import { Bus } from 'src/app/models/bus';
import { Province } from 'src/app/models/province';

@Component({
  selector: 'app-infoticket',
  templateUrl: './infoticket.component.html',
  styleUrls: ['./infoticket.component.css']
})
export class InfoticketComponent implements OnInit {
  @Input() ticketDetail: TicketDetail;
  trip: Trip = new Trip();
  bus: Bus = new Bus();
  from: Province = new Province();
  to: Province = new Province();
  constructor(private tripService: TripServiceImp) { }

  ngOnInit() {
    this.tripService.findByBusId(this.ticketDetail.ticket.bus.busId).subscribe(
      data =>{
        this.trip = data;
        if (data !== null) {
          this.bus = this.trip.bus;
          this.from = data.route.provinceFrom;
          this.to = data.route.provinceTo;
        }
      } 
    ); 
  }
}
