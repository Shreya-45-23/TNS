package synchronization;

public class DepositLimitException extends Exception {
	
	public DepositLimitException()
	{
		super("Daily Limit of deposit is exceed.....");
	}
	public DepositLimitException(String message )
	{
		super (message);
	}


}
