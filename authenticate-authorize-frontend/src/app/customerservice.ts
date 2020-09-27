import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './model/customer';
import { Injectable } from '@angular/core';
import { AuthenticationService } from './authservice';

@Injectable()
export class CustomerService{
    client:HttpClient;
    authService:AuthenticationService;

    baseServiceUrl="http://localhost:8587";
 
    constructor(client:HttpClient,authService:AuthenticationService){
    this.client=client;
    this.authService=authService;
     }
 

    fetchMe():Observable<Customer>{
     let username=this.authService.getLoginUsername()
     if(username==""|| username==undefined|| username==null){
         return;
     }
     let url=this.baseServiceUrl+"/customers/getbyusername/"+username;  
     let observable:Observable<Customer>=this.client.get<Customer>(url);
     return observable;
    }


    fetchAllCustomers():Observable<Customer[]>{
        let url=this.baseServiceUrl+"/admin/customers";  
        let observable:Observable<Customer[]>=this.client.get<Customer[]>(url);
        return observable;
    }

}