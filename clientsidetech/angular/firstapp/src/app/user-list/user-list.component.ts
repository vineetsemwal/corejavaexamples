import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { preserveWhitespacesDefault } from '@angular/compiler';

@Component({
  selector: 'user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  users:User[]=[
    new User("dharma",21,10000),
    new User("anuj",19,20000),
    new User("prakash",21,30000)
  ];

  eligibleColor:string="green";
  notEligibleColor:string="red";

  color:string="white";

  isEligible(age:number):boolean{
    return age>=21;
  }

}
