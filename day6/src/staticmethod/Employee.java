package staticmethod;

public class Employee {
	//Declare instance varibles.
		private String name;
		private int id;
		
		//Declare a static companyName with data type String of company name 
		static String companyname ="TNSIF";

		//Declaring two parameter constructor 
		public Employee(String name, int id) {
			
			this.name = name;
			this.id = id;
		}

		@Override
		public String toString() {
			return "Employee [name=" + name + 
					", id=" + id + ", "
				+ "Comapany= "+ companyname+"]";
		}
		


}
