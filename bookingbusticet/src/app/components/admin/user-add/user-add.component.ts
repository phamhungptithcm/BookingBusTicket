import { Component, OnInit, Directive } from '@angular/core';
import { User } from '../../../models/user';
import { ViewChild } from '@angular/core';
import { Location } from '@angular/common';
import { UserService } from 'src/app/service/user/user.service';

@Component({
  selector: 'app-user-add',
  templateUrl: './user-add.component.html',
  styleUrls: ['./user-add.component.css']
})
export class UserAddComponent implements OnInit {

  model: User = new User();
  userNameList: string[];
  alert: boolean;
  @ViewChild('f') form: any;

  constructor(
    private userService: UserService,
    private location: Location
  ) { }

  ngOnInit() {
    this.listAllUserName();

  }

  onSubmit() {
    this.userService.createUser(this.model)
      .subscribe(data => {
        alert("User created successfully.");
        this.form.reset();
      });
  }
  listAllUserName(): void {
    this.userService.listAllUserName()
      .subscribe(data => this.userNameList = data);
  }

  checkUserName(newUserName: string): void {
    for (let userName of this.userNameList) {
      if(newUserName === userName) {
        this.alert = true;
        return;
      }
    }
    this.alert = false;
  }

  goBack(): void {
    this.location.back();
  }

}
// function userNameDomainValidator(control: FormControl) {
//   let newUserName = control.value;

//   if (newUserName && this.userNameList.indexOf(newUserName) >= 0) {

//     return {
//       userNameDomain: {
//         parsedDomain: newUserName
//       }
//     }
//   }
//   return null;
// }

// @Directive({
//   selector: '[userNameDomain][ngModel]',
//   providers: [
//     {
//       provide: NG_VALIDATORS,
//       useValue: userNameDomainValidator,
//       multi: true
//     }
//   ]
// })


// export class UserNameDomainValidator {

// }

