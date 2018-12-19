import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm, FormGroup, FormBuilder, FormControl, Validators, FormGroupDirective } from '@angular/forms';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/service/user/user.service';
import { SweetAlert } from '../sweet-alert/sweet-alert';
import { Login } from 'src/app/models/helper/login';
import { SubjectService } from 'src/app/service/helper/subject.service';
import { ErrorStateMatcher } from '@angular/material';

declare var UIkit: any;
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const invalidCtrl = !!(control && control.invalid && control.parent.dirty);
    const invalidParent = !!(control && control.parent && control.parent.invalid && control.parent.dirty);

    return (invalidCtrl);
  }
}
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent extends SweetAlert implements OnInit {
  matcher = new MyErrorStateMatcher();
  constructor(
    private userService: UserService,
    private _formBuilder: FormBuilder,
    private subjectService: SubjectService
  ) {
    super();
  }
  signup: FormGroup;

  ngOnInit() {
    this.vaidateRegister();
  }
  curUser: User = null;
  acc: Login = null;
  signupForm() {
    const user = new User();
    user.userName = this.signup.get('userName').value;
    user.gender = this.signup.get('gender').value;
    user.email = this.signup.get('email').value;
    user.dateOfBirth = this.signup.get('dateOfBirth').value;
    user.fullName = this.signup.get('fullName').value;
    user.password = this.signup.get('password').value;
    user.phoneNum = this.signup.get('phoneNum').value;
    user.userRole = 1;
    this.userService.save(user).subscribe(
      register => {
        this.acc =  new Login(register.userName, register.password);
        if (register !== null || register !== undefined) {
          this.showMessageToast('success', 'Sign Up Successfuly!');
          this.signup.reset();
          UIkit.modal(`#modal-signup`).hide();
          UIkit.modal('#modal-login').show();
        } else {
          this.showMessageToastCenter('error', 'Sign up fail');
          return;
        }
      });
  }
  vaidateRegister(): void {
    let password = new FormControl('', Validators.compose([
      Validators.required, Validators.minLength(8),
      Validators.pattern('^[a-zA-Z0-9]+$')
    ]));
    let email = new FormControl('', Validators.compose([
      Validators.required,
      Validators.email
    ]));
    let userName = new FormControl('', Validators.compose([
      Validators.required, Validators.minLength(3),
      Validators.pattern('^[a-zA-Z0-9]+$')
    ]));
    let fullName = new FormControl('', Validators.compose([
      Validators.required, Validators.minLength(5)
    ]));
    let dateOfBirth = new FormControl('', Validators.compose([
      Validators.required
    ]));
    let confirmPassword = new FormControl('', Validators.compose([
      Validators.required
    ]));
    let phoneNum = new FormControl('', Validators.compose([
      Validators.required, Validators.minLength(10), Validators.maxLength(20),
      Validators.pattern('^[0-9]+$')
    ]));
    this.signup = new FormGroup({
      password: password,
      email: email,
      userName: userName,
      fullName: fullName,
      dateOfBirth: dateOfBirth,
      confirmPassword: confirmPassword,
      phoneNum: phoneNum,
      gender: new FormControl()
    }, {validators: this.checkPasswords });
  }
  checkPasswords(group: FormGroup) { // here we have the 'passwords' group
    let pass = group.controls.password.value;
    let confirmPass = group.controls.confirmPassword.value;
    return pass === confirmPass ? null : { notSame: true }
  }
}
