class User{
    name;
    age;    
    constructor(name, age){
     this.name=name;
     this.age=age;
    }

    display(){
        console.log("user="+this.name+" "+this.age);
    }

}

class BusinessUser extends User{
    amount;
   
    constructor(name, age, amount){
        super(name, age);
        this.amount=amount;
    }

    display(){
        super.display();
        console.log("amount="+this.amount);
    }

}



 let user1=new BusinessUser("bhanu",21,1000);
 let user2=new BusinessUser("dharma",21,2000);

  let users=[user1,user2];

   for(let i =0;i <users.length;i++){
       let user=users[i];
       user.display();
   }

