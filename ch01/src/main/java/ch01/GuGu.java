package ch01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuGu
 */
//@WebServlet("/GuGu")  // 이 코드가 없을때는 XML으로 연결해준다.(webapp폴더/lib폴더/web.xml파일에서)
public class GuGu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuGu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num"));
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h1>구구단 "+ num + "단</h1>");
		for (int i=1; i<=9; i++) {
			out.printf("%d * %d = %d<br>",num,i,(num*i)); //Java로 한것과 같다.
		}			
		out.print("</body></html>");
		out.close();
		// 단을 선택하고 확인을 눌르면 선택한 결과가 나온다.
		// 선택한 결과값에서 나온 URL 
		// http://localhost:8181  /och01       /GuGu        ?          num      =   6
		//      Tomcat설치할때생성번호/파일의 폴더이름 /서블릿파일이름/파라매타값/value값을 넘겨받는/선택한값
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
