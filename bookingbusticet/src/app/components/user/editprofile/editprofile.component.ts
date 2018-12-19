import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/service/user/user.service';
import { SweetAlert } from 'src/app/shared/sweet-alert/sweet-alert';

@Component({
  selector: 'app-editprofile',
  templateUrl: './editprofile.component.html',
  styleUrls: ['./editprofile.component.css']
})
export class EditprofileComponent extends SweetAlert implements OnInit {
  constructor(private userService: UserService) {
    super();
  }
  curUser: User;
  newUser: User = new User();

  ngOnInit() {
    this.curUser = JSON.parse(sessionStorage.getItem('user'));
  }
  updateUser(): void {
    let fullname = (<HTMLInputElement>document.getElementById('fullname')).value;
    let date = (<HTMLInputElement>document.getElementById('date')).value;
    let phone = (<HTMLInputElement>document.getElementById('phone')).value;
    let email = (<HTMLInputElement>document.getElementById('email')).value;
    let address = (<HTMLInputElement>document.getElementById('address')).value;
    let gender = (<HTMLInputElement>document.getElementById('gender')).value;
    this.newUser.userId = this.curUser.userId;
    this.newUser.userName = this.curUser.userName;
    this.newUser.fullName = fullname;
    this.newUser.dateOfBirth = null;
    this.newUser.phoneNum = phone;
    this.newUser.email = email;
    this.newUser.address = address;
    this.newUser.gender = Boolean(gender);
    this.userService.update(this.newUser).subscribe(
      data => {
        console.log(data);
        if (data !== null) {
          this.showMessageToast('success', 'Successfuly');
        }
      });
  }
}
