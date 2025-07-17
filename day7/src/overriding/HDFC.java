package overriding;

public class HDFC extends RBI{
	
	public float getRateofInterest()
	{
		System.out.println("Base rate of interest of home loan");
		return 7.5f;
	}

}
