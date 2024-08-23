package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import service.BoardService;
import service.BoardServiceImpl;

/**
 * Servlet implementation class BoardDetail
 */
@WebServlet("/boardDetail")
public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//url boardDetail?num=1  로 파라미터 넘김

		Integer num = Integer.parseInt(request.getParameter("num"));
		try {
			BoardService service = new BoardServiceImpl();
			Board board = service.boardDetail(num);
			request.setAttribute("board", board);
			
			String  id = (String)request.getSession().getAttribute("id"); // 세션통해 로그인정보 가져옴
			
			if(id!=null) { //세션에서 아이디가 있으면(로그인 시에만 좋아요 조회)
				request.setAttribute("heart",service.checkHear(id, num));
			}
			
			request.getRequestDispatcher("boarddetail.jsp").forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("err",e.getMessage());
			request.getRequestDispatcher("err.jsp").forward(request, response);
		}
	}


}
