package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.MemberServiceImpl;

/**
 * Servlet implementation class memberDoubleId
 */
@WebServlet("/memberDoubleId")
public class memberDoubleId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberDoubleId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id= request.getParameter("id");
		
		try {
		MemberService service = new MemberServiceImpl();
		boolean doubleId = service.checkDoubleId(id); //중복아이디면 false
		System.out.println(doubleId);
		response.getWriter().write(String.valueOf(doubleId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
