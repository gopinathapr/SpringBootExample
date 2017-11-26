package com.prg.springboot.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee implements Serializable {

	String name;
	String age;
	String sal;

	public Employee() {
	}

	public Employee(String name, String age, String sal) {
		super();
		this.name = name;
		this.age = age;
		this.sal = sal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public String toString() {
		return "Details:->" + name + age + sal;
	}
}
