class Student{
    name:string;
    age:number;    
    constructor(name:string, age:number){
     this.name=name;
     this.age=age;
    }

    display():void{
        console.log("student="+this.name+" "+this.age);
    }

}

class ITStudent extends Student{
    allotted:boolean;
   
    constructor(name:string, age:number, allotted:boolean){
        super(name, age);
        this.allotted=allotted;
    }

    display(){
        super.display();
        console.log("computer alloted="+this.allotted);
    }

}


 let student1:Student=new ITStudent("bhanu",21,true);
 let student2:ITStudent=new ITStudent("dharma",21,true);

  let students=[student1,student2];

  // let variable of array
  //variable will hold the currently iterated element
   for(let student of students){
       student.display();
   }

