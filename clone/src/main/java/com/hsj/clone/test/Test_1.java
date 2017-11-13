package com.hsj.clone.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试clone-通过实现Cloneable-【浅拷贝】-Head Face不重写clone方法,Body重写clone方法
 * 
 * 有两个主要的类， 分别为Body和Face， 在Body类中， 组合了一个Face对象。当对Body对象进行clone时， 它组合的Face对象只进行浅拷贝
 * @Description:TODO
 * @author:hsj qq:2356899074
 * @time:2017年11月13日 下午1:31:30
 */
public class Test_1 {
	
	/**
	 * 日志
	 */
	private final static Logger LOGGER = LoggerFactory.getLogger(Test_1.class);

	/**
	 * body
	 * @Description:TODO
	 * @author:hsj qq:2356899074
	 * @time:2017年11月13日 下午1:55:06
	 */
	static class Body implements Cloneable{  
	    public Head head;  
	      
	    public Body() {}  
	  
	    public Body(Head head) {this.head = head;}  
	  
	    @Override  
	    protected Object clone() throws CloneNotSupportedException {  
	        return super.clone();  
	    }  
	      
	}  
	
	/**
	 * head
	 * @Description:TODO
	 * @author:hsj qq:2356899074
	 * @time:2017年11月13日 下午1:55:14
	 */
	static class Head {  
	    public  Face face;  
	      
	    public Head() {}  
	    public Head(Face face){this.face = face;}  
	      
	}  
	
	/**
	 * face
	 * @Description:TODO
	 * @author:hsj qq:2356899074
	 * @time:2017年11月13日 下午1:55:21
	 */
	static class Face{
		
	}
	
	/**
	 * entry入口
	 * @Description:TODO
	 * @author:hsj qq:2356899074
	 * @time:2017年11月13日 下午1:55:32
	 * @param args
	 */
	public static void main(String[] args) {  
	      
	    Body body = new Body(new Head(new Face()));  
	      
	    Body body1 = null;
		try {//克隆
			body1 = (Body) body.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			LOGGER.info("克隆错误!");
		}  
	    
	    LOGGER.info("body == body1 :{}  " , (body == body1) );
	    LOGGER.info("body.head == body1.head :{} " ,  (body.head == body1.head));
	    LOGGER.info("body.head.face == body1.head.face :{} " ,  (body.head.face == body1.head.face));
	      
	}
	
}
