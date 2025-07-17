package firstpackage;

public class Base {
	
	//declare default, private, protected and public variables 
	
		int varDefault = 10;
		public int varPublic = 20;
		private int varPrivate = 30;
		protected int varProtected = 40;
		
		//declare default, protected, public and private methods 
		
		void methodDefault()
		{
			System.out.println("default access base class");
			System.out.println("default varible : "+ varDefault);
		}
		public void methodPublic()
		{
			System.out.println("Public access base class");
			System.out.println("Public varible : "+ varPublic);
		}
		private void methodPrivate()
		{
			System.out.println("private access base class");
			System.out.println("private varible : "+ varPrivate);
		}
		
		
		protected void methodProtected()
		{
			System.out.println("Protected access base class");
			System.out.println("Protected varible : "+ varProtected);
		}
		
		


}
