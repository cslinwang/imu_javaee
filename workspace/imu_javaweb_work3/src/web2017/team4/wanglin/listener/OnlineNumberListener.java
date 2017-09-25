package web2017.team4.wanglin.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class OnlineNumberListener implements HttpSessionListener {
	  private static int count = 0;
	  
	  public void sessionCreated(HttpSessionEvent se) {
	    
	    System.out.println("sessionÔö¼Ó" + new java.util.Date());
	    count++;
	    System.out.println("count = "+count);
	  }
	  
	  public void sessionDestroyed(HttpSessionEvent se) {
	    
	    System.out.println("session¼õÉÙ" + new java.util.Date());
	    count--;
	    System.out.println("count = "+count);
	  }
	  
	  public static int getCount() {
	    return count;
	  }
	}
