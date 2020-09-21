import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../service/userservice';

@Component({
  selector: 'user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent  {


  users:User[];

  constructor(private userService:UserService) {
    this.users=userService.allUsers();
   }

  eligibleColor:string="green";
  notEligibleColor:string="red";

  color:string="white";

  isEligible(age:number):boolean{
    return age>=21;
  }

  removeUser(id:number){
 this.userService.removeUser(id);
  }

}
