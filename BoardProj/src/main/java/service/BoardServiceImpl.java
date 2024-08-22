package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDAO;
import dao.BoardDAOImpl;
import dao.HeartDAO;
import dao.HeartDAOImpl;
import dto.Board;
import util.PageInfo;

public class BoardServiceImpl implements BoardService {

	private BoardDAO boarddao;
	private HeartDAO heartdao;
	public BoardServiceImpl() {
		this.boarddao = new BoardDAOImpl();
		this.heartdao = new HeartDAOImpl();
	}
	
	@Override
	public void boardWrite(HttpServletRequest request) throws Exception {

	  String path =request.getServletContext().getRealPath("upload"); // 톰캣 서버에 올라가있는 upload 폴더의 물리적 path를 얻어오는 기능
	  int size=10*1024*1024; // 크기지정 10MB
	
	  MultipartRequest multi = new MultipartRequest(request,path,size,"utf-8",
			  										new DefaultFileRenamePolicy()); //DefaultFileRenamePolicy : 이미 존재하는 파일이라면 다른 이름을 붙임
	  

	  Board board = new Board();
	  board.setSubject(multi.getParameter("subject")); // mulitpartform으로 데이터를 저장했으니 가져올때도  multi로 가져옴(name은form태그에서 설정한 name이다.) 
	  board.setContent(multi.getParameter("content"));
	  board.setWriter(multi.getParameter("writer"));
	  board.setFilename(multi.getFilesystemName("file"));
	  boarddao.insertBoard(board);
	}

	@Override
	public Board boardDetail(Integer num) throws Exception {
		Board board = boarddao.selectBoard(num);
		if(board == null) throw new Exception("글 번호 오류");
		boarddao.updateViewCnt(num);
				
		return board ;
	}

	@Override
	public void imageView(HttpServletRequest request,OutputStream out, String file) throws Exception {
		FileInputStream fis =null;
		String path = request.getServletContext().getRealPath("upload"); // servercore의 경로를 가져옴 getServletContext는 request만 가지고 있음 
		
		try {
			fis = new FileInputStream(new File(path,file));
			byte[] buff=  new byte[4096];
			int len;
			while((len=fis.read(buff))>0) {
				out.write(buff,0,len);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null) fis.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

	@Override
	public Integer boardModify(HttpServletRequest request) throws Exception {
	
		 String path =request.getServletContext().getRealPath("upload"); 
		  int size=10*1024*1024; // 크기지정 10MB
		
		  MultipartRequest multi = new MultipartRequest(request,path,size,"utf-8",
				  										new DefaultFileRenamePolicy()); 
	
		  Board board = new Board();
		  board.setNum(Integer.parseInt(multi.getParameter("num")));
		  board.setSubject(multi.getParameter("subject"));
		  board.setContent(multi.getParameter("content"));
		  
		  // db에 존재하는 파일 명 찾아서 업데이트( 파일이 존재한다면  수정 )
		  if(multi.getFile("file")!=null) {
			  board.setFilename(multi.getFilesystemName("file"));
		  }
		   boarddao.updateBoard(board);
		  
		   return board.getNum();
	
	}

	@Override
	public List<Board> boardList(PageInfo pageInfo) throws Exception {
		Integer boardCnt = boarddao.selectBoardCount();
		
		Integer allPage = (int)Math.ceil((double)boardCnt/10); // 반올림 해야 마지막 페이지가 제대로 나올 수 있음.
		
		//startButton- 1~10 :1 / 11~20: 11
		Integer startPage = (pageInfo.getCurPage()-1)/10*10+1; //1,11,21,31....
		
		//endButton
	
		Integer endPage = startPage+10-1;
		
		if(endPage > allPage) endPage = allPage;
		
		pageInfo.setAllPage(allPage);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		
	    //페이지 가지고 로우를 계산해서 넘김
		Integer row = (pageInfo.getCurPage()-1) *10 +1; // "1"~10/ "11"~20/ "21"~30....  
		
		return  boarddao.selectBoardList(row);
	}

	@Override
	public Integer checkHear(String memberId, Integer boardNum) throws Exception {
		
		return heartdao.selectHeart(memberId, boardNum);
	}

}
