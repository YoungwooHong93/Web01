package servlet01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/life")
public class Ex04_LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int cno=1; // 생성자 메서드 호출횟수
	int ino=1; // init() 메서드 호출횟수
	int dno=1; // destroy() 메서드 호출횟수
	int gno=1; // doGet() 메서드 호출횟수
  
	// 생성자 (메모리에 load) : 서버 스타트 후 첫요청 들어오면 자동생성
    public Ex04_LifeCycle() {
        super();
        System.out.println("** 생성자 메서드 호출횟수 => "+cno++);
    }
    // init : 인스턴스 생성직후 자동호출
	public void init(ServletConfig config) throws ServletException {
		 System.out.println("** init() 메서드 호출횟수 => "+ino++);
	} //init

	// destroy (메모리에서 소멸) : 서버종료시 (모든자원 close)
	public void destroy() {
		System.out.println("** destroy() 메서드 호출횟수 => "+dno++);
	} //destroy
 
	// doGet : 클라이언트로부터 Get 요청이 들어왔을때 자동 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>** Servlet LifeCycle Test **</h1>");
		out.print("<pre><h3>");
		out.println("** 현재시간 : "+new Date());
		out.println("** doGet() 호출횟수 : "+gno);
		out.print("</h3></pre>");
		System.out.println("** doGet() 메서드 호출횟수 => "+gno++);
	} //doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	} //doPost

} //class
