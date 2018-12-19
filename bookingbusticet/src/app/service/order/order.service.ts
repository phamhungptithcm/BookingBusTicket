import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Order } from 'src/app/models/order';
import { Observable, of } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import { TicketDetail } from 'src/app/models/ticketdetail';
import { OrderData } from 'src/app/models/helper/order-data';
import { URLServer } from 'src/app/shared/urlserver';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class OrderServiceImp  extends URLServer{
  constructor(private http: HttpClient) { 
    super()
  }
  findAll(): Observable<Order[]> {
    return null;
  }
  findById(id: number): Observable<Order> {
    return null;
  }
  delete(id: number): Observable<Order> {
    return null;
  }
  save(orderData: OrderData): Observable<Order> {
    const url = `${this.orderUrlFU}/checkout`;
    return this.http.post<Order>(url,JSON.stringify(orderData),httpOptions).pipe(
      tap(),
      catchError(error => of(new Order())
      )
    );
  }
  update(order: Order): Observable<any> {
    return null;
  }
  createOrder(order: Order):Promise<any>{
    // const url="http://localhost:8080/staff/order/create";
    const url = `${this.domain}/staff/order/create?${this.tokenUrl}`
    return this.http.post<Order>(url,order).toPromise();
    
  }
}
