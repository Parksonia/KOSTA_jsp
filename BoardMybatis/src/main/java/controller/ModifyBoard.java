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
 * Servlet implementation class UpdateBoard
 */
@WebServlet("/modifyboard")
public class ModifyBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Integer num =Integer.parseInt(request.getParameter("num"));
		
		try {
			BoardService service = new BoardServiceImpl();
			Board board = service.boardDetail(num);
			request.setAttribute("board", board);
			request.getRequestDispatcher("modifyform.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("err",e.getMessage());
			request.getRequestDispatcher("err.jsp").forward(request, response);
		}
		

	}

	//수정 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = new BoardServiceImpl();
	
		try {
			Integer num= service.boardModify(request);
			Board board = service.boardDetail(num); // 수정된거 가져오기
			request.setAttribute("board", board);
			request.getRequestDispatcher("boarddetail.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("err",e.getMessage());
			request.getRequestDispatcher("err.jsp").forward(request, response);
		}
	
	}

}
