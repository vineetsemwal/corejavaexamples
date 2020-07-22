
class Account {

	String holderName;
	double balance;
	int age;
	
	Account(String holderName,double balance, int age){
		this.holderName=holderName;
		this.balance=balance;
		this.age=age;		
	}
	
	Account(){
		this("",100,21);
          
	}
	
	String getHolderName() {
		return holderName;
	}
	
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
