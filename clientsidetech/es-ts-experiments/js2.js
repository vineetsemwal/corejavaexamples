/*
rest/ spread operator
*/
function fun(...args){

 for(let i=0;i<args.length;i++){
     let e=args[i];
     console.log("element="+e);
 }   
}

fun(100);

fun("hello", "dharma", "teja");

fun("pradeep", "s");

fun("amal", "pradeep");
