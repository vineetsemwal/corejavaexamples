/*
let fun=function(){
    return "hello";
}
*/

let fun1=()=>"hello";
let fun2=arg=>"hello "+ arg;

let add1=(arg1, arg2)=>arg1+arg2;

let add2=(arg1,arg2)=>{
let result=arg1+arg2;
return result;
}


let result1=fun1();
console.log("result1="+result1);
let result2=fun2("prakash");
console.log("result2="+result2);
let result3=add1(1,2);
console.log("result3="+result3);
let result4=add2(3,5);
console.log("result4="+result4);



