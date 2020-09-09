import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl:'app.component.html',
  styleUrls: ['app.component.css']
})
export class AppComponent {
  title = 'My firstapp';
  description="My first angular application";
  startDate="09-09-2020";
  name="firstapp";

  links=["https://www.w3schools.com/html",
         "https://www.w3schools.com/css",
         "https://www.w3schools.com/js" 
         ]


  imgPath=[ "https://upload.wikimedia.org/wikipedia/en/thumb/4/41/Flag_of_India.svg/255px-Flag_of_India.svg.png"];

  topUser:User=new User("dharma" ,21);

  users:User[]=[new User("dharma",21),
          new User("saiteja",21)
        ];




}
class User{
  name:string;
  age:number;
  
  constructor(name : string, age:number){
    this.name=name;
    this.age=age;
  }

  getName():string{
    return this.name;
  }

  getAge():number{
    return this.age;
  }



}
