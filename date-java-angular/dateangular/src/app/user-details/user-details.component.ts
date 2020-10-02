import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { Service } from '../service';

@Component({
  selector: 'user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  user:User;

  constructor(private service:Service) { }

  ngOnInit(): void {
  }



  getDate(millis:number){
    let date=new Date(millis);
    return date;
  }

  getUser(){
    let userid=1;
    let observable:Observable<User> =this.service.getUser(userid);
    observable.subscribe((user:User)=>{
         this.user=user;
         console.log("fetched user="+user.username+" millis="+user.millis);
    });
  }
}

