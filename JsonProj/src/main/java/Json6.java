

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class Json6
 */
@WebServlet("/json6")
public class Json6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Json6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Person> pers = new ArrayList<>();
		
		pers.add(new Person("홍길동",30));
		pers.add(new Person("송길동",40));
		pers.add(new Person("하길동",50));
		
		//역으로 스크립트가 읽을 수 있는 오브젝트타입으로 변환
		Gson gson =  new Gson();
		String jsonStr = gson.toJson(pers);
		System.out.println(jsonStr);
			

		response.setCharacterEncoding("utf-8");			
		response.getWriter().write(jsonStr);
	
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
	}
}
