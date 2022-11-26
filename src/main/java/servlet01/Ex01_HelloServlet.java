package servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//** Servlet 의 실행방식
//=> 클라이언트의 요청에 자동반응하는 이벤트 드리븐 방식으로 작동
//=> 요청방식 이 Get -> doGet , Post -> doPost

@WebServlet("/hello")
public class Ex01_HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex01_HelloServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ** 한글처리
		response.setContentType("text/html; charset=UTF-8");
		// ** 출력문
		// => 출력객체 생성 -> 출력코드
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h1 style='color:blue;'>** HELLO Servlet !!!!</h1>");
		out.print("<h1 style='color:green;'>** 안녕 Servlet !!!!</h1>");
		out.print("<h2>** Servlet 장점 : Java Codeing 매우편리 !!!!</h2>");
		out.print("<h2>** Servlet 단점 : View 작성 매우불편 !!!!</h2>");
		out.print("</body></html>");

	} //doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

} //class
