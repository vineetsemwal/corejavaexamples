package multithreaddemos;

public class NumberRunnable implements Runnable{

	private String name;
		
	public NumberRunnable(String name) {
		this.name=name;
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public void run() {
				try {
					for (int i = 0; i < 10; i++) {
						System.out.println( name + " i=" + i);
						Thread.sleep(1000);
					}
				} catch (Exception e) {
		           e.printStackTrace(); 
				}
		
	}
	

}
