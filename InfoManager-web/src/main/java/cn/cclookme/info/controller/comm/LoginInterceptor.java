package cn.cclookme.info.controller.comm;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.cclookme.info.model.user.StudentInfo;
import cn.cclookme.info.model.user.TeacherInfo;

public class LoginInterceptor  implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response,
			Object arg2) throws Exception {
		String path=request.getContextPath();
		HttpSession session=request.getSession();
		String usertype=(String) request.getSession().getAttribute("usertype");
		String sessionUserName="";
		if(usertype==null){
			response.sendRedirect(path+"/user/login");
			return false;
		}
		if(usertype.equals("student")){
			StudentInfo studentinfo=(StudentInfo) session.getAttribute("user");
			sessionUserName=studentinfo.getStudentCardid();
		}else{
			TeacherInfo teacherInfo=(TeacherInfo) session.getAttribute("user");
			sessionUserName=teacherInfo.getTeacherCardid();
		}
		String sessionid=session.getId();
		boolean boo=LoginSessionListener.isLogining(sessionUserName);
		if(boo){
			String idold=LoginSessionListener.getSessionKeyByUsername(sessionUserName);
			if(idold.equals(sessionid)){
				return true;
			}else{
				LoginSessionListener.replaceLogin(session, sessionUserName);
				return true;
			}
		}
		response.sendRedirect(path+"/user/login");
		return false;
	}


}
