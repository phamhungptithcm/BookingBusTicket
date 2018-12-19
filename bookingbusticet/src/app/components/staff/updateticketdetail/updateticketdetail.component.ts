import { Component, OnInit, Input } from '@angular/core';
import { TicketDetail } from 'src/app/models/ticketdetail';
import { TicketdetailServiceImp } from 'src/app/service/ticketdetail/ticketdetail.service';


@Component({
  selector: 'app-updateticketdetail',
  templateUrl: './updateticketdetail.component.html',
  styleUrls: ['./updateticketdetail.component.css']
})
export class UpdateticketdetailComponent implements OnInit {
  @Input() ticketDetail: TicketDetail
  tick:TicketDetail

  constructor(private ticketDetailService:TicketdetailServiceImp) { }
  show=true;
  ngOnInit() {
    this.tick=this.ticketDetail
  }
  submit(id){
    alert(id);
    this.ticketDetailService.updateTicketDetail(this.tick.firstName,this.tick.lastName,this.tick.ticketDetailId).subscribe()
  }
 
}
