package mvcTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
// ** sList 요청
// => MVC 패턴2
//	- View , Controller 가 분리된 유형
//	- servlet : 요청받고 Service 요청 처리 후 결과를 View(Jsp) 가 처리하도록 함. 
//	  jsp : View 를 완성함.
@WebServlet("/sdetail2")
public class MVC2_02sDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public MVC2_02sDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 요청분석 & Service 처리 => Controller 역할
		StudentService service =  new StudentService();
		StudentVO vo = new StudentVO();
		vo.setSnum(Integer.parseInt(request.getParameter("snum")));
		vo = service.selectOne(vo);
		
		// 2) 결과를 View(Jsp) 가 처리하도록 함
		// => 결과를 View(Jsp) 가 인식 할 수 있도록 해줘야 함 : setAttribute
		// => forward 
		request.setAttribute("apple", vo);
		request.getRequestDispatcher("jsp08_MVCTest/mvc2_02sDetail.jsp").forward(request, response);
		
	} //doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	} 
} //class
