import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Login } from 'src/app/models/helper/login';
import { Observable, of } from 'rxjs';
import { User } from 'src/app/models/user';
import { tap, catchError } from 'rxjs/operators';
import { TicketDetail } from 'src/app/models/ticketdetail';
import { URLServer } from 'src/app/shared/urlserver';

@Injectable({
  providedIn: 'root'
})
export class UserService extends URLServer {
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded',
      'Authorization': 'Basic ' + btoa('bookingbus:1')
    })
  };
  private httpOptionsUser = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json; charset=utf-8' })
  };
  constructor(private http: HttpClient) {
    super();
  }
  // CUSTOMER HUNGP7
  getUserById(account: Login): Observable<any> {
    const url = `${this.userUrlFU}/login`;
    return this.http.put(url, JSON.stringify(account), this.httpOptions).pipe(
      tap(),
      catchError(error => of(null))
    );
  }
  forgot(username: string, email: string): Promise<any>{
    const url =`${this.userUrlFU}/forgot?email=${email}&username=${username}`;
    return this.http.put(url,null,this.httpOptions).toPromise();
  }
  save(user: User): Observable<any> {
    const url = `${this.userUrlFU}/register`;
    return this.http.post(url, JSON.stringify(user), this.httpOptionsUser).pipe(
      tap(),
      catchError(error => of(new User()))
    );
  }
  findAllTicketByUserId(id: number): Observable<TicketDetail[]> {
    const url = `${this.userUrlFU}/ticket/viewall?id=${id}`;
    return this.http.get<TicketDetail[]>(url).pipe(
      tap(),
      catchError(error => of([]))
    );
  }
  findTicketByUserIdAndCurDate(id: number): Observable<TicketDetail[]> {
    const url = `${this.userUrlFU}/ticket/cancel?id=${id}`;
    return this.http.get<TicketDetail[]>(url).pipe(
      tap(),
      catchError(error => of([]))
    );
  }
  update(user: User): Observable<any> {
    const url = `${this.userUrlFU}/update`;
    return this.http.put<any>(url, JSON.stringify(user), this.httpOptionsUser).pipe(
      tap(),
      catchError(error => of(new User()))
    );
  }
  saveToken(tokenName: string, tokenValue: string) {
    localStorage.setItem(tokenName, tokenValue);
  }
  getToken(tokenName: string) {
    return localStorage.getItem(tokenName);
  }
  isLogged() {
    return this.getToken('access_token') !== null;
  }
  loginBody(user: Login): Observable<any> {
    let body = new URLSearchParams;
    body.set('username', user.userName);
    body.set('password', user.password);
    body.set('grant_type', 'password');
    return this.http.post(this.oauthTokenUrl, body.toString(), this.httpOptions);
  }
  loginUser(user: Login): Observable<any> {
    const url = `${this.userUrlFU}/login`;
    return this.http.post(url, JSON.stringify(user), this.httpOptionsUser).pipe(
      tap(),
      catchError(error => of(null))
    );
  }
  logout() {
    localStorage.removeItem('access_token');
    localStorage.removeItem('expires_in');
    localStorage.removeItem('refresh_token');
    sessionStorage.removeItem('user');
  }
  // ADMIN HIENLT16
  createUser(user: User): Observable<User> {
    const url = `${this.usersUrlFA}/add?${this.tokenUrl}`;
    return this.http.post<User>(url, user, this.httpOptionsUser);
  }

  listAllUserName(): Observable<string[]> {
    const url = `${this.usersUrlFA}/add?${this.tokenUrl}`;
    return this.http.get<string[]>(url).pipe(
      tap(data => console.log(`data = ${JSON.stringify(data)}`)),
      catchError(error => of([]))
    );
  }

  findByUserId(id: number): Observable<User> {
    const url = `${this.usersUrlFA}/${id}?${this.tokenUrl}`;
    return this.http.get<User>(url).pipe(
      tap(data => console.log(`data = ${JSON.stringify(data)}`)),
      catchError(error => of(null))
    );
  }

  findUserPagination(pageIn: number, size: number): Observable<any> {
    const url = `${this.usersUrlFA}/?pageIn=${pageIn}&size=${size}&${this.tokenUrl}`;
    return this.http.get<any>(url).pipe(
      tap(data => console.log(data.content)),
      catchError(error => of([]))
    );
  }

  filterByRolePagination(roleId: any, pageIn: number, size: number): Observable<any> {
    const url = `${this.usersUrlFA}/filter?roleId=${roleId}&pageIn=${pageIn}&size=${size}&${this.tokenUrl}`;
    return this.http.get<any>(url).pipe(
      tap(data => console.log(data.content)),
      catchError(error => of([]))
    );
  }

  findByUserNamePagination(userName: string, pageIn: number, size: number): Observable<any> {
    const url = `${this.usersUrlFA}/findByUserName/${userName}?page=${pageIn}&size=${size}&${this.tokenUrl}`;
    return this.http.get<any>(url).pipe(
      tap(data => console.log(data.content)),
      catchError(error => of([]))
    );
  }

  findByEmailPagination(email: string, pageIn: number, size: number): Observable<any> {
    const url = `${this.usersUrlFA}/findByEmail/${email}?page=${pageIn}&size=${size}&${this.tokenUrl}`;
    return this.http.get<any>(url).pipe(
      tap(data => console.log(data.content)),
      catchError(error => of([]))
    );
  }
  findByUserName(username:string):Observable<any>{
    //http://localhost:8080/staff/booked/userbyname?username=cus01&access_token
    const url = `${this.ticketDetailsUrlFS}/userbyname?username=${username}&${this.tokenUrl}`
    return this.http.get(url);
  }
}
