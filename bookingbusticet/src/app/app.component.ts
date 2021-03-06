import { Component, OnDestroy, OnInit } from '@angular/core';
import { User } from './models/user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnDestroy, OnInit{
  title = 'bookingbusticket';
  ngOnInit() {
  }
  ngOnDestroy(): void{
    localStorage.clear();
    sessionStorage.clear();
  }
}
