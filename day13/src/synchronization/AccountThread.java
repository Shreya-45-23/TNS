package synchronization;

public class AccountThread  extends Thread {
	
	private Accounts acc;
	private int amt;
	//para constructor 
	public AccountThread(Accounts acc, int amt) {
		super();
		this.acc = acc;
		this.amt = amt;
		start();
	}
	
	@Override
	public void run()
	{
		try
		{
			acc.withdraw(amt);
		}
		catch(InsufficientBalanceException e)
		{
			System.err.println(e.getMessage());
		}
	}
	


}
