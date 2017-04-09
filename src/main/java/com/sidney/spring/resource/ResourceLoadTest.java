package com.sidney.spring.resource;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.*;
import org.springframework.util.FileCopyUtils;

/**
 * ResourceLoader加载指定文件信息
 * @author Sidney
 *
 */
public class ResourceLoadTest {

	public static void main(String[] args) {
		EncodedResourceExample();
		resourcePatternResolverTest();
	}
	
	public static void EncodedResourceExample(){
		try {
			Resource res = new ClassPathResource("log4j.properties");
			EncodedResource encRes = new EncodedResource(res,"UTF-8");
			String content = FileCopyUtils.copyToString(encRes.getReader());
			System.err.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void resourcePatternResolverTest(){
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		
		Resource resources[];
		try {
			resources = resolver.getResources("classpath*:**/*.xml");
			for(Resource resource : resources){
				System.err.println(resource.getDescription());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
