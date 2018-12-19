import { Component, OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class StaffHomeComponent implements OnInit {
  pipe;
  constructor() { }

  ngOnInit() {
    var today = new Date();
    console.log(today);
    this.pipe = new DatePipe('en-US');
    var now = localStorage.getItem("original-date")
    var someday = new Date()
    someday = this.pipe.transform(now, 'dd/MM/yyyy');
    console.log("s : " + someday);
    today = this.pipe.transform(today, 'dd/MM/yyyy');
    console.log("today : " + today);
    convertDate(today);
    convertDate(someday);



  }

}
function convertDate(d) {
  var parts = d.split('/');
  return new Date(parts[2], parts[1], parts[0]);
}


