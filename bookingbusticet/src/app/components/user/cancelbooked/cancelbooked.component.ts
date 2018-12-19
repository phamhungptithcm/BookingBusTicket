import { Component, OnInit } from '@angular/core';
import { TicketDetail } from 'src/app/models/ticketdetail';
import { UserService } from 'src/app/service/user/user.service';
import { User } from 'src/app/models/user';
import { TicketServiceImp } from 'src/app/service/ticket/ticket.service';
import { TicketdetailServiceImp } from 'src/app/service/ticketdetail/ticketdetail.service';
import { SubjectService } from 'src/app/service/helper/subject.service';
import { SweetAlert } from 'src/app/shared/sweet-alert/sweet-alert';

@Component({
  selector: 'app-cancelbooked',
  templateUrl: './cancelbooked.component.html',
  styleUrls: ['./cancelbooked.component.css']
})
export class CancelbookedComponent extends SweetAlert implements OnInit {
  ticketDetails: TicketDetail[];
  curUser: User;
  constructor(
    private userService: UserService,
    private ticketDetailService: TicketdetailServiceImp,
    private subjectService: SubjectService
  ) { 
    super()
  }
  ngOnInit() {
    this.curUser = JSON.parse(sessionStorage.getItem('user'));
    this.subjectService.getStatusTicketDetail().subscribe(isCancel => {
      this.userService.findTicketByUserIdAndCurDate(this.curUser.userId).subscribe(
        data => this.ticketDetails = data
      );
    });
    this.userService.findTicketByUserIdAndCurDate(this.curUser.userId).subscribe(
      data => this.ticketDetails = data
    );
  }
  updateStatus(entity: TicketDetail): void {
    this.ticketDetailService.update(entity).subscribe(
      data => {
        if (data !== null) {
          this.showMessageToastCenter('success','Canceled successfuly!')
          this.subjectService.canceled();
        }
      }
    );
  }
}
