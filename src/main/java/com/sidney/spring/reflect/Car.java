package com.sidney.spring.reflect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.JSON;

/**
 * @author Sidney
 *
 */

@Configuration
public class Car {
	private String brand;
	private String color;
	private int maxSpeed;
	
	public Car(){
		
	}
	@Bean(name="car")
	public Car buildCar(){
		Car car = new Car();
		car.setBrand("奔驰");
		car.setColor("黑色");
		car.setMaxSpeed(250);
		return car;
	}
	public Car(String brand,String color,int maxSpeed){
		this.brand = brand;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public void introduce(){
		System.out.println(JSON.toJSONString(this));
	}
	
}
