package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/requestInfo")
public class Ex05_RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Ex05_RequestInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ** 기본 화면 출력
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>** Request Information **</h1>");
		out.print("<h2>** Request 주요 메서드</h2>");
		out.print("<h2>=> Console 에서 확인하세요 ~~~</h2>");
		out.print("<h2>** Request Header Names & Values **</h2>");
		out.print("<h2>** ContextPath **</h2>");
		out.print("<h3>=> 웹 어플리케이션 (현재프로젝트)의 최상위 경로</h3>");
		out.print("<h2>** RealPath **</h2>");
		out.print("<h2>** 기타등등 **</h2>");
		
		System.out.println("** Request Header Names & Values **");
		Enumeration<String> hNames = request.getHeaderNames();
		while (hNames.hasMoreElements()) {
			String hName = hNames.nextElement();
			String hValue = request.getHeader(hName);
			System.out.println(hName+" => "+hValue);
		}
		
		System.out.println("\nContextPath => "+request.getContextPath());
		System.out.println("RealPath => "+request.getRealPath("/"));
		System.out.println("** 기타등등 **");
		System.out.println("RemoteAddr => "+request.getRemoteAddr());
		System.out.println("Method => "+request.getMethod());
		System.out.println("RequestURL => "+request.getRequestURL());
		System.out.println("RequestURI => "+request.getRequestURI());
		System.out.println("ServerName => "+request.getServerName());
		System.out.println("ServerPort => "+request.getServerPort());
		System.out.println("ServletPath => "+request.getServletPath());
	
	} //doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

} // class
