package com.yuen.spring;

import com.yuen.spring.ignoreDependency.impl.IgnoreInterfaceImpl;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class MyTestBeanTest {

	@Test
	public void MyTestBeanTest() {
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("spring-config.xml"));
        MyTestBean myTestBean = (MyTestBean) bf.getBean("myTestBean");
        System.out.println(myTestBean.getName());
	}

	@Test
	public void ignoreTest(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ignore-config.xml");
		IgnoreInterfaceImpl bean = ctx.getBean(IgnoreInterfaceImpl.class);
		System.out.println(bean);
	}
}