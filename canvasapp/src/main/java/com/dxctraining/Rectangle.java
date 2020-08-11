package com.dxctraining;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Rectangle implements Shape{

	@Value("${rectangle.length}")
	private int length;

	@Value("${rectangle.breadth}")
	private int breadth;
		
	public Rectangle(int length, int breadth) {
		this.length=length;
		this.breadth=breadth;
	}

	public Rectangle(){

	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getBreadth() {
		return breadth;
	}

	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	
	@Override
	public double area() {
		return length*breadth;
	}

	/**
	 * lifecycle hook which will get fired when rectangle object will be constructed/created+initialized
	 */
	@PostConstruct
	public void init(){
     System.out.println("inside init of Rectangle ,length="+length+" breadth="+breadth);
	}

	/**
	 * lifecycle hook which will get fired when rectangle object will get destroyed
	 */
	@PreDestroy
	public void destroy(){
	 System.out.println("inside predestroy of Rectangle");
	}

}
