package com.sidney.spring.bean;

import java.beans.Beans;

import javax.sound.midi.SysexMessage;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.sidney.spring.reflect.Car;

@SuppressWarnings("deprecation")
public class SpringInitTest {
	public static void main(String[]args){
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

		String path = System.getProperty("user.dir") + "\\src\\main\\resources\\beans.xml";
		System.out.println(path);
		Resource res = resolver.getResource("classpath*:**/beans.xml");
		
		//1。使用ClassPathXmlApplicationContext读取指定文件初始化
	  //	ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("classpath*:**/beans.xml");
	  //	Car car = ctx.getBean(Car.class);
	  //	System.err.println("init BeanFactory");
	
	  //	car.introduce();
		
		//2.注解配置启动容器
		//AnnotationConfigApplicationContext tx = new AnnotationConfigApplicationContext(Beans.class);
		
		//tx.getBean("car",Car.class).introduce();
	
	}
}
