import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { UserService } from '../service/userservice';

@Component({
  selector: 'adduser-codedriven',
  templateUrl: './adduser-codedriven.component.html',
  styleUrls: ['./adduser-codedriven.component.css']
})

export class AdduserCodedrivenComponent implements OnInit {

  userForm:FormGroup;

  usernameCtrl:FormControl;

  ageCtrl:FormControl;

  salaryCtrl:FormControl;

  user:User;

  constructor(private userService:UserService,fb:FormBuilder) { 
    this.usernameCtrl=fb.control('',[Validators.minLength(2), Validators.required]);
    this.ageCtrl=fb.control('',[Validators.required]);
    this.salaryCtrl=fb.control('',[Validators.required]);
    this.userForm=fb.group({
    username:  this.usernameCtrl,
    age: this.ageCtrl,
    salary:this.salaryCtrl

    });
  }

  ngOnInit(): void {
  }

  addUser(){
    let username:string=this.usernameCtrl.value;
    let age:number=this.ageCtrl.value;
    let salary:number=this.salaryCtrl.value;
    this.user=new User(-1,username,age,salary);
    let observable:Observable<User>=this.userService.addUser(this.user);
     observable.subscribe(
       userArg=>{
         this.user=userArg;
       },
       err=>{
         console.log("add suer code driven, err is ="+err.message);
       }
     )
  }

}
