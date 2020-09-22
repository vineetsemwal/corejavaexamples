import { Component, OnChanges, OnDestroy, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'child-cmp',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit, OnChanges, OnDestroy {

  constructor() {
    console.log("inside child constructor");
   }
  
  
   /**
    * executes every time data bound input property changes
    */
   ngOnChanges(changes: SimpleChanges): void {
   console.log("inside child ngOnchanges");
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
