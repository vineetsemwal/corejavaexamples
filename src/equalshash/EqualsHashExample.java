package equalshash;

public  class EqualsHashExample {

	public static void main(String[]args) {
	 Trainee t1=new Trainee(10,"prakash");
	 Trainee t2=new Trainee(10,"prakash");
	 boolean issame=t1==t2;// is to check t1, t2 are referring same object
	 boolean isEquals=t1.equals(t2);//two object are equal (in content)
	
	 System.out.println("is same="+issame);
	 System.out.println("is equal="+isEquals);
	
	 String s1=new String("hello");
	 String s2=new String("hello");
	 boolean isStringSame=s1==s2;
	 boolean isStringEqual=s1.equals(s2);
	 System.out.println("is string same="+isStringSame);
	 System.out.println("is strings equal="+isStringEqual);
	 
	}
	
	
}
