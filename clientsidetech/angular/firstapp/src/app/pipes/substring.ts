import { PipeTransform, Pipe } from '@angular/core';

@Pipe(
    {
     "name" : "substring"   
    }
)
export class SubstringPipe implements PipeTransform{
   
    transform(original: string,start:number , end:number ):string {
   
   console.log("inside substring transform, original="+original+" start="+start+" end="+end);     

   if(end==undefined){
    let desired=original.substring(start);
    return desired;   
   }     

    let desired=original.substring(start,end);
     return desired;
    }


}
