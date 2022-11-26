package servlet03_flow;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// ** Attribute 생성
// => setAttribute("Attribute Name", Value_ObjectType)    
// => 웹 환경에서 제공되는 기본객체들 (request, response, out, session ....) 중
//    page, request, session, application 에 만 생성가능  

@WebServlet("/02geta")
public class Ex04_02getAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Ex04_02getAttribute() {
        super();
    }
    
    // ** Attribute 사용
    // => getAttribute , 출력  
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) getAttribute 처리
		// => request, session
		
		String rNum = (String)request.getAttribute("rNum");
		String rName = (String)request.getAttribute("rName");
		String sNum = (String)request.getSession().getAttribute("sNum");
		String sName = (String)request.getSession().getAttribute("sName");
		
		// 2) View
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>** getParameter **</h1>");
		out.print("<h2>=> request의 값이 유지되는지 확인 </h2>");
		out.print("<h2>num : " +request.getParameter("num")+ "</h2>");
		out.print("<h2>name : " +request.getParameter("name")+ "</h2>");
		
		out.print("<h1>** getAttribute : request **</h1>");
		out.print("<h2>rNum : " +rNum+ "</h2>");
		out.print("<h2>rName : " +rName+ "</h2>");
		
		out.print("<h1>** getAttribute : session **</h1>");
		out.print("<h2>sNum : " +sNum+ "</h2>");
		out.print("<h2>sName : " +sName+ "</h2>");
		
		
	} //doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
} //class
