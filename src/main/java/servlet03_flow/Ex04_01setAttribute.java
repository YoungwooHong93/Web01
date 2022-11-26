package servlet03_flow;

import java.io.IOException;
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
// => request.removeAttribute("message") : 삭제가능

@WebServlet("/01seta")
public class Ex04_01setAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Ex04_01setAttribute() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) request Parameter 처리
		// => form 없이 Query 스트링으로 Test
		//	  .../01seta?num=1234&name=홍길동
		String num = request.getParameter("num");
		String name = request.getParameter("name");
		System.out.println("** setAttribute Test **");
		System.out.printf("** Parameter num = %s, name = %s %n",num, name);
		
		// 2) setAttribute 로 보관하기.
		// => request 에 보관
		request.setAttribute("rNum", num);
		request.setAttribute("rName", name);
		
		// => session 에 보관 -> session 인스턴스 필요함
		HttpSession session = request.getSession();
		session.setAttribute("sNum", num);
		session.setAttribute("sName", name);
		// => session 인스턴스를 많이 사용하지 않는다면 한줄로 아래처럼 사용
		//request.getSession().setAttribute("sName", name);
		
		// 3) 보관한 Attribute 확인 -> /02geta
		// => forward
		String uri = "02geta";
		//request.getRequestDispatcher(uri).forward(request, response);
		
		// => redirect
		//	  출력예측 : 1) forward 외 동일, 2) 아니다
		response.sendRedirect(uri);
		
	} //doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
} //class
