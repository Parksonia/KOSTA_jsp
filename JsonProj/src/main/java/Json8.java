
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Servlet implementation class Json8
 */
@WebServlet("/json8")
public class Json8 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Json8() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String jsonStr = request.getParameter("data");
	
		try {
			JSONParser parser =  new JSONParser();	
			JSONObject jsonObj = (JSONObject)parser.parse(jsonStr);
			JSONArray jsonArr = (JSONArray)jsonObj.get("included");
			
			JSONObject jsonArr_0 =(JSONObject)jsonArr.get(0);
			String id =(String)jsonArr_0.get("id");
			String type =(String)jsonArr_0.get("type");
			
			JSONObject attributes =(JSONObject)jsonArr_0.get("attributes");
			String name = (String)attributes.get("name");
			Long age = (Long)attributes.get("age");
			String gender = (String)attributes.get("gender");
			
	
			System.out.println(id);
			System.out.println(type);
			System.out.println(name);
			System.out.println(age);
			System.out.println(gender);
			
				response.setCharacterEncoding("utf-8");
				response.getWriter().write("전송 성공!!");

				
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		}

		
	}


