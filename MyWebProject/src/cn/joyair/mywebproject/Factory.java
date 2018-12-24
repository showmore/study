package cn.joyair.mywebproject;

public class Factory {
	public static fruit getInstance(String fruitName){  
        fruit f=null;  
        if("Apple".equals(fruitName)){  
            f=new Apple();  
        }  
        if("Orange".equals(fruitName)){  
            f=new Orange();  
        }  
        return f;  
    }  
}

