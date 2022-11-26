package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check")
public class Ex03_Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex03_Check() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 요청분석
		// => 한글확인 (get: default utf-8, post: 반드시 필요함)
		//    Parameter 처리
		request.setCharacterEncoding("UTF-8");
		
		// ** checkbox : 하나의 Name에 복수개의 Value 가 있음
		// => getParameterValues("..") 를 이용하여 배열로 처리.
		String[] gift = request.getParameterValues("gift");
		
		// 2) Service
		// 3) View
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h1>** CheckBox Test **</h1>");
		
		// => 선택여부를 확인 하고 출력
		if (gift != null) {
			// 선택
			out.print("<h2>** 선택항목 =></h2>");
			for (String s:gift) {
				out.print(s+"<br>");
			}
		}else {
			out.print("<h2>=> 선택항목이 없습니다.</h2>");
		}
		
		out.print("<br><br><h2><a href='javascript:history.go(-1)'>다시 선택하기</a></h2><br>");
		out.print("</body></html>");
	} //doGet
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
} //class
