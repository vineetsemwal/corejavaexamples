package bankmgt;

public class Account {

	private String holderName;
	private double balance;
	private int age;
	
	public Account(String holderName,double balance, int age){
		this.holderName=holderName;
		this.balance=balance;
		this.age=age;		
		System.out.println("inside 3 args constructor");
	}
	
	public Account(String holderName,double balance){
		this(holderName, balance,21);
		System.out.println("inside 2 args constructor");		
	}
	
	
	public Account(){
		this("",100,21);
        System.out.println("inside zero arg constructor");  
	}
	
	public String getHolderName() {
		return holderName;
	}
	
	// Account account3=new Account();
	// account3.setHolderName("praneeth");
	// this and account3 are same thing
	public void setHolderName(String holderName) {	
	this.holderName=holderName;
	}
	
	public double getBalance() {
		return balance; 
	}
	
	public void setBalance(double balance) {
		this.balance=balance;
	}
	
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public double credit(double amount) {
		balance=balance+amount;
		return balance;
	}
	
	public double debit(double amount) {
		if(amount<=balance) {
		balance=balance-amount;
		}
		return balance;
	}
	
	
}
