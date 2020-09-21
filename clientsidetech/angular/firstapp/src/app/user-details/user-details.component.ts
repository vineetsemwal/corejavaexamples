import { Component, OnInit } from '@angular/core';
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
   this.user=this.userService.findUserById(id);
  }

}
