package servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
//** url 매핑 네임
//=> url 배열 형태로 복수 선언가능
//=> 그러나 프로젝트 전체 기준 중복되면 안됨 : server Start 안됨. 
//=> 한글 사용시 오류는 없으나 비추
//=> xml 로 설정가능 (web.xml 설정화일)

//@WebServlet("/GuGu")
//@WebServlet(urlPatterns = {"/GuGu","/gugu","/99","/구구"})
public class Ex02_GuGu extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Ex02_GuGu() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ** 구구단 2~9단 출력하기
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.print("<html><body><h2 style=\"color:purple\">");
		out.print("** 구구단 출력 Servlet **<br>");
			
		for(int i=1;i<=9;i++) {
			for(int j=2;j<=9;j++) {
				out.print(j+"*"+i+"="+(i*j)+"&nbsp;");	
			} // for_j
			out.print("<br>");
		} // for_i	
		out.print("</h2></body></html>");
	} //doGet
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

} //class
