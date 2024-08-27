package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import service.MemberService;
import service.MemberServiceImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cookie = request.getHeader("Cookie");
		String autoLogin = null;
		String id = null;
		String password = null;


			
		if(cookie !=null) {
			Cookie[] cookies = request.getCookies();
			for(Cookie c : cookies) {
				if(c.getName().equals("autologin")) {
					autoLogin = c.getValue();
				}
				if(c.getName().equals("id")) {
					id = c.getValue();
				}
				if(c.getName().equals("password")) {
					password = c.getValue();
				}
			}
		}
		if(autoLogin != null) {
			request.setAttribute("autologin",autoLogin);
			request.setAttribute("id",id);
			request.setAttribute("password",password);
			
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String autoLogin = request.getParameter("autologin");
		
		//Member member = null;
		try {
			MemberService mservice = new MemberServiceImpl();
			Member member = mservice.login(id, password);
			member.setPassword("");
			//response.sendRedirect("makeaccount");
			request.getSession().setAttribute("member", member); 
			
			if(autoLogin != null) {
				Cookie cookieId = new Cookie("id",id);
				cookieId.setMaxAge(60*60*24);
				response.addCookie(cookieId);
				
				Cookie cookiePW = new Cookie("password",password);
				cookiePW.setMaxAge(60*60*24);
				response.addCookie(cookiePW);
				
				Cookie cookieAutoLogin = new Cookie("autologin",autoLogin);
				cookieAutoLogin.setMaxAge(60*60*24);
				response.addCookie(cookieAutoLogin);
	
			}else { // 이미 쿠키가 있으면 삭제 하는 작업 실행
				Cookie cookieId = new Cookie("id",id);
				cookieId.setMaxAge(0);
				response.addCookie(cookieId);
				
				Cookie cookiePW = new Cookie("password",password);
				cookiePW.setMaxAge(0);
				response.addCookie(cookiePW);
				
				Cookie cookieAutoLogin = new Cookie("autologin",autoLogin);
				cookieAutoLogin.setMaxAge(0);
				response.addCookie(cookieAutoLogin);
				
			}
			request.getRequestDispatcher("makeaccount.jsp").forward(request, response); /* 반드시 jsp로 해야함!! */
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("err",e.getMessage());
			request.getRequestDispatcher("err.jsp").forward(request, response);
		}
		
		
		
	}

}
