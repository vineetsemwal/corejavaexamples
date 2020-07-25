package equalshash;

public  class EqualsHashExample {

	public static void main(String[]args) {
	 Trainee t1=new Trainee(10,"prakash");
	 Trainee t2=t1;
	 boolean issame=t1==t2;
	 boolean isEquals=t1.equals(t2);
	
	 System.out.println("is same="+issame);
	 System.out.println("is equal="+isEquals);
	 
	 
	}
	
	
}
