import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
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
    let observable:Observable<User[]>=userService.getAllUsers();
    observable.subscribe(
      userArr=>{
        this.users=userArr;
      },
      err=>{
        console.log("inside UserListComponent err is "+err.message);
      }

    );
   }

  eligibleColor:string="green";
  notEligibleColor:string="red";

  color:string="white";

  isEligible(age:number):boolean{
    return age>=21;
  }

  removeUser(id:number){
 let observable=this.userService.removeUser(id);
 observable.subscribe(
   res=>{
    this.removeLocalElement(id);
   },
   err=>{
     console.log("inside removeuser, err is "+err.message);
   }
 );
  }

  removeLocalElement(id:number):void{
    console.log("before user removed,length="+this.users.length); 
    for(let i=0 ;i<this.users.length;i++ ){
       let user=this.users[i];
        if(user.id===id){
            //index and number of elements to remove
            this.users.splice(i,1);
        }
     }
       
}
}
