import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user/user.service';
import { TicketDetail } from 'src/app/models/ticketdetail';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-viewallbooked',
  templateUrl: './viewallbooked.component.html',
  styleUrls: ['./viewallbooked.component.css']
})
export class ViewallbookedComponent implements OnInit {
  ticketDetails: TicketDetail[];
  curUser: User;
  constructor(private userService: UserService) { }

  ngOnInit() {
    this.curUser = JSON.parse(sessionStorage.getItem('user'));
    this.findAllTicketByUserId();
  }
  findAllTicketByUserId(): void {
    this.userService.findAllTicketByUserId(this.curUser.userId).subscribe(
      data => {
      this.ticketDetails = data;
      });
  }
}
