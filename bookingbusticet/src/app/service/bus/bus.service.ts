import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { Bus } from '../../models/bus';
import { URLServer } from 'src/app/shared/urlserver';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class BusServiceImp extends URLServer{
  constructor(private http: HttpClient) {
    super();
   }
  findByTripId(id: number): Observable<Bus> {
    const url = `${this.busUrlFU}/trip?id=${id}`;
    return this.http.get<Bus>(url).pipe(
      tap(),
      catchError(error => of(new Bus()))
    );
  }

  

  private  BASE_BUS_URL="http://localhost:8080/staff/"

  findAll(): Observable<Bus[]> {
    const url = `${this.BASE_BUS_URL}buses?${this.tokenUrl}`
    return this.http.get<Bus[]>(url).pipe(
      tap(data => console.log(`data = ${JSON.stringify(data)}`)),
      catchError(error => of([]))
    );
  }

}
