package schoolmgt;

class StudentMain {

	public static void main(String[] args) {
		Student students[] = new Student[4];

		ElectronicsStudent student1 = new ElectronicsStudent("ankit", 21, true, "multimeter");
		ComputerScienceStudent student2 = new ComputerScienceStudent("balakrishna", 21, true, "dell");
		ComputerScienceStudent student3 = new ComputerScienceStudent("prasanna", 22, true, "asus");
		ElectronicsStudent student4 = new ElectronicsStudent("saiteja", 22, true, "diode");

		students[0] = student1;
		students[1] = student2;
		students[2] = student3;
		students[3] = student4;

		for (int i = 0; i < students.length; i++) {
			Student current = students[i];
			String name = current.getName();
			int age = current.getAge();
			boolean placed = current.getPlaced();
			System.out.println("name is " + name + " age is " + age + " is placed " + placed);
			boolean isCSGuy = current instanceof ComputerScienceStudent;
			if (isCSGuy) {
				ComputerScienceStudent cs = (ComputerScienceStudent) current;
				System.out.println("laptop available=" + cs.getLaptopAlloted());
			}

			boolean isECEGuy = current instanceof ElectronicsStudent;
			if (isECEGuy) {
				ElectronicsStudent es = (ElectronicsStudent) current;
				System.out.println("gadget available=" + es.getGadgetAlloted());
			}

		}

	}

}
