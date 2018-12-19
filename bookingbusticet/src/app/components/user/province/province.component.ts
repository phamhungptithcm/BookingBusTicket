import { Component, OnInit, Input } from '@angular/core';
import { Province } from 'src/app/models/province';

@Component({
  selector: 'app-province',
  templateUrl: './province.component.html',
  styleUrls: ['./province.component.css']
})
export class ProvinceComponent implements OnInit {
  @Input() provinces: Province[];
  constructor() { }

  ngOnInit() {
  }

}
