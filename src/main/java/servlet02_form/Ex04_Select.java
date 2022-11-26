package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/select")
public class Ex04_Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex04_Select() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 요청분석
		// => 한글확인 (get: default utf-8, post: 반드시 필요함)
		request.setCharacterEncoding("UTF-8");
		// 2) Service
		// 3) View
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h1>** Select Test **</h1>");
		
		// ** Parameter 처리 & 선택여부를 확인 하고 출력하기
		
		// => 단일선택 select : job
		// => null 값 Test
		// 		String job = request.getParameter("job1");
		// 		- job1 자체가 존재하지 않으면 null 을 return : NullPointerException
		//   	- if ( job.equals("Programmer") ) 
		// 		- parameter 는 존재하는데 그 값이 "" 인 경우 (null 을 return 하지 않음) 와 구분 
		
		String job = request.getParameter("job");
		if (job==null || job.length()<1) {
			// 위 와 같은 구문에서는 job 의 null 여부를 확인하는것이 안전
			out.print("** 당신이 선택한 직업은 없습니다. **<br>");
		}else {
			out.print("** 당신이 선택한 직업은 => " + job + " 입니다.<br>");
		}

		// => 다중선택 select : interest
		// 	- 하나의 Name에 복수개의 Value 가 있음
		// 	- getParameterValues("..") 를 이용하여 배열로 처리.
		out.print("<h2>** 당신의 관심분야 **</h2>");
		String[] interest = request.getParameterValues("interest");
		if (interest != null) {
			for (String i : interest) {
				out.print(i + "<br>");
			}
		} else {
			out.print("~~ 선택 항목이 없습니다. ~~<br>");
		}
		out.print("<br><br><h2><a href='javascript:history.go(-1)'>다시 선택하기</a></h2><br>");
		out.print("</body></html>");
	} //doGet
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
} //class
