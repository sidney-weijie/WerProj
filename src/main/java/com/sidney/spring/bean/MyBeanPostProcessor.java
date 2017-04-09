package com.sidney.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{
	


	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {

		
		Car1 car = (Car1)bean;
		if("car".equals(beanName)){
			if(car.getMaxSpeed() > 200){
				System.err.println("调用BeanPostProcessor的postProcessAfterInitialization 设置速度，");
				
				car.setMaxSpeed(200);
			}

		}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		Car1 car = (Car1)bean;
		if("car".equals(beanName)){
			System.err.println("调用BeanPostProcessor的postProcessBeforeInitialization color为空，设置为黑色");
			car.setColor("黑色");
		}
		return bean;

	}

}
