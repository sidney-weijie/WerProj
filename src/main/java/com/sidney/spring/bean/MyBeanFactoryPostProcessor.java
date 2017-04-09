package com.sidney.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
/**
 * 用于使用ApplicationContext启动Spring容器时对指定的Bean进行操作
 * @author Sidney
 *
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinition bd = beanFactory.getBeanDefinition("car");
		bd.getPropertyValues().addPropertyValue("brand","奇瑞QQ");
		System.err.println("调用BeanFactoryPostProcessor.postProcessBeanFactory()!");
		
	}

}
