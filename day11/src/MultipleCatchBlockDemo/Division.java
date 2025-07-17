package MultipleCatchBlockDemo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Division {
	
	public static void divide()
	{
		int a,b,c;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter two number: ");
		
		try {
			a=sc.nextInt();
			b=sc.nextInt();
			
			c=a/b;
			
			System.out.println("Division is : "+c);
		}
		catch (InputMismatchException e)
		{
			System.err.println(e.getMessage());
		}
		catch(ArithmeticException | ArrayIndexOutOfBoundsException e)
		{
			System.err.println(e.getMessage());
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		
		finally {
			sc.close();
			System.out.println("Finally block ");
		}
		
	}

}
