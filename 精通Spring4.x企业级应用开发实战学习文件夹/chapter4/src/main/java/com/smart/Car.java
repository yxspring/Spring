package com.smart;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//管理Bean生命周期的接口
public class Car implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean{
	private String brand;
	private String color;
	private int maxSpeed;
	private String name;
	private BeanFactory beanFactory;
	private String beanName;

	public Car() {
		System.out.println("调用Car()构造函数。");
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		System.out.println("调用setBrand()设置属性。");
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "brand:" + brand + "/color:" + color + "/maxSpeed:"+ maxSpeed;
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
		System.out.println("introduce:"+this.toString());
	}


	//设置Bean的名字 调用BeanNameAware接口方法
	public void setBeanName(String beanName) {
		System.out.println("调用BeanNameAware.setBeanName()方法。");
		this.beanName=beanName;
	}
	//设置bean 调用BeanFactoryAware接口方法
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("调用BeanNameFactory.setBeanFactory()方法。");
		this.beanFactory=beanFactory;
	}

	//设置属性之后 调用InitializingBean接口方法
	public void afterPropertiesSet() throws Exception {
		System.out.println("调用InitializingBean.afterPropertiesSet()方法");
	}
	//通过<bean>的init-method属性执行的初始化方法
	public  void myInit(){
		System.out.println("调用init-method所指定的myInit()，将maxSpeed设置为240");
		this.maxSpeed=240;
	}
	//通过<bean>的destroy-method属性指定的销毁方法
	public void myDestory(){
		System.out.println("调用destory-method所指定的myDestory()方法");
	}
	//Bean销毁
	public void destroy() throws Exception {

	}
}
