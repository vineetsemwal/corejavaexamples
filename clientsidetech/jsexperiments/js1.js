
var user1={
    id:1 ,
     name:"scooby",
    age:3,

      userDetails : function(){
          console.log("inside usrdetails");
          //
          // this represents current object like java , 
          // unlike java without this object's members can'tbe accessed 
          //
       var detailsText=this.id +","+ this.name+","+this.age;
        return detailsText;
      } 

       };


       
     console.log(user1.id+" "+user1.name+" "+user1.age);
     console.log("about to call function");
     var text  =user1.userDetails();
     console.log(text);