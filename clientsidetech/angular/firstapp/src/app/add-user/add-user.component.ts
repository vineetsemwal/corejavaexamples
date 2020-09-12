import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../service/userservice';

@Component({
  selector: 'add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent {

  userService:UserService;

  constructor(userService:UserService) {
     this.userService=userService;
   }

   user:User;

  addUser(form:any){
   let data=form.value;
  let salary=data.salary;
   let name=data.username;
   let age=data.age;
   this.user=new User(-1,name,age,salary);
  this.userService.addUser(this.user);
  }

}
