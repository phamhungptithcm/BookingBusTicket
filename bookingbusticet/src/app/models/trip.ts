import { Bus } from './bus';
import { Routes } from './route';


export class Trip {
    tripId: number;
    departureTime: String;
    arrivalTime: String;
    lastUpdate: String;
    unitPrice: number;
    route: Routes;
    bus: Bus;
}