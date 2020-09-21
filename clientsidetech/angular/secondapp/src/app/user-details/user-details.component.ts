import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import {User} from '../model/user'
import { UserService } from '../service/userservice';


@Component({
  selector: 'user-details',
  templateUrl: 'user-details.component.html',
  styleUrls: ['user-details.component.css']
})
export class UserDetailsComponent  {

  constructor(private userService:UserService) {
   }

   user:User;

  findUser(form:any){
    let data=form.value;
    let id=data.userid;
    let observable:Observable<User>=this.userService.getUser(id);
    observable.subscribe(
      userArg=>{
        this.user=userArg;
      },

      err=>{
        console.log("isnide user details, err is "+err.message);
      }

    );
  }

}
