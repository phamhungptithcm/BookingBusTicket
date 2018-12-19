import { Component, OnInit, Input } from '@angular/core';
import { Trip } from 'src/app/models/trip';
import { TicketServiceImp } from 'src/app/service/ticket/ticket.service';
import { Ticket } from 'src/app/models/ticket';
import { Router } from '@angular/router';
import swal from 'sweetalert2';
import { TicketdetailServiceImp } from 'src/app/service/ticketdetail/ticketdetail.service';
import { TicketAndStatus } from 'src/app/models/helper/TicketAndStatus';
import { SweetAlert } from 'src/app/shared/sweet-alert/sweet-alert';

declare var UIkit: any;
@Component({
  selector: 'app-seat',
  templateUrl: './seat.component.html',
  styleUrls: ['./seat.component.css']
})
export class SeatComponent extends SweetAlert implements OnInit {
  @Input() trip: Trip;
  tickets: TicketAndStatus[] = [];
  seats: number[] = [];
  amount = 0.0;
  seatsLeft: number[] = [];

  constructor(private ticketService: TicketServiceImp,
    private router: Router,
    private ticketDetailService: TicketdetailServiceImp
  ) {
    super();
    this.seats = [];
  }
  findByBusId(): void {
    let date = JSON.parse(sessionStorage.getItem('departureDate'));
    this.ticketService.findByBusId(date, this.trip.bus.busId).subscribe(
      data => {
        this.tickets = data
        if (data !== null) {
          data.forEach(t => {
            if (t.stt === true) {
              this.seatsLeft.push(t.ticket.ticketId);
            }
          });
          
        }
      });
  }
  getAmount(stt: boolean): void {
    if (stt === true) {
      this.amount += this.trip.unitPrice;
    } else if (stt === false) {
      this.amount -= this.trip.unitPrice;
    }
  }
  ngOnInit() {
    this.findByBusId();
  }
  chooseSeats(seat: Ticket) {
    const vtr: number = this.seats.findIndex(data => data === seat.ticketId);
    const vtr2: number = this.seatsLeft.findIndex(data => data === seat.ticketId);
    if (vtr === -1) {
      if (this.seats.length < 5) {
        this.seats.push(seat.ticketId);
        this.getAmount(true);
        this.seatsLeft.splice(vtr2,1);
      }
    } else {
      this.seats.splice(vtr, 1);
      this.getAmount(false);
      this.seatsLeft.push(seat.ticketId);
    }
    if(this.seats.length  >= 5) {
      this.seatsLeft.forEach(element => {
       (<HTMLInputElement>document.getElementById(`${element}`)).disabled = true;
     });
     this.showMessageToast('info', 'Not choose more 5 seats');
    } else {
      this.seatsLeft.forEach(element => {
        (<HTMLInputElement>document.getElementById(`${element}`)).disabled = false;
      });
    }
    // 
    localStorage.removeItem('seats');
    localStorage.setItem('seats', JSON.stringify(this.seats));
  }
  setDataForOrder(): void {
    localStorage.setItem('trip', JSON.stringify(this.trip));
  }
  bookTicket() {
    if (this.seats.length > 0) {
      UIkit.modal(`#modal-${this.trip.tripId}`).hide();
      console.log(this.trip.tripId);
      this.setDataForOrder();
      this.router.navigate(['/order']);
      sessionStorage.setItem('nextUrl', '/order');
    } else {
      this.showMessageToast('error', 'Please choose one or more seats');
    }
  }
}
