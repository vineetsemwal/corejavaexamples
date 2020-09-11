export class User{
    name:string;
    age:number;
    salary:number;

    constructor(name : string, age:number, salary:number){
      this.name=name;
      this.age=age;
      this.salary=salary;
    }
  
    getName():string{
      return this.name;
    }
  
    getAge():number{
      return this.age;
    }
  
    getSalary():number{
      return this.salary;
    }

  }
  