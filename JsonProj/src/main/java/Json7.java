

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class Json7
 */
@WebServlet("/json7")
public class Json7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Json7() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<Person> pers = new ArrayList<>();
		
		pers.add(new Person("홍길동",30));
		pers.add(new Person("송길동",40));
		pers.add(new Person("하길동",50));
		
		String team = "코스타";
		String area = "서울 금천구 독산동";
		
		//{"team":"코스타", "area":"서울 금천구 독산동","pers":[{}]} 이런 형식으로 내보내려고 함
		
		JSONObject jsonObj  = new JSONObject();
		jsonObj.put("team",team);
		jsonObj.put("area",area);
		
		JSONArray  jsonArr = new JSONArray();
		for(Person per : pers) {
			JSONObject jsonPer = new JSONObject();
			jsonPer.put("name", per.getName());
			jsonPer.put("age", per.getAge());
			jsonArr.add(jsonPer);
		}
		jsonObj.put("pers", jsonArr);
		System.out.println(jsonObj.toJSONString());
		
		response.setCharacterEncoding("utf-8");			
		response.getWriter().write(jsonObj.toJSONString());
	
	}

}
