import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import swal, { SweetAlertType } from 'sweetalert2';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/user/user.service';
import { SubjectService } from 'src/app/service/helper/subject.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  curUser: User = null;
  constructor(private router: Router, private userService: UserService, private subjectService: SubjectService) { }

  ngOnInit() {
    this.subjectService.getObservable().subscribe(isLogin => {
      this.curUser = JSON.parse(sessionStorage.getItem('user'));
    });
    this.curUser = JSON.parse(sessionStorage.getItem('user'));
  }
  logout() {
    this.showMessage('success', 'Log Out Successfuly!');
    this.userService.logout();
    this.curUser = null;
    this.router.navigate(['/']);
  }
  showMessage(stt: SweetAlertType, value: string): void {
    const toast1 = swal.mixin({
      toast: true,
      position: 'top-end',
      showConfirmButton: false,
      timer: 3000
    });
    toast1({
      type: stt,
      title: value
    });
  }
  clickViewAll(): void {
    sessionStorage.setItem('nextUrl', '/user/viewall');
    this.router.navigate(['/user/viewall']);
  }
  clickCanceled(): void {
    sessionStorage.setItem('nextUrl', '/user/canceled');
    this.router.navigate(['/user/canceled']);
  }
}
