package abstractionclassdemo;

public class Rectangular {
	
	public class rectangular extends Shape{

		float width;
		float height;
		
		public rectangular() {
			width=3.2f;
			height=2.0f;
			
		}

		public rectangular(float width, float height) {
			
			this.width = width;
			this.height = height;
		}

		@Override
		public void calArea() {
			this.area=width*height;
			
		}

}
