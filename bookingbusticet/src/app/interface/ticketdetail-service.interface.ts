import { Observable, of} from 'rxjs';
import { TicketDetail } from '../models/ticketdetail';

export interface TicketDetailSevice {
     findAll(): Observable<TicketDetail[]>;
     findById(id: number): Observable<TicketDetail>;
     delete(id: number): Observable<TicketDetail>;
     save(ticketDetail: TicketDetail): Observable<TicketDetail>;
     update(ticketDetail: TicketDetail): Observable<any>;
}