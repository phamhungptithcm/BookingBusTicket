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
