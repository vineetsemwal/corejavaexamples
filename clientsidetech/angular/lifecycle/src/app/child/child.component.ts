import { Component, Input, OnChanges, OnDestroy, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'child-cmp',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit, OnChanges, OnDestroy {


  @Input() receivedInput:string;


  constructor() {
    console.log("inside child constructor");
   }
  
  /**
   *  let obj= {
   *     name:"dharma",
   *     age : 21
   *   }
   * 
   *   let name=obj.name;
   *   let age= obj.age;
   * 
   *  let name=obj['name'];
   *  let age=obj['age'];
   * 
   *    
   */

   /**
    * executes every time data bound input property changes
    */
   ngOnChanges(changes: SimpleChanges): void {
   console.log("inside child ngOnchanges, receivedInput="+this.receivedInput);
   let change=changes['receivedInput'];
   let previous=change.previousValue;
   let newVal=change.currentValue;
   console.log("previous val="+previous+" new value="+newVal);
  }

  /**
   * executes only once when component is rendered
   */
  ngOnInit(): void {
    console.log("inside child ngOnit");
  }

  ngOnDestroy(): void {
    console.log("inside on destroy");
  }

}
