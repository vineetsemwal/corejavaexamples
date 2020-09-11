import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';

@Component({
  selector: 'add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent {

  constructor() { }

  user:User=undefined;

  addUser(form:any){
   let data=form.value;
  let salary=data.salary;
   let name=data.username;
   let age=data.age;
   this.user=new User(name,age,salary);
   console.log("user initialized="+this.user.age);
  }

}
