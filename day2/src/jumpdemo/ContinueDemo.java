package jumpdemo;

public class ContinueDemo {
	
	public static void main(String[] args) {

		for(int k=5; k<15; k++)
		{
			//odd no are skipped
			
			if(k%2 !=0)
				continue;
			//even number are printed
			System.out.println(k + " ");
		}
	}


}
