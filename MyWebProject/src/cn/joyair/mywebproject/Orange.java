package cn.joyair.mywebproject;

public class Orange implements fruit {
	private String color;
	
	@Override
	public void eat() {
		System.out.println("eat Orange!");

	}
	
	public Orange() {
		setColor("orange");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
