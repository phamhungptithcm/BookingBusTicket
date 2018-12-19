import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import {Ticket} from '../../models/ticket';
import { TicketAndStatus } from 'src/app/models/helper/TicketAndStatus';
import { URLServer } from 'src/app/shared/urlserver';

@Injectable({
  providedIn: 'root'
})
export class TicketServiceImp extends URLServer{
  constructor(private http: HttpClient) {
    super()
   }
  findByBusId(date: Date,id: number): Observable<TicketAndStatus[]> {
    const url = `${this.ticketUrlFU}/bus?id=${id}&date=${date}`;
    return this.http.get<TicketAndStatus[]>(url).pipe(
      tap(),
      catchError(error => of([]))
    );
  }
  findById(id: number): Observable<Ticket> {
    const url = `${this.ticketUrlFU}?id=${id}`;
    return this.http.get<Ticket>(url).pipe(
      tap(),
      catchError(error => of(new Ticket()))
    );
  }





  private TicketsUrl = "http://localhost:8080/staff/tickets/"
  
  findByBusIdKhai(busId: number,date:string): Observable<Ticket[]> {
    
    const url = `${this.TicketsUrl}date?date=${date}&bId=${busId}&${this.tokenUrl}`
     return this.http.get<Ticket[]>(url)
    
  }
  getTicketQuantity():Observable<number>{
    const url = `${this.TicketsUrl}count`;
    return this.http.get<number>(url);
  }
  findAll():Observable<Ticket[]>{
    return this.http.get<Ticket[]>(this.TicketsUrl)
  }
}
