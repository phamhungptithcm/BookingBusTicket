import { Observable, of} from 'rxjs';
import { Ticket } from '../models/ticket';

export interface TicketSevice {
     // findAll(): Observable<Ticket[]>;
     findById(id: number): Observable<Ticket>;
     // delete(id: number): Observable<Ticket>;
     // save(ticket: Ticket): Observable<Ticket>;
     // update(ticket: Ticket): Observable<any>;
     findByBusId(id: number): Observable<Ticket[]>;
}