package association;

public class Executor {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Address address=new Address("405 Laxmi nagar", "Pune", "Maharashtra", "4110001");
	
	
		Person p=new Person("Shubham", address);
		p.displayInfo();
		System.out.println(p);
	
	
	
	}


}
