import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { Service } from '../service';

@Component({
  selector: 'add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  constructor(private service:Service) { }

  ngOnInit(): void {
  }

add(myform){
  let data=myform.value;
  let user=new User();
 let dateStr=data.date;
 let date=new Date(dateStr);
 console.log("date time chosen is "+date);
  let observable:Observable<User>=this.service.createUser(date);
  observable.subscribe(
      userresponse=>{
        console.log(userresponse.username+" millis="+userresponse.millis);
      }
  );
}

}
