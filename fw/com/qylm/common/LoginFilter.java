package com.qylm.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qylm.bean.UserBean;
import com.qylm.constants.Constants;

public class LoginFilter implements Filter {
	
//	private static final String[] urlPattern = {"/attendanceManage/timeConfigCreatePage.jsf", "/companyManage/"};
//
//	private static final int[][] allowedPermission = {{2}, {1}};
//	
//	private static final int length = urlPattern.length;
	
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		req.setCharacterEncoding(Constants.UTF_8);
		if(session == null){
			session = req.getSession(true);
			session.setAttribute(Constants.SESSION_TIME_OUT, Constants.SESSION_TIME_OUT);
			req.getRequestDispatcher("/exceptionHandler.xhtml").forward(req, res);
			return;
		}
		UserBean userBean = (UserBean) session.getAttribute("userBean");
		if (!checkLogin(userBean)) {
			session.setAttribute(Constants.NOT_LOGIN, Constants.NOT_LOGIN);
			req.getRequestDispatcher("/exceptionHandler.xhtml").forward(req, res);
			return;
		}
//		String viewId = req.getServletPath();
//		if(!checkViewId(viewId, getUserPermission(userBean.getUser()))){
//			res.sendError(HttpServletResponse.SC_NOT_FOUND);
//			return;
//		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	private boolean checkLogin(UserBean userBean){
		if(userBean == null){
			return false;
		}
		if(userBean.getUser() == null){
			return false;
		}
		return true;
	}
	
//	public boolean checkViewId(String viewId, int[] permission){
//		for (int i = 0; i < length; i++) {
//			if(viewId.startsWith(urlPattern[i])){
//				if(permission == null){
//					return false;
//				}
//				if(!checkPermission(allowedPermission[i], permission)){
//					return false;
//				}
//			}
//		}
//		return true;
//	}
//	
//	private boolean checkPermission(int[] allowedPermission, int[] permission){
//		int size = allowedPermission.length;
//		int length = permission.length;
//		int perm;
//		for (int i = 0; i < length; i++) {
//			perm = permission[i];
//			for (int j = 0; j < size; j++) {
//				if(perm == allowedPermission[j]){
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//	
//	private int[] getUserPermission(User user){
//		Set<UserRole> permissions = user.getPermissions();
//		if(permissions == null || permissions.isEmpty()){
//			return null;
//		}
//		int[] permissionLev = new int[permissions.size()];
//		int i = 0;
//		for (UserRole permission : permissions) {
//			permissionLev[i] = permission.getPermissionLevel();
//			i++;
//		}
//		return permissionLev;
//	}
	
}
