package schoolmgt.ui;

import schoolmgt.Student;
import schoolmgt.ElectronicsStudent;
import schoolmgt.InvalidStudentArgumentException;
import schoolmgt.ComputerScienceStudent;

public class StudentMain {
	private Student students[] = new Student[11];

	public static void main(String[] args) {
	 StudentMain demo=new StudentMain();
	 demo.runApp();	
	}
		
	public void runApp() {
		try {
		ElectronicsStudent student1 = new ElectronicsStudent("ankit", 21, true, "multimeter");
		ComputerScienceStudent student2 = new ComputerScienceStudent("balakrishna", 21, true, "dell");
		ComputerScienceStudent student3 = new ComputerScienceStudent("prasanna", 22, true, "asus");
		ElectronicsStudent student4 = new ElectronicsStudent("saiteja", 22, true, "diode");
       
		students[0] = student1;
		students[1] = student2;
		students[2] = student3;
		students[3] = student4;
		
		
		displayAll();
		}
		catch(InvalidStudentArgumentException e) {
			System.out.println("student is null");
		}
		catch(Exception e) {
		  System.out.println("some error occurred in program");	
		}
		
	}
	
	
	
	public void displayAll() {
		for (Student current:students) {
			boolean isCSGuy = current instanceof ComputerScienceStudent;
			if (isCSGuy) {
				ComputerScienceStudent cs = (ComputerScienceStudent) current;
			    display(cs);  
			}

			boolean isECEGuy = current instanceof ElectronicsStudent;
			if (isECEGuy) {
				ElectronicsStudent es = (ElectronicsStudent) current;
		        display(es);
			}
			
		}
		
	}
	
	
	public void checkNull(Student student) {
		if(student==null) {
			InvalidStudentArgumentException exception=new InvalidStudentArgumentException("null argument");
		    throw exception;	
		}
	}
	
	
	public void displayStudent(Student student) {
	    checkNull(student);
		String name = student.getName();
		int age = student.getAge();
		boolean placed=student.getPlaced();
    	System.out.println("name is " + name + " age is " + age + " is placed " + placed);
		
	}
	
	public void display(ElectronicsStudent student) {
		checkNull(student);
		displayStudent(student);
		System.out.println("gadget available=" + student.getGadgetAlloted());
		
	}
	
	public void display(ComputerScienceStudent student) {		
		checkNull(student);
		displayStudent(student);
		System.out.println("laptop available=" + student.getLaptopAlloted());
		
	}

}
