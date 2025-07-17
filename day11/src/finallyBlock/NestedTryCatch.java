package finallyBlock;

public class NestedTryCatch {
	
	public static void check()
	{
		String str="TNS";
		int slength=str.length();  //int sl=3
		System.out.println("String Lenght:"+ slength);
		
		String anotherString= null;
		
		int y=6;
		
		try {
			//Inner try block 
			try {
				System.out.println(str.charAt(y));
			}
			catch(StringIndexOutOfBoundsException e)
			{
				System.err.println(e.getMessage());
			}
			System.out.println("String length : "+anotherString.length());
		}
		catch (NullPointerException e)
		{
			System.err.println(e.getMessage());
		}
	}

}
