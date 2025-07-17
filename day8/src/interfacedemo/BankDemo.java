package interfacedemo;

public class BankDemo {
	
public static void main(String[] args) {
		
		SavingAccount s1=new SavingAccount("Zeel", "Pune", 1234567, 36000);
		
		s1.deposit(27000);
		System.out.println(s1);

		s1.withdraw(21000);
		System.out.println(s1);
		
		s1.withdraw(10000);
		System.out.println(s1);
		
		
		s1.withdraw(1);
		System.out.println(s1);
	}


}
