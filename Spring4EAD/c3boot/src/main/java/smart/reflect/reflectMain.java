package smart.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class reflectMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 一般使用
		Car car = new Car();
		car.setBrand("红旗CA72");
		car.setColor("Black");
		car.setMaxSpeed(220);
		car.introduce();

		try {
			Car c = initCarByReflect();
			c.introduce();

			PrivateCar pcar = initPrivateCarByReflect();
			pcar.drive();
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//
	private static Car initCarByReflect() throws Throwable{
		//通过类加载器获取Car类对象
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class clazz = loader.loadClass("smart.reflect.Car");
		
		//获取类的默认构造器并通过它实例化Car
		Constructor cons = clazz.getDeclaredConstructor((Class[])null);
		Car car = (Car)cons.newInstance();
		
		//通过反射类的方法，设置属性
		Method setBrand = clazz.getMethod("setBrand", String.class);
		setBrand.invoke(car, "红旗CA89");
		Method setColor = clazz.getMethod("setColor", String.class);
		setColor.invoke(car, "Red");
		Method setMaxSpeed = clazz.getMethod("setMaxSpeed", Integer.TYPE);
		setMaxSpeed.invoke(car, 230);
		
		return car;
	}
	
	//
	private static PrivateCar initPrivateCarByReflect() throws Throwable{
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class clazz = loader.loadClass("smart.reflect.PrivateCar");
		PrivateCar pcar = (PrivateCar)clazz.newInstance();
		Field colorFld = clazz.getDeclaredField("color");
		
		//取消Java语言访问检查以访问private变量
		colorFld.setAccessible(true);
		colorFld.set(pcar, "Red");
		
		Method drive = clazz.getDeclaredMethod("drive", (Class[])null);
		
		//取消Java语言访问检查以访问protected方法
		drive.setAccessible(true);
		drive.invoke(pcar, (Object[])null);
		
		return pcar;		
	}
}
