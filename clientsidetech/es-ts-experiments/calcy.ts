interface ICalculator{

    add(num1 : number, num2 :number) :number;

}

class Calculator implements ICalculator{
    
    add(num1: number, num2: number): number {
        let result:number=num1+ num2;
        return result;
    }

    
}


let calcy:ICalculator=new Calculator();
let result:number=calcy.add(10,20);
console.log("result is "+result);

