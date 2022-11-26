package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adder")
public class Ex01_Adder extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Ex01_Adder() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) request 처리 (요청분석)
		// => 한글있는지 확인, Parameter 처리
		//request.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html; charset=UTF-8");
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		//String num1 = request.getParameter("num1");
		//String num2 = request.getParameter("num2");
		
		// 2) Service : 연산
		//int n1 = Integer.parseInt(num1);
		//int n2 = Integer.parseInt(num2);
		
//		int plus = n1+n2;
//		int min = n1-n2;
//		int mul = n1*n2;
//		int div = n1/n2;
		
		// 3) View 처리
		//response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h1> ** Adder Test **</h1>");
		out.print("<h2> => "+ num1 + " + " + num2 + " = " +(num1+num2) + "</h2>");
		
		//out.print("<h1>** 사칙 연산 Test **</h1>");
		//out.println("<h2> num 1 + num 2 =>"+plus+"</h2>");
		//out.println("<h2> num 1 - num 2 =>"+min+"</h2>");
		//out.println("<h2> num 1 * num 2 =>"+mul+"</h2>");
		//out.println("<h2> num 1 / num 2 =>"+div+"</h2>");
		out.print("</body></html>");
		
	} //doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	} //doPost

} //class
