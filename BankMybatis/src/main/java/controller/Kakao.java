package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import service.LoginService;
import service.LoginServiceImpl;

/**
 * Servlet implementation class Kakao
 */
@WebServlet("/kakao")
public class Kakao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kakao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
	
		
		String code = request.getParameter("code");  //login할때마다 카카오가 줌 
		System.out.println(code);

		try {
			LoginService service = new LoginServiceImpl();
			Member member = service.kakaoLogin(code);
			// 세션에  저장하기
			member.setPassword("");
			request.getSession().setAttribute("member", member);
			request.getRequestDispatcher("makeaccount.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("err", "kakao로그인 실패!");
			request.getRequestDispatcher("err.jsp").forward(request, response);
		}
	}

}
