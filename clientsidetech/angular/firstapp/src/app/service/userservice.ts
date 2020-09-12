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

    addUser(user:User):void{
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

    removeUser(id:number):void{
        for(let i=0 ;i<this.users.length;i++ ){
           let user=this.users[i];
            if(user.id===id){
                //index and number of elements to remove
                this.users.splice(i,1);
            }
         }
           
    }

}
