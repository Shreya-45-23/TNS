package stringDemo;

public class StringOperations {
	
public static void main(String[] args) {
		
		String s1 = new String (" Indian ");
		
		System.out.println(s1);
		String s2=s1.toUpperCase();
		System.out.println(s2);
		System.out.println(s1.length());
		int a=s2.length();
		String s3=s1.substring(1, 7);
		System.out.println(s3);
		
		System.out.println(s1.trim());
		System.out.println(s1.stripTrailing());
		System.out.println(s1.isEmpty());
		
		//string comparison
		s2=new String(s1);
		
		//== --> object reference
		//equals --> data
		
		System.out.println("case 1 :"+ s1.equals(s2));//true
		System.out.println("case 2 :"+ s1==s2);//false
		

	}

}
