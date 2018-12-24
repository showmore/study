package cn.joyair.mywebproject;

public class Apple implements fruit {
	private String color;
	@Override
	public void eat() {
		System.out.println("eat Apple!");

	}
	
	public Apple() {
		color="green";
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

}
