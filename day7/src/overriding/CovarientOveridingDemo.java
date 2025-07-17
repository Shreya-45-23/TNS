package overriding;

public class CovarientOveridingDemo {
	
	//Parent class
	class Colour{

		protected Colour getColour()
		{
			Colour s=new Colour();
			return s;
		}
	}
	//child class
	class Red extends Colour{
		
		@Override
		protected Red getColour()
		{
			Red s=new Red();
			return s;
		}
		
		
	}
	//child class
	class Blue extends Colour{
		
		@Override
		protected Blue getColour()
		{
			Blue s=new Blue();
			return s;
		}

}
