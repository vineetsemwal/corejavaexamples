package schoolmgt;

class Student {
	
	String name;//default to null
	int age;//default to 0 
	boolean placed;//default to false
	
	/**
	 * constructor is executed immediately after object creation 
	 * constructor is only executed once after object creation 
	 * constructor never returns any thing so it has no return type
	 */
	
	Student(String name,int age){
		this.name=name;
		this.age=age;
	}
	
	
	Student(String name, int age, boolean placed){
		this(name, age);
		this.placed=placed;
	}
	
	/**
	 * constructor overloading, compiler will now he difference in constructor from 
	 * 1)number of args
	 * 2) type of args
	 * 
	 * zero arg constructor is available to you be default if you have not defined any other constructor
	 * 
	 */		
	Student(){
		this("",0,false);
	}
	
	
	int getAge() {
		return age;
	}
	
	void setAge(int age) {
		this.age=age;
	}
	
	String getName() {
		return name;
	}
	
	void setName(String name) {
		this.name=name;
	}	
	
	boolean getPlaced() {
		return placed;
	}	
	
	void setPlaced(boolean placed) {
		this.placed=placed;
	}
		
}