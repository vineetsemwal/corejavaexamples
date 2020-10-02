import { Injectable } from '@angular/core';
import { User } from "./model/user";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class Service{

    constructor(private http:HttpClient){

    }

 createUser(date:Date):Observable<User>{
     let user=new User();
     user.username="fazil";
     user.millis=date.getTime();
     console.log("sending millis="+user.millis);
     let url="http://localhost:8080/users/add"
     let observable:Observable<User>=this.http.post<User>(url,user);
     return observable;
      
    }


    getUser(id):Observable<User>{
        let user=new User();
     let url="http://localhost:8080/users/get/"+id;
     let observable:Observable<User>=this.http.get<User>(url);
      return observable;
    }


}