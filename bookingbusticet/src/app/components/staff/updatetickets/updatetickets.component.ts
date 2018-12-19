import { Component, OnInit } from '@angular/core';
import { ProvinceServiceImp } from 'src/app/service/province/province.service';
import { Routes } from 'src/app/models/route';
import { RouteServiceImp } from 'src/app/service/route/route.service';
import { MatDatepickerInputEvent } from '@angular/material';
import { Trip } from 'src/app/models/trip';
import { TripServiceImp } from 'src/app/service/trip/trip.service';
import { FormControl,FormGroup,FormBuilder, Validators } from '@angular/forms';
import { DataService } from 'src/app/service/data.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-updatetickets',
  templateUrl: './updatetickets.component.html',
  styleUrls: ['./updatetickets.component.css']
})
export class UpdateticketsComponent implements OnInit {
  displayedColumns: string[] = ['tripId', 'departureTime', 'arrivalTime','View'];
  provincesFrom;
  provincesTo;
  pipe;
  date:string;
  formattedDate;
  chosenDate: Date
  selectedValue = null;
  selectedValue1 = null;
  route: Routes;
  trips: Trip[];
  formS:FormGroup;



  constructor(private provinceServiceImp: ProvinceServiceImp,
    private routeServiceImp: RouteServiceImp,
    private dataService:DataService,
    private tripServiceImp: TripServiceImp,
    private formBuilder:FormBuilder) { }

  ngOnInit() {
    this.formS=this.formBuilder.group({
      controlProvince:'',
      controlProvince2:'',
      controlDate:''
    })
    this.provinceServiceImp.findAllKhai().subscribe(
      data => this.provincesFrom = data
    )
    this.dataService.currentMessage.subscribe(message => this.date = message)
    
  }

  onChange(val: any) {
    this.provinceServiceImp.findbyProvincesFrom(val).subscribe(
      data => this.provincesTo = data
    )
  }




  addEvent(event: MatDatepickerInputEvent<Date>) {
    this.pipe = new DatePipe('en-US');
    const now = `${event.value}`;
    const myFormattedDate = this.pipe.transform(now, 'yyyy-MM-dd');  
    localStorage.setItem("original-date",now);  
    console.log(now)
    this.dataService.changeMessage(myFormattedDate)
    localStorage.setItem("date",myFormattedDate)
    console.log(myFormattedDate)

  }




  onProvincesSelected() {
    this.routeServiceImp.findRouteByProvinces(this.formS.value.controlProvince, this.formS.value.controlProvince2).subscribe(
      data => this.route = data
    )
  }
  
  search(){
      this.tripServiceImp.findAllByRouteId(this.route.routeId).subscribe(
        data => this.trips =data
      )
      
  }


  selectedTrip: Trip;
  clickSelected(t: Trip): void{
    this.selectedTrip = t;
  }



  

}
