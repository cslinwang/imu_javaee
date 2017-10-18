package web2017.team4.wanglin.listener;

/*import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class OnlineNumberListener implements HttpSessionListener {
	  private static int count = 0;
	  
	  public void sessionCreated(HttpSessionEvent se) {
	    
	    System.out.println("session����" + new java.util.Date());
	    count++;
	    System.out.println("count = "+count);
	  }
	  
	  public void sessionDestroyed(HttpSessionEvent se) {
	    
	    System.out.println("session����" + new java.util.Date());
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
    //����Http�Ự�е��������  
    public void attributeAdded(HttpSessionBindingEvent se) {  
        // TODO Auto-generated method stub  
        UserList.addUser(String.valueOf(se.getValue()));//����һ���û�  
        System.out.println("session("+se.getSession().getId()+")��������"+se.getName()+",ֵΪ"+se.getValue());  
    }  
    //����Http�Ự�е������Ƴ�  
    public void attributeRemoved(HttpSessionBindingEvent se) {  
        // TODO Auto-generated method stub  
        UserList.removeUser(String.valueOf(se.getValue()));  
        System.out.println(se.getValue()+"�������Ƴ�");  
    }  
    //����Http�Ự�е����Ը��Ĳ���  
    public void attributeReplaced(HttpSessionBindingEvent se) {  
        // TODO Auto-generated method stub  
        String oldValue=String.valueOf(se.getValue());//�ɵ�����  
        String newValue=String.valueOf(se.getSession().getAttribute(se.getName()));//�µ�����  
        UserList.removeUser(oldValue);//�Ƴ��ɵ�����  
        UserList.addUser(newValue);//�����µ�����  
        System.out.println(oldValue+"�����Ѹ���Ϊ"+newValue);  
    }  
  
    public void sessionCreated(HttpSessionEvent se) {  
        // TODO Auto-generated method stub  
        System.out.println("�Ự�Ѵ�����");  
    }  
  
    public void sessionDestroyed(HttpSessionEvent se) {  
        // TODO Auto-generated method stub  
        System.out.println("�Ự�����٣�");  
    }  
  
}  