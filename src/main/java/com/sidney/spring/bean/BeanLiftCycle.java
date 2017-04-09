package com.sidney.spring.bean;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanLiftCycle {
	private static void LifeCycleBeanFactory(){
		//1下面装载配置文件并启动容器
		Resource res = new ClassPathResource("com/sidney/spring/bean/beans.xml");
		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/sidney/spring/bean/applicationContext-beans.xml");

		Car1 car1 = (Car1)ctx.getBean("car");
		car1.introduce();
		car1.setColor("蓝色");
		
		//5第二次从容器中获取car，直接从缓存池中获取
		Car1 car2 = (Car1)ctx.getBean("car");
		
		//查看 car1和car2是否指向同一引用
		System.out.println("car1 == car2" + (car1==car2));
		
		//RootBeanDefinition
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LifeCycleBeanFactory();
	}

}
