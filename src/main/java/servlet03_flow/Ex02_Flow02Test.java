package servlet03_flow;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/flow02")
public class Ex02_Flow02Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex02_Flow02Test() {
        super();
    }

// ** 웹 페이지의 이동 (PageFlow) Test
// => testForm : servletTestForm/flow02_TestForm.jsp
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ** Reqest 분석 & 처리
		// => 이동위치 (uri)  
		String pageCode = request.getParameter("page");
		String uri = "";
		if (pageCode.equals("1")) {
			uri="hello" ;
		}else if (pageCode.equals("2")) {
			uri="gugu" ;
		}else if (pageCode.equals("3")) {
			uri="servletTestForm/form03_Check.jsp" ;
		}else if (pageCode.equals("4")) {
			uri="servletTestForm/form04_Select.jsp" ;	
		}else System.out.println("** PageCode 를 정확하게 선택하지 않음 ~~");	
			
		// ** Response 처리	
		// => 이동방법 (Forward/Redirect)
		
		//if ("f".equals(request.getParameter("send"))) {
		// ** NullPointExeption 예방
		// => request.getParameter("send")가 값이 없는경우 NullPointExeption 발생 
		if (request.getParameter("send").equals("f")) {
			// Forward 이동 : 서버내에서 결과 웹 Page가 바뀜  
			request.getRequestDispatcher(uri).forward(request, response); 
		}else {
			// Redirect : 재요청 처리
			response.sendRedirect(uri);
		}
		
	} //doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
} //class
