package ch01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

/**
 * Servlet implementation class Add3
 */
@WebServlet("/Add3")  //이 문장을 모자라고 하고, 지금은 하나로만 구성되어 있지만 나중에 spring에서는 여러개의 모자가 생성된다.
public class Add3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //request(요청)  데이터들을 넘겨달라고 요청하는것이고
    //response(응답) 받은 데이터들을 처리해준다는 것이다.  
	                                     // request안에 input태그의 name값을 입력한 데이터들을 가지고 있다.
                                         //request로 넘겨온 데이터들은 String으로 넘어온다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 목표  : 1부터 누적값 전달
		int num = Integer.parseInt(request.getParameter("num")); // num은 숫자 인데 넘겨온것은 문자로 넘어와서 Integer로 변경해줬다.(그래서 String으로 넘어온것은 숫자로 변경하여 작성하였다.)
		String loc = request.getParameter("loc");                // loc은 문자열이라서 그대로 받으면 된다.
		System.out.println("Add3 num->" + num);  //html 실행시켜 값을 넣으면 콘솔창에서 확인할수 있다.
		System.out.println("Add3 loc->" + loc);  //html 실행시켜 값을 넣으면 콘솔창에서 확인할수 있다.
		int sum = 0;
		for (int i=1; i<= num; i++)  {
			sum +=1;
		}
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 공식 -->사용자 Browser에 보여주는 객체
		PrintWriter out = response.getWriter();     //PrintWriter은 out.println를 사용하기 위해 작성해준다.
		out.println("<html><body>");			    //out.println을 작성해줄때는 Html태그들과 함께 작성해줘야한다.
		out.printf("<h1>1부터 %d까지 합계</h1>", num);
		out.printf("<h4>loc--> %s</h4>", loc);
		out.println(sum);
		out.println("</body></html>");
		out.close();
		//위 작성법은 서블릿을 사용하는 사람들의 공식처럼 사용된다고 한다.
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("doPost 시작");  //Post가 먼저 돌아가는지 확인하기 위해 작성하였다.(콘솔창에서 확인)
		doGet(request, response);
		
		//Post방식은 request.setCharacterEncoding("utf-8");을 작성하지 않으면
		//문자가 깨진다. 그 이유는 보안때문이다.
	}

}
