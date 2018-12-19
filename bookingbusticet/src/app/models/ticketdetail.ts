import { Ticket } from "./ticket";
import { Order } from "./order";

export class TicketDetail {
	ticketDetailId: number;
	departureDate: string;
	lastName: string;
	firstName: string;
	gender: boolean;
	age: number;
	numSeat: number;
	lastUpdate: Date;
	status: boolean;
	ticket: Ticket;
	order: Order;
	constructor(
		departureDate: string, lastName: string,
		firstName: string, gender: boolean,
		age: number, seatNo: number,
		ticket: Ticket
	) {
		this.departureDate = departureDate;
		this.lastName = lastName;
		this.firstName = firstName;
		this.gender = gender;
		this.age = age;
		this.numSeat = seatNo;
		this.ticket = ticket;
	};
}