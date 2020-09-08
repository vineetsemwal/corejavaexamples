class User{
    name;
    age;
    
    constructor(name, age){
     this.name=name;
     this.age=age;
    }

}

 let user1=new User("bhanu",21);
 let user2=new User("dharma",21);

  let users=[user1,user2];

   for(let i =0;i <users.length;i++){
       let user=users[i];
       console.log("user="+user.name+" "+user.age);
   }

