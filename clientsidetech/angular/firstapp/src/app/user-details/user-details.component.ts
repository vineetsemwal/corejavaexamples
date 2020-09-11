import { Component, OnInit } from '@angular/core';
import {User} from '../model/user'


@Component({
  selector: 'user-details',
  templateUrl: 'user-details.component.html',
  styleUrls: ['user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  user:User=new User("dharma",21, 10000);

  cssLink="http://w3schools.com/css";

  date=new Date();
  
  numbers=[2,5,1,9,10];

}
