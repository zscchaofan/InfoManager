package cn.cclookme.info.controller.comm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.cclookme.info.api.memcached.service.MemcachedService;

public class LoginSessionListener implements HttpSessionListener,ServletContextListener{

	//保存sessionID和username的映射  
	public  static  HashMap<Object, String> sessionList = new HashMap<Object, String>();
	
	@Autowired
	private static MemcachedService memcachedService;
	
	/**
	 *  
	 * Description: 通过登录名判断用户是否存在
	 * @param sessionUserName
	 * @return
	 * @throws Exception
	 */
    public static  boolean isLogining(String sessionUserName) {  
    	LoginSessionListener.initSessionList();
    	LoginSessionListener.sessionList(sessionList);
    	boolean flag = sessionList.containsValue(sessionUserName);
        return flag;  
    }  

    
    public static boolean replaceLogin(HttpSession session,String sessionUserName){
    	 //LoginSessionListener.initSessionList();
    	 String key = LoginSessionListener.getSessionKeyByUsername(sessionUserName);
    	 System.out.println("移除已登录的key:"+key);
    	 sessionList.remove(key);
    	 sessionList.put(session.getId(),sessionUserName);
		 return LoginSessionListener.flashSessionList();
    }
    
    
         
    /**
     * 
     * Description: 缓存用户session
     * @param session session对象
     * @param sessionUserName 用户名
     * @throws Exception
     */
	 public static boolean createUserSession(HttpSession session,String sessionUserName)  {  
		 LoginSessionListener.initSessionList();
		 sessionList.put(session.getId(),sessionUserName);
		 return LoginSessionListener.flashSessionList();
	 }
		 
	 
	 /**
	  * 
	  * Description: 移除缓存集合中的用户session
	  * @param sessionUserName
	  * @throws Exception
	  */
      public static void removeUserSession(String sessionUserName) {  
    	  LoginSessionListener.initSessionList();
    	  Iterator iter = sessionList.entrySet().iterator();  
              while (iter.hasNext()){  
                  Map.Entry entry = (Map.Entry)iter.next();  
                  Object key = entry.getKey();  
                  Object val = entry.getValue();  
                  if(((String)val).equals(sessionUserName)){  
                    sessionList.put(key,null);  
                    iter.remove();  
                    break;
                  }  
              }  
              LoginSessionListener.flashSessionList();   
      }  
      
      public static String getSessionKeyByUsername(String sessionUserName){
    	  LoginSessionListener.initSessionList();
    	  Iterator iter = sessionList.entrySet().iterator();  
         String k = "";
    	  while (iter.hasNext()){  
                  Map.Entry entry = (Map.Entry)iter.next();  
                  Object key = entry.getKey();  
                  Object val = entry.getValue();  
                  if(((String)val).equals(sessionUserName)){  
	                    k = key.toString();
	                    break;
                  }  
              }  
    	  return k;
      }

	
	
	
	/**
	 * 
	 * Description:测试方法 遍历缓存集合
	 * @param sessionList
	 */
	private static void sessionList(HashMap sessionList){
		
		Iterator iter = sessionList.entrySet().iterator();  
        while (iter.hasNext()){  
            Map.Entry entry = (Map.Entry)iter.next();  
            Object key = entry.getKey();  
            Object val = entry.getValue();  
        }  
	}
	


	
	/**
	 * 
	 * Description:从缓存中获取集合
	 */
	private static void initSessionList(){
		//从缓存获取
		@SuppressWarnings("unchecked")
		HashMap<Object, String> tempSessionList  = (HashMap<Object, String>) memcachedService.get("sessionList");
		if(tempSessionList==null){
			LoginSessionListener.sessionList = new HashMap<Object, String>();
			memcachedService.addForeverObject("sessionList", sessionList );
		}else{
			LoginSessionListener.sessionList = tempSessionList;
		}
	}
	
	/**
	 * 
	 * Description: 刷新缓存
	 * @return
	 */
	private static  boolean  flashSessionList(){
		return memcachedService.addForeverObject("sessionList", sessionList);
	}

	
	/**************************session监听器实现方法*******************************/
    
	/**
     * session销毁时触发此事件
     * 移除集合中的session
     */
	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		LoginSessionListener.initSessionList();
		String key = sessionEvent.getSession().getId();
		System.out.println("session过期移除用户："+sessionList.get(key)+":"+key);
		sessionList.remove(key);  
		LoginSessionListener.flashSessionList();
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		//sessionList.remove(sessionEvent.getSession().getId());  
	}
	
	/***********************容器初始化 获取service bean ***************************/
	
	@Override
	public void contextDestroyed(ServletContextEvent sec) {
		//容器销毁
	}

	@Override
	public void contextInitialized(ServletContextEvent sec) {
		WebApplicationContext appctx = WebApplicationContextUtils.getWebApplicationContext(sec.getServletContext());
		memcachedService = appctx.getBean(MemcachedService.class);
		memcachedService.addForeverObject("sessionList", new HashMap<Object, String>());
		System.out.println("初始化memcachedService...");
	}

}
