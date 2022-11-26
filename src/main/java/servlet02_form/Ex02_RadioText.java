package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/radio")
public class Ex02_RadioText extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex02_RadioText() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 요청분석
		// => 한글확인 (get: default utf-8, post: 반드시 필요함)
		//    Parameter 처리
		request.setCharacterEncoding("UTF-8");
		
		String gender = request.getParameter("gender");
		String mailcheck = request.getParameter("mailcheck");
		String content = request.getParameter("content");
		
		// 2) Service
		if (mailcheck.equals("Yes")) mailcheck = "수신동의";
		else mailcheck = "수신거절";
		
		// 3) View
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h1>** Radio & TextArea Test **</h1>");
		out.print("<h2>** 성별 : "+gender+"</h2>");
		out.print("<h2>** 메일 : "+mailcheck+"</h2>");
		out.print("<h2>** 인사 : "+content+"</h2>");
		out.print("<br><br><h2><a href='javascript:history.go(-1)'>다시 입력하기</a></h2><br>");
		out.print("</body></html>");
	} //doGet
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
} //class
