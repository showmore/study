package cn.joyair.mywebproject;

import java.lang.reflect.Constructor;

public class HelloEat {


	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
//		fruit f=Factory.getInstance("Orange");  
//		fruit a=Factory.getInstance("Apple");
//        a.eat();
//        f.eat();
       
        fruit f= (fruit) Factory2.getInstance("cn.joyair.mywebproject.Apple");  
        if(f!=null){  
            f.eat();
            System.out.println(f.getColor());
        	;
            
        }
        Object c = Factory2.getCons("cn.joyair.mywebproject.Apple");
        System.out.println(c);
        
	}

}

class Factory2 {

	private static Class<?> classType;

	public static Object getInstance(String ClassName){  
        fruit f=null;  
        try{  
        classType = Class.forName(ClassName);
        f= (fruit) classType.newInstance();
         
        }catch (Exception e) {  
            e.printStackTrace();  
        }  
        return f;  
    }
	
	public static Object getCons(String ClassName) throws ClassNotFoundException, NoSuchMethodException, SecurityException{
		
		 classType = Class.forName(ClassName);
		 Constructor<?> f = classType.getConstructor(new Class[]{});
		 
		return f;
		
	}
} 
