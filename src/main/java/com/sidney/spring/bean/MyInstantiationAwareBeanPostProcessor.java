package com.sidney.spring.bean;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter{
	//接口方法，在实例化Bean前进行调用
	public Object postProcessBeforeInstantiation(Class beanClass,String beanName) throws BeansException{
		//仅对容器中的Car1 Bean进行处理
		if("car".equals(beanName)){
			System.err.println("InstantiationAware BeanPostProcessor.postProcessBeforeInstantiation");

		}
		return null;
	}
	//接口方法，实例化Bean后调用
	public boolean postProcessAfterInstantiation(Object bean,String beanName)throws BeansException{
		//仅对容器中的Car1 Bean进行处理
		if("car".equals(beanName)){
			System.err.println("InstantiationAware BeanPostProcessor.postProcessAfterInstantiation");

		}
		return true;
	}
	
	//接口方法，在设置某个属性时调用
	public PropertyValues postProcessPropertyValues(PropertyValues pvs,
			PropertyDescriptor[]pds,Object bean,String beanName){
		
		if("car".equals(beanName)){
			System.err.println("Instantiation AwarePostProcessor. postProcessPropertyValues");
		}
		
		return pvs;
	}

}
