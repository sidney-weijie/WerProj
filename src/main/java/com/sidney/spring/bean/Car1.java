package com.sidney.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.alibaba.fastjson.JSON;
/**
 * 测试Bean生命周期
 * @author Sidney
 *
 */

public class Car1 implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean  {
	private String brand;
	private String color;
	private int maxSpeed;
	private BeanFactory beanfactory;
	private String beanname;
	


	public Car1(){
		System.err.println("调用Car1的构造方法");
	}

	public Car1 buildCar(){
		Car1 car = new Car1();
		car.setBrand("奔驰");
		car.setColor("黑色");
		car.setMaxSpeed(250);
		return car;
	}
	public Car1(String brand,String color,int maxSpeed){
		this.brand = brand;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		System.err.println("调用SetBrand属性");
		this.brand = brand;
	}
	public String getColor() {

		return color;
	}
	public void setColor(String color) {
		System.err.println("调用SetColor属性");
		this.color = color;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		System.err.println("调用SetMaxSpeed属性");
		this.maxSpeed = maxSpeed;
	}
	public void introduce(){
		System.out.println(JSON.toJSONString(this));
	}

	
	public void destroy() throws Exception {
		
		System.err.println("调用DisposabelBean.destroy()方法");
	}

	
	public void afterPropertiesSet() throws Exception {
		System.err.println("调用InitializingBean.afterPropertiesSet()");
		
	}

	
	public BeanFactory getBeanfactory() {
		return beanfactory;
	}

	public void setBeanfactory(BeanFactory beanfactory) {
		System.err.println("调用BeanFactoryAware.setBeanFactory()");
		this.beanfactory = beanfactory;
	}

	public String getBeanname() {
		System.err.println("调用BeanNameAware.setBeanName()");
		return beanname;
	}

	public void setBeanname(String beanname) {
		this.beanname = beanname;
	}

	public void myInit(){
		System.err.println("调用init-method所指定的myInit，将maxSpeed设置为240");
		this.maxSpeed=240;
	}
	
	public void myDestroy(){
		System.err.println("调用destroy-method所指定的myDestroy()");
	}

	@Override
	public void setBeanName(String name) {
		System.err.println("调用BeanNameAware.setBeanName()");
		this.beanname = name;
		
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.err.println("调用BeanFactoryAware.setBeanFactory()");
		this.beanfactory = beanFactory;
	}


	
}
