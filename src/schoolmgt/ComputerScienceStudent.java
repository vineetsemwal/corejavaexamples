package schoolmgt;

class ComputerScienceStudent extends Student {

	String laptopAlloted;

	ComputerScienceStudent(String name, int age, boolean placed, String laptopAlloted) {
		super(name, age, placed);// first line
		this.laptopAlloted = laptopAlloted;
	}

	String getLaptopAlloted() {
		return laptopAlloted;
	}

	void setLaptopAlloted(String laptopAlloted) {
		this.laptopAlloted = laptopAlloted;
	}

}
