package bankmgt;

public class AccountMain {

	public static void main(String[]args) {
	 Account account1=new Account("praneeth",200,21);	
	 Account account2=new Account("prasanna",300,21);
	 Account account3=new Account("naveen",500);
	 account3.setAge(21);
	 account3.setHolderName("praneeth");
	 Account store[]=new Account[3];
	 store[0]=account1;
	 store[1]=account2;	 
	 store[2]=account3;
	 account1.credit(100);
	 account2.debit(100);
	  
	 
	 //for each loop, for iterating every element of the array 
	 for(Account account:store) {
	   System.out.println(account.getHolderName()+" "+account.getAge()+" "+ account.getBalance());	 
	 }
	 
	
	}
	
}
