class StudentMain {
	
	public static void main(String[]args) {		
		Student students[]=new Student[3];
		Student student1=new Student("ankit",21,true);
		Student student2=new Student("balakrishna",21,true);
		Student student3=new Student();
		student3.setAge(22);
		student3.setName("prasanna");
		student3.setPlaced(true);
		students[0]=student1;
		students[1]=student2;
		
		student1.setAge(22);		
		student2.setAge(22);
	   
	    for(int i=0;i<students.length;i++) {
	        Student current=students[i];
	    	String name=current.getName();
            int age=current.getAge();
            boolean placed=current.getPlaced();            
            System.out.println("name is "+name+" age is "+age+" is placed "+placed);
	    }
	    
	    
	}

}
