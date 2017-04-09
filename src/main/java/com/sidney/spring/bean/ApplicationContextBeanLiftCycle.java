package com.sidney.spring.bean;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ApplicationContextBeanLiftCycle {
	private static void LifeCycleBeanFactory(){
		//1下面装载配置文件并启动容器
		Resource res = new ClassPathResource("com/sidney/spring/bean/beans.xml");
		BeanFactory bf = new XmlBeanFactory(res);
		//2向容器中注册MyBeanPostProcessor后处理器
		((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyBeanPostProcessor());
		
		//3 向容器中注册MyInstantiationAwareBeanPostProcessor后处理器
		((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
		
		//4第一次从容器中获取 car1，将触发容器实例化该Bean
		Car1 car1 = (Car1)bf.getBean("car");
		car1.introduce();
		car1.setColor("蓝色");
		
		//5第二次从容器中获取car，直接从缓存池中获取
		Car1 car2 = (Car1)bf.getBean("car");
		
		//查看 car1和car2是否指向同一引用
		System.out.println("car1 == car2" + (car1==car2));
		
		((XmlBeanFactory)bf).destroySingletons();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LifeCycleBeanFactory();
	}

}
