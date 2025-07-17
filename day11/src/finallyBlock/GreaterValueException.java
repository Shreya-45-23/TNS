package finallyBlock;

public class GreaterValueException extends Exception {
	
	public GreaterValueException(String string)
	{
		super(string);
	}
	
	public GreaterValueException()
	{
		super("Percentage should not be more then 100");
	}


}
