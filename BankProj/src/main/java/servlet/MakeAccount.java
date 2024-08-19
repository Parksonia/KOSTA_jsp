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
 * Servlet implementation class MakeAccount
 */
@WebServlet("/makeAccount")
public class MakeAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//view 지정 : makeaccount.jsp
		request.getRequestDispatcher("makeaccount.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청으로부터 데이터 가져오기
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Integer balance  = Integer.parseInt(request.getParameter("balance"));
		String type = request.getParameter("type");
		String grade = request.getParameter("grade");	
		Account acc = new Account(id,name,balance,type,grade);
		///////////////////////////
		
		try {
			//2. 데이터 처리하기 : Model
			AccountService service = new AccountServiceImpl();
			Account macc = service.makeAccount(acc);
			////////////////////////
			
			//3. 처리한 데이터 View 지정하여 넘겨주기 
			request.setAttribute("acc", macc);
			request.getRequestDispatcher("accountinfo.jsp").forward(request, response);
			////////////////////////
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("err", "계좌개설 실패");
			request.getRequestDispatcher("err.jsp").forward(request, response);
		}
	}

}
