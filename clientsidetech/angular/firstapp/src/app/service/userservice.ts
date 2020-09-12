import { Injectable } from '@angular/core';
import { User } from '../model/user';

@Injectable()
export class UserService{

    users:User[]=[];

    generatedId:number=1;

    generateId():number{
        this.generatedId++;
        return this.generatedId;
    }

    addUser(user:User){
        let newId=this.generateId();
        user.id=newId;
        this.users.push(user);
    }

    allUsers():User[]{
        return this.users;
    }

    findUserById(id:number):User{    
      for(let user of this.users){
         if(user.id===id){
             return user;
         }
      } 
      return null;
    }

}
