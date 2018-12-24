package cn.joyair.mywebproject;

public class Mango implements fruit{
	private String color;

	@Override
	public void eat() {
		System.out.println("eat Mango!");
		
	};
	
	public Mango() {
		setColor("red");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	};
	


}
