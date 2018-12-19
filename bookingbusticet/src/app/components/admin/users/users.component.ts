import { Component, OnInit, ViewChild } from '@angular/core';
import { User } from '../../../models/user';
import { UserService } from '../../../service/user/user.service';
import { MatPaginator, MatTableDataSource, PageEvent } from '@angular/material';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  displayedColumns: string[] = ['userName', 'userRole', 'fullName', 'email', 'userId'];

  //Pagination
  users: any[];
  totalElements: number;
  currentPage: number = 1;
  size: number = 7;

  //Filter
  roleIdModel: string = "";

  //Search
  userNameSearch: string = "";
  emailSearch: string = "";

  // @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(
    private userService: UserService
  ) { }

  ngOnInit() {
    this.getUserPagination(this.currentPage, this.size);
  }

  changePage(event) {
    if (this.roleIdModel == "1" || this.roleIdModel == "2" || this.roleIdModel == "3") {
      this.filterByRolePagination(this.roleIdModel, event, 7);
      console.log(`aaaaa ${this.roleIdModel}`);
    } else if (this.userNameSearch != "") {
      this.findByEmailPagination(this.userNameSearch, event, 7);
    } else if (this.emailSearch != "") {
      this.findByEmailPagination(this.emailSearch, event, 7);
    } else {
      this.getUserPagination(event, 7);
      console.log(`bbbbb ${this.roleIdModel}`);
    }
  }

  getUserPagination(pageIn: number, size: number): void {
    this.userService.findUserPagination(pageIn - 1, size)
      .subscribe(data => {
        console.log(`haha ${pageIn}`);
        console.log(data.content);
        this.users = data.content;
        this.totalElements = data.totalElements;
        this.roleIdModel = "";
        this.userNameSearch = "";
        this.emailSearch = "";
      })
  }

  filterByRolePagination(roleId: any, pageIn: number, size: number): void {
    if (roleId == "1" || roleId == "2" || roleId == "3") {
      this.userService.filterByRolePagination(roleId, pageIn - 1, size)
        .subscribe(data => {
          console.log(`filter by role ${roleId}`);
          this.roleIdModel = roleId;
          this.users = data.content;
          this.totalElements = data.totalElements;
        })
    } else {
      this.getUserPagination(this.currentPage, this.size);
    }
  }

  findByUserNamePagination(userName: string, pageIn: number, size: number): void {
    this.userService.findByUserNamePagination(userName, pageIn - 1, size)
      .subscribe(data => {
        console.log(`find by username ${userName}`);
        this.users = data.content;
        this.totalElements = data.totalElements;
        this.roleIdModel = "";
        this.emailSearch = "";
      })
  }

  findByEmailPagination(email: string, pageIn: number, size: number): void {
    this.userService.findByEmailPagination(email, pageIn - 1, size)
      .subscribe(data => {
        console.log(`find by email ${email}`);
        this.users = data.content;
        this.totalElements = data.totalElements;
        this.roleIdModel = "";
        this.userNameSearch = "";
      })
  }

  // getUsers(): void {
  //   this.userService.findAll()
  //     .subscribe(users => { this.users = new MatTableDataSource<User>(users); this.users.paginator = this.paginator });
  // }

  // filterByRole(roleId: number): void {
  //   this.userService.filterByRole(roleId)
  //     .subscribe(users => { this.users = new MatTableDataSource<User>(users); this.users.paginator = this.paginator });
  // }

  // findByUserName(userName: string): void {
  //   this.userService.findByUserName(userName)
  //     .subscribe(users => { this.users = new MatTableDataSource<User>(users); this.users.paginator = this.paginator });
  // }

  // findByEmail(email: string): void {
  //   this.userService.findByEmail(email)
  //     .subscribe(users => { this.users = new MatTableDataSource<User>(users); this.users.paginator = this.paginator });
  // }

  roleIs(id: number): string {
    switch (id) {
      case 1:
        return 'Customer';

      case 2:
        return 'Staff';

      case 3:
        return 'Admin';
    }
  }



}
