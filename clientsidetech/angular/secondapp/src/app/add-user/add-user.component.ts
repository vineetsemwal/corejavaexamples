import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { UserService } from '../service/userservice';

@Component({
  selector: 'add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent {

  constructor(private userService:UserService) {
     }

   user:User;

  addUser(form:any){
   let data=form.value;
  let salary=data.salary;
   let name=data.username;
   let age=data.age;
   this.user=new User(-1,name,age,salary);
   let observable:Observable<User>=this.userService.addUser(this.user);
   observable.subscribe(
     userArg=>{
       this.user=userArg;
     }
     ,
     err=>{
       console.log("err in addusercomponent "+err.message);
     }

   );
  }

}
