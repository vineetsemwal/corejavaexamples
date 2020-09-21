export class User{
    id:number;
    name:string;
    age:number;
    salary:number;

    constructor(id:number,name : string, age:number, salary:number){
      this.id=id;
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
  