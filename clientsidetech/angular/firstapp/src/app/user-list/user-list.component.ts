import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';

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
    new User("dharma",21),
    new User("anuj",21),
    new User("prakash",21)
  ];

}
