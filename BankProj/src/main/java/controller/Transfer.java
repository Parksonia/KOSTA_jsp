package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Account;
import service.AccountService;
import service.AccountServiceImpl;

/**
 * Servlet implementation class Transfer
 */
@WebServlet("/transfer")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transfer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("transfer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sid= request.getParameter("sid");
		String rid= request.getParameter("rid");
		Integer money = Integer.parseInt(request.getParameter("money"));
		
		try {
			AccountService service = new AccountServiceImpl();
			service.transfer(sid,rid,money);
			response.sendRedirect("transfer");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("err",e.getMessage());
			request.getRequestDispatcher("err.jpg").forward(request, response);
		}
		
	}

}
