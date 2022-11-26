package mvcTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
// ** sList 요청
// => MVC 패턴1
//	- View , Controller 가 분리되지 않은 유형
//	- servlet 에서 요청받고 출력 모두 처리함. 

@WebServlet("/sdetail")
public class MVC1_02sdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public MVC1_02sdetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 요청분석 & Service 처리 => Controller 역할
		StudentService service =  new StudentService();
		StudentVO vo = new StudentVO();
		vo.setSnum(Integer.parseInt(request.getParameter("snum")));
		vo = service.selectOne(vo);
		
		// 2) 결과 출력 => View 역할
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h2>** Student Info **</h2>");
		if (vo != null) {
			 out.print(vo+"<br>");
		}else {
			out.print("<h3>** 해당 자료가 없습니다. **</h3>");
		}
	
	} //doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	} 
} //class
