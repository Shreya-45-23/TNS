package multithreading;

public class ThreadLifeCycleDemo extends Thread {
	
	public void run()
	{
		System.out.println("in Side run() thread is alive or not ?"
	+ this.isAlive());
		
		int num=0;
		while(num<4)
		{
			num++;
			System.out.println("num = "+num);
		}
		try {
			sleep(400);
			System.out.println("child thread in not runnable state, thread is alive or not"
			+this .isAlive());
		}
		catch (InterruptedException e)
		{
			System.err.println("thread interrupted ...."+ e.getMessage());
		}
	}

}
