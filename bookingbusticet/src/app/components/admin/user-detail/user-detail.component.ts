import { Component, OnInit, Input, Inject } from '@angular/core';
import { User } from '../../../models/user';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { UserService } from 'src/app/service/user/user.service';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {

  @Input() user: User;
  constructor(
    private route: ActivatedRoute,
    private userService: UserService,
    private location: Location,
    public dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.getUser();
  }

  getUser(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.userService.findByUserId(id)
      .subscribe(user => this.user = user);
  }

  onSubmit() {
    this.userService.createUser(this.user)
      .subscribe(data => {
        alert("Update User successfully.");
      });
  }

  goBack(): void {
    this.location.back();
  }

  openChangePassDialog(): void {
    const dialogRef = this.dialog.open(ChangePasswordDialog, {
      height: '400px',
      width: '600px',
      data: {name: this.user.fullName, password: ''}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(`The dialog was closed`);
      if (result != "" && result != null) {
        this.user.password = result;
        this.onSubmit();
      }     
    });
  }
}

@Component({
  selector: 'change-password-dialog',
  templateUrl: './change-password-dialog.html',
  styleUrls: ['./user-detail.component.css']
})
export class ChangePasswordDialog {

  constructor(
    public dialogRef: MatDialogRef<ChangePasswordDialog>,
    @Inject(MAT_DIALOG_DATA) public data: UserDetailComponent) { }

}