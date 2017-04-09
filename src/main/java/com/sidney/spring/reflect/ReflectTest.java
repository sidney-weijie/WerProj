package com.sidney.spring.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
/**
 * 
 * 测试java的反射构造
 * 使用ClassLoader来获得类的构造方法，并进行调用实例化类
 * 
 * 反射获得类的set方法，对属性进行赋值
 * @author Sidney
 *
 */
public class ReflectTest {
	public static Car initByDefaultConst() throws Throwable{
		//1.通过类装载器获取Car类对象
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class clazz = loader.loadClass("com.sidney.spring.reflect.Car");
		
		//2.获取类的默认构造器对象并通过它实例化Car
		Constructor cons = clazz.getDeclaredConstructor((Class[])null);
		Car car = (Car)cons.newInstance();
		
		//3.通过反射方法设置属性
		Method setBrand = clazz.getMethod("setBrand", String.class);
		Method setColor = clazz.getMethod("setColor", String.class);
		Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
		setBrand.invoke(car, "大众高尔夫");
		setColor.invoke(car, "红色");
		setMaxSpeed.invoke(car, 180);
		return car;
	}
	public static void main(String[] args) throws Throwable {
		Car car = initByDefaultConst();
		car.introduce();
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		System.err.println("current loader: " + loader);
		System.err.println("parent  loader: " + loader.getParent());
		System.err.println("grandparent loader: " + loader.getParent().getParent());
	}

}
