import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserService } from 'src/app/service/user/user.service';
import { SweetAlert } from '../../sweet-alert/sweet-alert';

declare var UIkit: any;
@Component({
  selector: 'app-forgot',
  templateUrl: './forgot.component.html',
  styleUrls: ['./forgot.component.css']
})
export class ForgotComponent extends SweetAlert implements OnInit {

  constructor(private userService: UserService) {
    super();
  }
  forgotForm = new FormGroup({
    username: new FormControl('', Validators.required),
    email: new FormControl('', Validators.required)
  });
  ngOnInit() {
  }
  eventForgot() {
    const username = this.forgotForm.get('username').value;
    const email = this.forgotForm.get('email').value;
    if (username !== '' && email !== '') {
      this.userService.forgot(username, email).then(data => {
        if (!data) {
          this.showMessageToastCenter('error', 'Error username or email. Please check again!');
          return;
        }
        else {
          UIkit.modal(`#modal-forgot`).hide();
          this.forgotForm.reset();
          this.showMessageSwalCenter('success', 'Successfuly!Password sent to your email!')
        }
      });
    }
    else if (username === '') {
      this.showMessageToastCenter('error', 'Username is requied');
      return;
    }
    else {
      this.showMessageToastCenter('error', 'Email is requied');
    }
  }
}
