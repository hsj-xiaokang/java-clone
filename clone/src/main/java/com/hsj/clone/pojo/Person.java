package com.hsj.clone.pojo;

/**
 * 实体对象
 * 
 * @Description:TODO
 * @author:hsj qq:2356899074
 * @time:2017年11月13日 下午1:19:49
 */
public class Person implements Cloneable{
	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	/**
	 * 覆盖clone接口
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {  
        return (Person)super.clone();  
    } 

}
