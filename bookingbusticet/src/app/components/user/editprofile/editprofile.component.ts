import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MessageToast } from 'src/app/messages/toast.message';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/service/user/user.service';
import { SweetAlert } from 'src/app/shared/sweet-alert/sweet-alert';

@Component({
  selector: 'app-editprofile',
  templateUrl: './editprofile.component.html',
  styleUrls: ['./editprofile.component.css']
})
export class EditprofileComponent extends SweetAlert implements OnInit {

  formUser: FormGroup;

  constructor(private userService: UserService, private fb: FormBuilder) {
    super();
  }
  curUser: User;
  newUser: User = new User();

  ngOnInit() {
    this.curUser = JSON.parse(sessionStorage.getItem('user'));
    this.formUser = this.fb.group({
      userId: [this.curUser.userId, [Validators.required]],
      userName: [this.curUser.userName],
      fullName: [this.curUser.fullName ],
      dateOfBirth: [this.curUser.dateOfBirth ],
      phoneNum: [this.curUser.phoneNum ],
      email: [this.curUser.email],
      address: [this.curUser.address],
      gender: [this.curUser.gender],
      password: [''],
      rePassword: [''],
      userRole: [this.curUser.userRole]
    });
  }
  updateUser(): void {
    const data = this.formUser.value;
    if(data.password !== data.rePassword && data.password !== ''){
      this.showMessageToast('warning', MessageToast.MESSAGE_TITLE_PASSWORD_NOT_MATCH);
      return;
    }
    console.log(this.formUser.value);
    
    data.userId = this.curUser.userId;
    data.email =this.curUser.email
    this.userService.update(data).subscribe(
      data => {
        console.log(data);
        if (!!data && data !== {}) {
          sessionStorage.setItem('user', JSON.stringify(data));

          this.showMessageToast('success', MessageToast.MESSAGE_TITLE_UPDATE_USER_SUCCESS);
        }
      });
  }
}
