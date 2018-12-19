import { Component, OnInit, Input, OnDestroy, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl, NgForm } from '@angular/forms';
import { Trip } from 'src/app/models/trip';
import { Ticket } from 'src/app/models/ticket';
import { Passenger } from 'src/app/models/helper/info- passenger';
import { Order } from 'src/app/models/order';
import { OrderServiceImp } from 'src/app/service/order/order.service';
import { TicketServiceImp } from 'src/app/service/ticket/ticket.service';
import { TicketDetail } from 'src/app/models/ticketdetail';
import { OrderData } from 'src/app/models/helper/order-data';
import swal from 'sweetalert2';
import { User } from 'src/app/models/user';
import { Router } from '@angular/router';
import { SweetAlert } from 'src/app/shared/sweet-alert/sweet-alert';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent extends SweetAlert implements OnInit {

  constructor(
    private _formBuilder: FormBuilder,
    private orderService: OrderServiceImp,
    private ticketService: TicketServiceImp,
    private router: Router
  ) {
    super()
  }
  isLinear = true;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  trip: Trip = null;
  seats: number[] = [];
  amount: number;
  curUser: User;
  // tslint:disable-next-line:member-ordering
  passenger: Passenger[] = [];
  // tslint:disable-next-line:member-ordering
  s: string[];
  // tslint:disable-next-line:member-ordering
  tickets: Ticket[] = [];
  ticketDetails: TicketDetail[] = [];
  ngOnInit() {
    this.curUser = JSON.parse(sessionStorage.getItem('user'));
    this.firstFormGroup = this._formBuilder.group({
    });
    this.secondFormGroup = this._formBuilder.group({
      cardNumber: ['', Validators.required],
      nameOnCard: ['', Validators.required],
      Month: ['', Validators.required],
      Year: ['', Validators.required],
      CCV: ['', Validators.required]
    });
    this.getInfoBooking();
    this.getListTicketById();
  }
  getInfoBooking(): void {
    this.seats = JSON.parse(localStorage.getItem('seats'));
    this.trip = JSON.parse(localStorage.getItem('trip'));
    this.amount = this.seats.length * this.trip.unitPrice;
    localStorage.removeItem('seats');
    localStorage.removeItem('trip');
  }
  onSubmitForm(f: NgForm) {
    this.s = Object.values(f.value);
    for (let i = 0; i < this.s.length; i += 4) {
      let tmp = new Passenger(this.s[i], this.s[i + 1], Boolean(this.s[i + 2]), Number(this.s[i + 3]));
      this.passenger.push(tmp);
    }
  }
  getListTicketById(): void {
    this.seats.forEach(element => {
      this.ticketService.findById(element).subscribe(
        data => this.tickets.push(data)
      );
    });
  }
  saveTicketDetail(): void {
    var depatureDate = JSON.parse(sessionStorage.getItem('departureDate'));
    for (let i = 0; i < this.tickets.length; i++) {
      // tslint:disable-next-line:max-line-length
      let temp = new TicketDetail(depatureDate, this.passenger[i].lastName, this.passenger[i].firstName, this.passenger[i].gender, this.passenger[i].age, this.tickets[i].ticketId, this.tickets[i]);
      this.ticketDetails.push(temp);
    }
  }
  // note: string, userId: string
  add(): void {
    var cvv = this.secondFormGroup.get('CCV').value;
    if (cvv !== '') {
      this.showMessageSwal('success', 'Booking is successfuly')
      const newOrder: Order = new Order();
      newOrder.amount = this.amount;
      newOrder.user = this.curUser;
      this.saveTicketDetail();
      const orderData: OrderData = new OrderData();
      orderData.order = newOrder;
      orderData.ticketDetails = this.ticketDetails;
      this.orderService.save(orderData).subscribe();
    }

  }
}

