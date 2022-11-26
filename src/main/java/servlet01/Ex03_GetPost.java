package servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//** HttpServletRequest 계층도
//=> ServletRequest (I) -> HttpServletRequest (I)     
 
//** Get : request 의 header 영역의 url에 쿼리스트링으로 전달,
//       일반적으로 256 byte 이내로 크기제한이 있는 것으로 알려져 있으나,
//       이 용량은 브라우져 또는 장비에 따라 다를수 있음
//       결론은 이미지 등 무거운 자료의 전송은 대부분 불가능 하므로 이때는 post로 해야함.  
//** Post: request 의 body 영역에 담겨져 전달 (크기제한 없음, 보안성) 

@WebServlet("/getpost")
public class Ex03_GetPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex03_GetPost() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 요청분석
		
		// => 한글처리 (request, response 모두 필요)
		
		// ** request
		// => Get 방식 : request Parameter 처리 에서는 안해도 됨 
		//    Get 방식에서는 서버가 default "UTF-8" 로 처리 하기 때문 
		//   ( html 문서에서 "UTF-8" 작성되었고 , get 방식으로 전송되면 생략가능
		//     단, post 방식에서는 처리해야함 ) 
		
		response.setContentType("text/html; charset=UTF-8");
		// ** response 타입 지정 
		// => 웹브라우져에게 처리할 데이터의 MIME 타입을 알려줌
		// => MIME : Multipurpose Internet Mail Extensions
		// => 데이터 송.수신시 자료의 형식에 대한 정보 
		// => Jsp 의 page 디렉티브의 contentType 속성값과 동일
		
		// => Parameter 처리
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		// 2) Service 처리 => 생략
		// 3) View 처리
		// => 출력객체 생성, html 작성
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h1>** Get 방식 Test **</h1>");
		out.print("<h2>=> action 정상적으로 잘 전달됨 ~~~</h2>");
		out.print("<h2>=> I  D: "+id+"</h2>");
		out.print("<h2>=> Name: "+name+"</h2>");
		out.print("</body></html>");
	} //doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 요청분석
		// => 한글처리 (request, response 모두 필요)
		// => Post 요청시에는 반드시 한글처리 필요함.
		//    Parameter 처리 전에 해야함.
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// => Parameter 처리
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		// 2) Service 처리 => 생략
		// 3) View 처리
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h1>** Post 방식 Test **</h1>");
		out.print("<h2>=> action 정상적으로 잘 전달됨 ~~~</h2>");
		out.print("<h2>=> I  D: "+id+"</h2>");
		out.print("<h2>=> Name: "+name+"</h2>");
		out.print("</body></html>");
	}
} //class
