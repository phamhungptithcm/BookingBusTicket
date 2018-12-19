import { Identifiers } from "@angular/compiler";
import { User } from "./user";
import { OrderStatus } from "./orderstatus";

export class Order {
    orderId: number;
	amount: number;
	orderDate: Date;
	lastUpdate: Date;
    note: string;
    user: User = new User();
    orderStatus: OrderStatus;
    constructor(){};
}