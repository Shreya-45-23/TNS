package overriding;

public class SBI extends RBI {
	
	//@Override
		public float getRateofInterest()
		{
			System.out.println("Base rate of interest of home loan");
			
			return 7.0f;
		}

}
