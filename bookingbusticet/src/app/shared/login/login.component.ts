import { Component, OnInit, ViewChild } from '@angular/core';
// import {
//   AuthService,
//   FacebookLoginProvider,
//   GoogleLoginProvider,
//   SocialUser
// } from 'angular5-social-login';
import { NgForm, FormGroup, FormControl, Validators } from '@angular/forms';
import { Login } from 'src/app/models/helper/login';
import { UserService } from 'src/app/service/user/user.service';
import { User } from 'src/app/models/user';
import { Router } from '@angular/router';
import { SweetAlert } from '../sweet-alert/sweet-alert';
import { SubjectService } from 'src/app/service/helper/subject.service';

import { CookieService } from 'ngx-cookie-service';

declare var UIkit: any;
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent extends SweetAlert implements OnInit {
  // user: SocialUser;
  curUser: User = null;
  uck: string = '';
  pck: string = '';
  loginForm = new FormGroup({
    userName: new FormControl(this.uck, Validators.required),
    password: new FormControl(this.pck, Validators.required),
    remember: new FormControl()
  });

  constructor(
    // private socialAuthService: AuthService,
    private userService: UserService,
    private router: Router,
    private subjectService: SubjectService,
    private cookieService: CookieService
  ) {
    super();
  }
  ngOnInit() {
    // this.socialAuthService.authState.subscribe((user) => {
    //   this.user = user;
    // });
    this.subjectService.getObservable().subscribe(isLogged => {
      this.uck = this.cookieService.get('uck');
      this.pck = this.cookieService.get('pck');
    })
    this.uck = this.cookieService.get('uck');
    this.pck = this.cookieService.get('pck');
  }
  // public socialSignIn(socialPlatform: string) {
  //   let socialPlatformProvider;
  //   if (socialPlatform === 'facebook') {
  //     socialPlatformProvider = FacebookLoginProvider.PROVIDER_ID;
  //   } else if (socialPlatform === 'google') {
  //     socialPlatformProvider = GoogleLoginProvider.PROVIDER_ID;
  //   }

  //   this.socialAuthService.signIn(socialPlatformProvider).then(
  //     (userData) => {
  //       console.log(socialPlatform + ' sign in data : ', userData);
  //       // Now sign-in with userData
  //     }
  //   );
  // }
  // signOut(): void {
  //   this.socialAuthService.signOut();
  // }
  login() {
    const username = this.loginForm.get('userName').value;
    const password = this.loginForm.get('password').value;
    console.log(username)
    const account = new Login(username, password);
    console.log(account)
    var remember: boolean = this.loginForm.get('remember').value;
    let nextUrl = sessionStorage.getItem('nextUrl');
    sessionStorage.removeItem('nextUrl');
    if (username !== '' && password !== '') {
      this.userService.loginUser(account).subscribe(data => {
        this.curUser = data;
        console.log(data);
        if (data !== null) {
          sessionStorage.setItem('user', JSON.stringify(this.curUser));
          if (remember === true) {
            this.cookieService.set('uck', username, 1);
            this.cookieService.set('pck', password, 1);
          }
          // tslint:disable-next-line:no-shadowed-variable
          this.userService.loginBody(account).subscribe(data => {
            this.userService.saveToken('access_token', data.access_token);
            this.userService.saveToken('refresh_token', data.refresh_token);
            this.userService.saveToken('expires_in', data.expires_in);
            this.subjectService.logged();
          });
          this.routerByRole(this.curUser.userRole);
          this.showMessageToast('success', 'Login successfuly!');
          this.loginForm.reset();
          UIkit.modal(`#modal-login`).hide();
          if (nextUrl !== null) {
            this.router.navigate([`${nextUrl}`]);
          }
        } else {
          this.showMessageToast('error', 'Login information is incorrect!');
          return;
        }
      });
    } if (username === '') {
      this.showMessageToast('error', 'Username is not requied');
      return;
    } else if (password === '') {
      this.showMessageToast('error', 'Password is not requied');
      return;
    }
  }
  routerByRole(role: number) {
    let curUrl = this.router.url;
    if (role !== 1) {
      switch (role) {
        case 3:
        window.location.reload();
          this.router.navigate(['/admin/users']);
          
          break;
        case 2:
        window.location.reload();
          this.router.navigate(['/staff/viewtickets']);
          
          break;
      }
    }
  }
}
