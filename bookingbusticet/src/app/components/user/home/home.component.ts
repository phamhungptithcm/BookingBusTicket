import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  code: string = 'HDFC5X'
  constructor() { }

  ngOnInit() {
    localStorage.removeItem('seats');
    localStorage.removeItem('trip');
    sessionStorage.removeItem('departureDate');
  }

}
