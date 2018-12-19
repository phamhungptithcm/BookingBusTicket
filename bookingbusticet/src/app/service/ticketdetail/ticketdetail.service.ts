import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { TicketDetail } from 'src/app/models/ticketdetail';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { tap, catchError } from 'rxjs/operators';
import { URLServer } from 'src/app/shared/urlserver';
import { Pager } from 'src/app/models/pager';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class TicketdetailServiceImp extends URLServer{
  findAll(): Observable<TicketDetail[]> {
    const url = `${this.ticketDetailsUrlFS}?${this.tokenUrl}`;
    return this.http.get<TicketDetail[]>(url).pipe(
      tap(data => console.log(`data = ${JSON.stringify(data)}`)),
      catchError(error => of([]))
    );
  }
  constructor(private http: HttpClient) { 
    super()
  }
  update(entity: TicketDetail): Observable<any> {
    const url = `${this.userUrlFU}/ticketdetail/update`;
    return this.http.put<any>(url,JSON.stringify(entity),httpOptions).pipe(
      tap(),
      catchError(error => of(null))
    );
  }

  filterByBus(val: any): Observable<TicketDetail[]> {
    const url = `${this.ticketDetailsUrlFS}/busId=${val}?${this.tokenUrl}`;
    return this.http.get<TicketDetail[]>(url).pipe(
      tap(data => console.log(`data = ${JSON.stringify(data)}`)),
      catchError(error => of([]))
    );
  }
  searchTicketsByName(typedString: string): Observable<TicketDetail[]> {
    const url = `${this.ticketDetailsUrlFS}/name?name=${typedString}&${this.tokenUrl}`
    return this.http.get<TicketDetail[]>(url);
  }
  findTicketDetailsByDepartureDate(date: string): Observable<TicketDetail[]> {
    const url = `${this.ticketDetailsUrlFS}/dd?departure-date=${date}&${this.tokenUrl}`;
    return this.http.get<TicketDetail[]>(url).pipe(
      tap(data => console.log(`data = ${JSON.stringify(data)}`)),
      catchError(error => of([]))
    );
  }
  deleteTicketDetailById(id: number): Observable<any> {
    const url = `${this.ticketDetailsUrlFS}/delete/${id}?${this.tokenUrl}`// DELETE api/heroes/42
    alert(url);
    return this.http.delete<any>(url, httpOptions);
  }

  getPagingTicketDetails(pageNumber:number): Observable<Pager>{
      const url = `${this.ticketDetailsUrlFS}/page?page=${pageNumber}&size=15&${this.tokenUrl}`;
      return  this.http.get<Pager>(url)
  }

  getPagingTicketDetailsByBusId(pageNumber:number,busId:number): Observable<Pager>{
    
      const url = `${this.ticketDetailsUrlFS}/page-bus?page=${pageNumber}&size=20&busId=${busId}&${this.tokenUrl}`;
      return  this.http.get<Pager>(url).pipe();
  }
  updateTicketDetail(firstName,lastName,id): Observable<any> {
    //http://localhost:8080/staff/booked/update?lastName=DinhCongLuan&firstName=LuanDC&id=90
    const url = `${this.ticketDetailsUrlFS}/update?lastName=${lastName}&firstName=${firstName}&id=${id}&${this.tokenUrl}`;
    return this.http.put<any>(url, httpOptions);
  }
  getPagingTicketDetailsByName(pageNumber:number,name:string):Observable<Pager>{
  const url =`${this.ticketDetailsUrlFS}/name?name=${name}&page=${pageNumber}&size=10&${this.tokenUrl}`;
  return this.http.get<any>(url)
  }

  createTicketDetail(ticketDetail:TicketDetail):Observable<any>{
    const url =`${this.ticketDetailsUrlFS}/create?${this.tokenUrl}`;
    return this.http.post(url,ticketDetail);
  }

  cancelBookedTicket(date:string,ticketId:number):Observable<any>{
    const url = `${this.ticketDetailsUrlFS}/delete/dni?date=${date}&ticketId=${ticketId}&${this.tokenUrl}`;
    return this.http.put<any>(url,httpOptions);
}
}
