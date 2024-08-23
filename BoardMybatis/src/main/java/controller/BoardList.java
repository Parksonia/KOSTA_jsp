package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import service.BoardService;
import service.BoardServiceImpl;
import utils.PageInfo;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/boardList")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String paramPage = request.getParameter("page");
		Integer page = 1;
		if(paramPage !=null) {
			page = Integer.parseInt(paramPage);
		}
		
		try {
			BoardService service = new BoardServiceImpl();
			PageInfo pageInfo = new PageInfo();
			pageInfo.setCurPage(page);
			List<Board> boardlist = service.boardList(pageInfo); // 하나만 가져올 수 있으니(boardlist)파라미터로 객체를 넘겨서 pageInfo객체를 넘겨받은곳에서 처리해서 가져올 수 있도록 함.
			request.setAttribute("pageInfo", pageInfo);
			// for(Board b:boardlist) { System.out.println(b.getCreate_date()); }
			 
			 
			request.setAttribute("list",boardlist);
			request.getRequestDispatcher("boardlist.jsp").forward(request, response);
			
		} catch (Exception e) {
			request.setAttribute("err","게시글목록오류");
			request.getRequestDispatcher("err.jsp").forward(request, response);
		}
	
	
	}
}