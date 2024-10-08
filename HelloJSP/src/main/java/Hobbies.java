

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hobbies
 */
@WebServlet("/Hobbies")
public class Hobbies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hobbies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	String[] hobbies = request.getParameterValues("hobby");
	response.setContentType("text/html; charset=UTF-8");
	response.setCharacterEncoding("utf-8");
	
	PrintWriter writer = response.getWriter();
	for(String hobby : hobbies) {
		writer.println(String.format("<h3>%s</h3>", hobby));
	}
	
	}

}
