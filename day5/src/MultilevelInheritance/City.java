package MultilevelInheritance;

public class City {
	
	private String cityName extends state;
	private float area;
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "City [cityName=" + cityName + ", area=" + area + ", getStateName()=" + getStateName()
				+ ", getLangyage()=" + getLangyage() + ", getCountryname()=" + getCountryname() + ", getCapital()="
				+ getCapital() + "]";
	}

}
