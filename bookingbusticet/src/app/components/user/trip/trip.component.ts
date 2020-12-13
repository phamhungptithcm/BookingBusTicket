import { Component, OnInit } from '@angular/core';
import { Trip } from '../../../models/trip';
import { TripServiceImp } from '../../../service/trip/trip.service';
import { ActivatedRoute, Route } from '@angular/router';
import { Location } from '@angular/common';
import { BusServiceImp } from 'src/app/service/bus/bus.service';
import { Bus } from 'src/app/models/bus';
import { Observable } from 'rxjs';
import { Routes } from 'src/app/models/route';
import { RouteServiceImp } from 'src/app/service/route/route.service';
import { Province } from 'src/app/models/province';
import { SubjectService } from 'src/app/service/helper/subject.service';

declare var UIkit: any;
@Component({
  selector: 'app-trip',
  templateUrl: './trip.component.html',
  styleUrls: ['./trip.component.css']
})
export class TripComponent implements OnInit {
  constructor(
    private tripService: TripServiceImp,
    private route: ActivatedRoute,
    private location: Location,
    private busService: BusServiceImp,
    private routeService: RouteServiceImp,
    private subjectService: SubjectService
  ) {
  }
  trips: Trip[] = [];
  bus: Bus = new Bus();
  sortBys = ['Early Departure', 'Late Departure', 'Lowest Price', 'Highest Price'];
  curSortBy = this.sortBys[0];
  from: Province = new Province();
  to: Province = new Province();
  departureDate: Date = null;
  listQuickFilter = ["Pickup after 6 PM",
  "Drop before 11 AM",
  "The most seats"
  ];
  listPrice = ["50.000 VNĐ - 150.000 VNĐ", 
"150.000 VNĐ - 250.000 VNĐ",
"250.000 VNĐ - 400.000 VNĐ",
"400.000 VNĐ - 600.000 VNĐ",
"600.000 VNĐ - 1.000.000 VNĐ",
"1.000.000 VNĐ - 2.000.000 VNĐ"
];
listPickupTime = [
  "Morning(6 AM to 12 PM)",
  "Afternoon(12 PM to 6 PM)",
  "Evening(6 PM to 12 AM)",
  "Night(12 AM to 6 AM)"
]
  public getTrip(): void {
    this.route.params.subscribe(id => {
      this.tripService.findByRouteId(id.routeId).subscribe(data => {
        this.trips = data;
        if (data !== null) {
            this.from = data[0].route.provinceFrom;
            this.to = data[0].route.provinceTo;
          }
      });
    })
  }
  getBusByTripId(id: number): Observable<Bus> {
    return this.busService.findByTripId(id);
  }
  ngOnInit() {
    this.getTrip();
    this.subjectService.getDeparture().subscribe(isSearch => {
      this.departureDate = JSON.parse(sessionStorage.getItem('departureDate'));
    });
    this.departureDate = JSON.parse(sessionStorage.getItem('departureDate'));
  }
  actionSortBy(key: string) {
    this.curSortBy = key;
  }
}
