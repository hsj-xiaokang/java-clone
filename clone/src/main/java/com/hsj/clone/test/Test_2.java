package com.hsj.clone.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试clone-通过实现Cloneable-【深拷贝】-Body,Head,Face重写clone方法
 * 
 * @Description:TODO
 * @author:hsj qq:2356899074
 * @time:2017年11月13日 下午1:31:30
 */
public class Test_2 {
	/**
	 * 日志
	 */
	private final static Logger LOGGER = LoggerFactory.getLogger(Test_2.class);

    /**
     * body
     * @Description:TODO
     * @author:hsj qq:2356899074
     * @time:2017年11月13日 下午1:53:24
     */
	static class Body implements Cloneable{  
	    public Head head;  
	      
	    public Body() {}  
	  
	    public Body(Head head) {this.head = head;}  
	  
	    /**
	     * 重写clone()
	     */
	    @Override  
	    protected Object clone() throws CloneNotSupportedException {  
	    	 Body newBody =  (Body) super.clone();  
	         newBody.head = (Head) head.clone();  
	         return newBody; 
	    }  
	      
	}  
	/**
	 * head
	 * @Description:TODO
	 * @author:hsj qq:2356899074
	 * @time:2017年11月13日 下午1:53:32
	 */
	static class Head implements Cloneable{  
	    public  Face face;  
	      
	    public Head() {}  
	    public Head(Face face){this.face = face;}  
	    
	    /**
	     * 重写clone()
	     */
	    @Override  
	    protected Object clone() throws CloneNotSupportedException {  
	    	Head newHead = (Head)super.clone();  
	    	newHead.face = (Face) face.clone();
	    	return newHead;
	    } 
	      
	}  
	
	/**
	 * face
	 * @Description:TODO
	 * @author:hsj qq:2356899074
	 * @time:2017年11月13日 下午1:53:43
	 */
	static class Face implements Cloneable{
		/**
	     * 重写clone()
	     */
		    @Override  
		    protected Object clone() throws CloneNotSupportedException {  
		        return super.clone();  
		    } 
	}
	
	/**
	 * entry入口
	 * @Description:TODO
	 * @author:hsj qq:2356899074
	 * @time:2017年11月13日 下午1:53:51
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
