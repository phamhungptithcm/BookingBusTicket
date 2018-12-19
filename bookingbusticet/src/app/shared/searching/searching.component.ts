import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Province } from 'src/app/models/province';
import { Observable } from 'rxjs';
import { ProvinceServiceImp } from 'src/app/service/province/province.service';
import { startWith, map } from 'rxjs/operators';
import { Router } from '@angular/router';
import { Routes } from 'src/app/models/route';
import { RouteServiceImp } from 'src/app/service/route/route.service';
import { SweetAlert } from '../sweet-alert/sweet-alert';
import { DatePipe } from '@angular/common';
import { SubjectService } from 'src/app/service/helper/subject.service';
import { NgProgress } from 'ngx-progressbar';

@Component({
  selector: 'app-searching',
  templateUrl: './searching.component.html',
  styleUrls: ['./searching.component.css']
})
export class SearchingComponent extends SweetAlert implements OnInit {

  constructor(
    private provinceService: ProvinceServiceImp,
    private router: Router,
    private routeService: RouteServiceImp,
    private subjectService: SubjectService
  ) {
    super();
  }
  // // Lấy ngày hiện tại truyền lên tag input depatureDate
  curDate = new Date();
  minDate = this.curDate;
  // Form Control
  fromControl = new FormControl();
  toControl = new FormControl();
  // Array province
  froms: Province[] = [];
  tos: Province[] = [];

  // Array async
  filteredFroms: Observable<Province[]>;
  filteredTos: Observable<Province[]>;

  // province
  from: Province = null;

  // route
  route: Routes;
  keyTo: string;
  ngOnInit() {
    this.findAllFrom();
  }

  findAllFrom(): void {
    this.provinceService.findAll().subscribe(data => {
      this.froms = data;
      this.filteredFroms = this.fromControl.valueChanges
        .pipe(
          startWith<string | Province>(''),
          map(value => typeof value === 'string' ? value : value.provinceName),
          map(name => name ? this._filter(name, true) : this.froms.slice())
        );
    });
  }
  findAllTo(from: Province): void {
    this.from = from;
    this.provinceService.findProvinceTo(from.provinceId).subscribe(
      data => {
        this.tos = data;
        this.filteredTos = this.toControl.valueChanges
          .pipe(
            startWith<string | Province>(''),
            map(value => typeof value === 'string' ? value : value.provinceName),
            map(name => name ? this._filter(name, false) : this.tos.slice())
          );
      });

  }
  // tslint:disable-next-line:no-shadowed-variable
  displayFrom(from?: Province): string | undefined {
    return from ? from.provinceName : undefined;
  }
  displayTo(to?: Province): string | undefined {
    return to ? to.provinceName : undefined;
  }
  private _filter(name: string, stt: boolean): Province[] {
    const filterValue = name.toLowerCase();
    if (stt === false) {
      return this.tos.filter(province => province.provinceName.toLowerCase().indexOf(filterValue) === 0);
    }
    return this.froms.filter(province => province.provinceName.toLowerCase().indexOf(filterValue) === 0);
  }
  findRoute(to: number): void {
    this.routeService.findByFromAndTo(this.from.provinceId, to).subscribe(
      data => this.route = data
    );
  }
  clickSearching(): void {
    let sdate = (<HTMLInputElement>document.getElementById('iddate')).value;
    sessionStorage.removeItem('departureDate');
    if (this.route !== null) {
      sessionStorage.setItem('departureDate', JSON.stringify(sdate)); 
      this.router.navigate([`/trip/${this.route.routeId}`]);
      this.subjectService.searched();
    }
  }
  onChangeFrom() {
    this.route = null;
    this.filteredTos = null;
    this.keyTo = '';
  }
}
