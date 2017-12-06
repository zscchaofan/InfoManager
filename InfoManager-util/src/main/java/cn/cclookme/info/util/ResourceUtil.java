package cn.cclookme.info.util;


import java.net.URL;
import java.net.URLClassLoader;
/**
 * 类说明:
 *
 * @author <a href='mailto:dennisit@163.com'>Cn.苏若年(En.dennisit)</a> Copy Right since 2013-9-16 
 *
 * org.pudp.util.Resource.java
 *
 */
public class ResourceUtil {

    /**
     * 获取资源的URL路径
     *
     * @author <a href='mailto:dennisit@163.com'>Cn.苏若年(En.dennisit)</a> Copy Right since 2013-9-16 下午09:33:07
     *                
     * @param paramString
     *             验证码图片所在的包的相对路径
     * @return
     *             验证码所在的URL
     */
    public static URL getResourceUrl(String paramString){
        return ((URLClassLoader)ResourceUtil.class.getClassLoader()).getResource(paramString);
    }

    /**
     * 获取资源的串值路径
     *
     * @author <a href='mailto:dennisit@163.com'>Cn.苏若年(En.dennisit)</a> Copy Right since 2013-9-16 下午06:09:17
     *                
     * @param paramString
     *                     验证码图片所在的包的相对路径
     * @return
     *             验证码所在的串值地址
     */
    public static String getResourcePath(String paramString){
        return Thread.currentThread().getContextClassLoader().getResource(paramString).getPath(); 
    }
    
}