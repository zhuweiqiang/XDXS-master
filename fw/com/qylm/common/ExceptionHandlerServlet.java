package com.qylm.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionHandlerServlet extends HttpServlet {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6912884839502585789L;
	
	public static final char[] DOC = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">".toCharArray();
	
	public static final char[] HEAD = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\"/></head>".toCharArray();
	
	public static final char[] FOOT = "</body></html>".toCharArray();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(DOC);
		pw.write(HEAD);
		pw.write("<body onload=\"window.top.location='");
		pw.write(request.getContextPath());
		pw.write("/login.jsf'\">");
		pw.write(FOOT);
	}

}
