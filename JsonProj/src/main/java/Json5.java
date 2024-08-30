

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Servlet implementation class Json5
 */
@WebServlet("/json5")
public class Json5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Json5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		String param = request.getParameter("param");
		System.out.println(param);
		
		JSONParser parser = new JSONParser();
		try {
			
			JSONObject jsonObj = (JSONObject) parser.parse(param);  //persons object  파싱
			JSONArray jsonArr = (JSONArray)jsonObj.get("persons"); // array형태인 persons 를  jsonarray로 캐스팅
			
			
			for(Object obj : jsonArr) {
				
				JSONObject jsonObj2 =(JSONObject)obj;
				System.out.println(jsonObj2);
				 
				String name = (String) jsonObj2.get("name");
				Long age = (Long)jsonObj2.get("age");
				
				 System.out.println(String.format("이름: %s , 나이:%d", name,age));
				
			}
			
			response.setCharacterEncoding("utf-8");			
			response.getWriter().write("전송 성공");
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
