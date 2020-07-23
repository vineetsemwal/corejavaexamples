package schoolmgt;

/**
 * 
 * things that can be done with super keyword
 * 1) you can address members(fields + methods)
 * 2) you can call constructor of immediate base class
 *
 */
public class ComputerScienceStudent extends Student {

	private String laptopAlloted;

	public ComputerScienceStudent(String name, int age, boolean placed, String laptopAlloted) {
		//super with round bracket means we are calling base class constructor
		super(name, age, placed);
		this.laptopAlloted = laptopAlloted;
	}
	
	public ComputerScienceStudent(String name, int age) {
	     this(name,age,true,"");
	}
	

	public String getLaptopAlloted() {
		return laptopAlloted;
	}

	public void setLaptopAlloted(String laptopAlloted) {
		this.laptopAlloted = laptopAlloted;
	}
	
	public void setAge(int age) {
		if(age>17) {
			super.setAge(age);
		}
	}
		

}
