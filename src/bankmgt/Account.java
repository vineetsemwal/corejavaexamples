package bankmgt;

class Account {

	String holderName;
	double balance;
	int age;
	
	Account(String holderName,double balance, int age){
		this.holderName=holderName;
		this.balance=balance;
		this.age=age;		
		System.out.println("inside 3 args constructor");
	}
	
	Account(String holderName,double balance){
		this(holderName, balance,21);
		System.out.println("inside 2 args constructor");		
	}
	
	
	Account(){
		this("",100,21);
        System.out.println("inside zero arg constructor");  
	}
	
	String getHolderName() {
		return holderName;
	}
	
	// Account account3=new Account();
	// account3.setHolderName("praneeth");
	// this and account3 are same thing
	void setHolderName(String holderName) {	
	this.holderName=holderName;
	}
	
	double getBalance() {
		return balance; 
	}
	
	void setBalance(double balance) {
		this.balance=balance;
	}
	
	
	int getAge() {
		return age;
	}
	
	void setAge(int age) {
		this.age=age;
	}
	
	double credit(double amount) {
		balance=balance+amount;
		return balance;
	}
	
	double debit(double amount) {
		if(amount<=balance) {
		balance=balance-amount;
		}
		return balance;
	}
	
	
}
