import { Injectable } from '@angular/core';
import { catchError, map, tap } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Routes } from '../../models/route';
import { Observable, of } from 'rxjs';
import { URLServer } from 'src/app/shared/urlserver';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class RouteServiceImp extends URLServer{

  constructor(private http: HttpClient) {
    super()
   }






  findByFromAndTo(from: number, to: number): Observable<Routes> {
    const url = `${this.routeUrlFU}/fromandto?from=${from}&to=${to}`;
    return this.http.get<Routes>(url).pipe(
      tap(),
      catchError(error => of(new Routes()))
    );;
  }



  private FIND_ROUTE_BY_PROVINCES_URl="http://localhost:8080/staff/route";
  findRouteByProvinces(fromId:number,toId:number): Observable<Routes>{
    const url = `${this.FIND_ROUTE_BY_PROVINCES_URl}?fId=${fromId}&tId=${toId}&${this.tokenUrl}`;

    return this.http.get<Routes>(url).pipe(
     tap(data => console.log(`data = ${JSON.stringify(data)}`))
    );
  }





}
