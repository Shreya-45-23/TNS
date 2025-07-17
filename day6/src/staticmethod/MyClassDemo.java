package staticmethod;

public class MyClassDemo {
	
public static void main(String[] args) {
		
		MyClass.display();
		
		System.out.println();
		
		MyClass o1=new MyClass();
		System.out.println(o1);
		
		MyClass.display();
		
		System.out.println();
		
		MyClass o2=new MyClass();
		System.out.println(o2);

		System.out.println();
		
		MyClass o3=new MyClass();
		System.out.println(o3);
		
	}

}
