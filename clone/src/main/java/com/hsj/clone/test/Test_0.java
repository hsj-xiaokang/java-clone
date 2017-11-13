package com.hsj.clone.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hsj.clone.pojo.Person;

/**
 * 测试clone-通过实现Cloneable-【浅拷贝】-Person重写clone方法，String的name不重写clone方法
 * @Description:TODO
 * @author:hsj qq:2356899074
 * @time:2017年11月13日 下午1:17:50
 */
public class Test_0 {
	
	/**
	 * 日志
	 */
	private final static Logger LOGGER = LoggerFactory.getLogger(Test_0.class);
	/**
	 * 入口方法
	 * @Description:TODO
	 * @author:hsj qq:2356899074
	 * @time:2017年11月13日 下午1:18:08
	 * @param args
	 */
    public static void main(String[] args) {
    	test_0();
	}
    
    /**
     * Cloneable接口的方式克隆，clone是浅拷贝的
     * @Description:TODO
     * @author:hsj qq:2356899074
     * @time:2017年11月13日 下午1:26:26
     */
    private static void test_0(){
    	Person p = new Person(23, "zhang");  
    	Person p1 = null;
    	
		try {//克隆
			p1 = (Person) p.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			LOGGER.info("克隆错误!");
		}  
    	  
		LOGGER.info(p.toString());
		LOGGER.info(p1.toString());
		
		//测试浅拷贝
		LOGGER.info( p.getName() == p1.getName() ? "clone是浅拷贝的" : "clone是深拷贝的");
    }
}
