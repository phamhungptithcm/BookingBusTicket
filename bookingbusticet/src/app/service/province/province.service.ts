import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { Province } from '../../models/province';
import { URLServer } from 'src/app/shared/urlserver';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class ProvinceServiceImp extends URLServer{

  constructor(private http: HttpClient) {
    super()
   }

  findAll(): Observable<Province[]> {
    return this.http.get<Province[]>(this.provinceUrlFU).pipe(
      tap(),
      catchError(error => of([]))
    );
  }
  findById(id: number): Observable<Province> {
    const url = `${this.provinceUrlFU}/${id}`;
    return this.http.get<Province>(url).pipe(
      tap(),
      catchError(error => of(new Province()))
    );
  }
  delete(id: number): Observable<Province> {
    return null;
  }
  save(province: Province): Observable<Province> {
    return null;
  }
  update(province: Province): Observable<any> {
    return null;
  }
  findProvinceTo(id: number): Observable<Province[]> {
    const url = `${this.provinceUrlFU}/${'provincet'}?&id=${id}`;
    return  this.http.get<Province[]>(url).pipe(
      tap(),
      catchError(error => of([]))
    );
  }

  findAllKhai(): Observable<Province[]> {
    const url = `${this.domain}/staff/provinces?${this.tokenUrl}`
    return this.http.get<Province[]>(url).pipe(
      tap(data => console.log(`data = ${JSON.stringify(data)}`)),
      catchError(error => of([]))
    );
  }


  findbyProvincesFrom(val:number):Observable<Province[]>{
    const url = `${this.domain}/staff/provinces/provinceFrom=${val}?${this.tokenUrl}`
    return this.http.get<Province[]>(url).pipe(
      tap(data =>`data=${JSON.stringify(data)}`),
      catchError(error=>of([])));
  }




}
