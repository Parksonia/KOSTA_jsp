package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import service.BoardServiceImpl;

/**
 * Servlet implementation class Heart
 */
@WebServlet("/heart")
public class Heart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Heart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = (String)request.getSession().getAttribute("id"); //id 정보 가져옴 
		Integer num = Integer.parseInt(request.getParameter("num"));
		BoardService service  = new BoardServiceImpl();
		
		
		try {
			boolean isHeart = service.toggleHeart(id,num);
			response.getWriter().write(String.valueOf(isHeart));
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
