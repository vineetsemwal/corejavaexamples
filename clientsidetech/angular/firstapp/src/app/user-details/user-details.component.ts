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

  user:User=new User("dharma",21);

}
