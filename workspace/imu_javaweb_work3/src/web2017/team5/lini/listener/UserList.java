package web2017.team5.lini.listener;  
  
import java.util.Vector;  
  
public class UserList {  
    private static Vector online = new Vector();  
    //�����������  
    public static void addUser(String userName){  
        online.addElement(userName);  
    }  
    //�Ƴ���������  
    public static void removeUser(String userName){  
        online.removeElement(userName);  
    }  
    //��ȡ�����û�����  
    public static int getUserCount(){  
        return online.size();  
    }  
    public static Vector getVector(){  
        return online;  
    }  
}  