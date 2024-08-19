package servlet;

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
 * Servlet implementation class AccountInfo
 */
@WebServlet("/accountInfo")
public class AccountInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("accountinfoform.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		AccountService service = new AccountServiceImpl();
		try {
			Account sacc = service.accountinfo(id);
			request.setAttribute("acc", sacc);
			request.getRequestDispatcher("accountinfo.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("err", "존재하지않습니다.");
			request.getRequestDispatcher("err.jsp").forward(request, response);
			e.printStackTrace();
		}
		
		
	}

}
