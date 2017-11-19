package web2017.team4.wanglin.listener;

/*import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class OnlineNumberListener implements HttpSessionListener {
	  private static int count = 0;
	  
	  public void sessionCreated(HttpSessionEvent se) {
	    
	    System.out.println("session增加" + new java.util.Date());
	    count++;
	    System.out.println("count = "+count);
	  }
	  
	  public void sessionDestroyed(HttpSessionEvent se) {
	    
	    System.out.println("session减少" + new java.util.Date());
	    count--;
	    System.out.println("count = "+count);
	  }
	  
	  public static int getCount() {
	    return count;
	  }
	}
*/
import javax.servlet.http.HttpSessionAttributeListener;  
import javax.servlet.http.HttpSessionBindingEvent;  
import javax.servlet.http.HttpSessionEvent;  
import javax.servlet.http.HttpSessionListener;  
  
public class OnlineListener implements HttpSessionListener,HttpSessionAttributeListener{  
    //监听Http会话中的属性添加  
    public void attributeAdded(HttpSessionBindingEvent se) {  
        // TODO Auto-generated method stub  
        UserList.addUser(String.valueOf(se.getValue()));//增加一个用户  
        System.out.println("session("+se.getSession().getId()+")增加属性"+se.getName()+",值为"+se.getValue());  
    }  
    //监听Http会话中的属性移除  
    public void attributeRemoved(HttpSessionBindingEvent se) {  
        // TODO Auto-generated method stub  
        UserList.removeUser(String.valueOf(se.getValue()));  
        System.out.println(se.getValue()+"属性已移除");  
    }  
    //监听Http会话中的属性更改操作  
    public void attributeReplaced(HttpSessionBindingEvent se) {  
        // TODO Auto-generated method stub  
        String oldValue=String.valueOf(se.getValue());//旧的属性  
        String newValue=String.valueOf(se.getSession().getAttribute(se.getName()));//新的属性  
        UserList.removeUser(oldValue);//移除旧的属性  
        UserList.addUser(newValue);//增加新的属性  
        System.out.println(oldValue+"属性已更改为"+newValue);  
    }  
  
    public void sessionCreated(HttpSessionEvent se) {  
        // TODO Auto-generated method stub  
        System.out.println("会话已创建！");  
    }  
  
    public void sessionDestroyed(HttpSessionEvent se) {  
        // TODO Auto-generated method stub  
        System.out.println("会话已销毁！");  
    }  
  
}  