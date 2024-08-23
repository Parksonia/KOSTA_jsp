package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	  board.setDfilename(multi.getFilesystemName("dfile"));
	  
	  boarddao.insertBoard(board);
	}

	@Override
	public Board boardDetail(Integer num) throws Exception {
		Board board = boarddao.selectBoard(num);
		if(board == null) throw new Exception("글 번호 오류");
		boarddao.updateViewCnt(num);
				
		return board ;
	}

	//이미지view
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
	//paging 처리와 동시에 화면에 보여져야하는 row 반환
	@Override
	public List<Board> boardList(PageInfo pageInfo) throws Exception {
		Integer boardCnt = boarddao.selectBoardCount();
		
		Integer allPage = (int)Math.ceil((double)boardCnt/10); // 반올림 해야 마지막 페이지가 제대로 나올 수 있음.(> 버튼 활성화 비활성화에 활용)
		
		
		//startButton- 1~10 :1 / 11~20: 11
		Integer startPage = (pageInfo.getCurPage()-1)/10*10+1; //1,11,21,31....
		
		
		//endButton
		Integer endPage = startPage+10-1;
		
		if(endPage > allPage) endPage = allPage;
		
		pageInfo.setAllPage(allPage);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);  // pageInfo객체를 저장함 
		
	    //페이지 의 시작하는  로우를 계산해서 넘김
		Integer row = (pageInfo.getCurPage()-1) *10 +1; // "1"~10/ "11"~20/ "21"~30....  
		
		return  boarddao.selectBoardList(row);
	}

	@Override
	public Integer checkHear(String memberId, Integer boardNum) throws Exception {
		
		return heartdao.selectHeart(memberId, boardNum);
	}

	@Override
	public boolean toggleHeart(String id, Integer boardNum) throws Exception {
		//heartDAO의 select, insert 활용 있으면 삭제, 없으면 삽입
		Integer heartNum  = heartdao.selectHeart(id, boardNum);
		
		if(heartNum == null) { // 없으면 인서트
			heartdao.insertHeart(id, boardNum);
			return true;
		
		}else {
			heartdao.deleteHeart(id, boardNum);
			return false;
		}
	}

	@Override
	public void fileDown(HttpServletRequest request, HttpServletResponse response) 
			throws Exception , IOException {
		//request로부터 파일명 가져옴
		String file = request.getParameter("file");
		//실제 경로
		String path = request.getServletContext().getRealPath("upload"); 
		FileInputStream fis = new FileInputStream(new File(path,file));
		
		//파일 형식을 가져옴 (경로와 파일명을 보내면)
		String mimeType = request.getServletContext().getMimeType(path+"\\"+file);
		
		if(mimeType == null) { // 파일형식이 없으면  따로 지정해줌
			mimeType = "application/octet-stream"; // octet-stream: 8비트로된 일련의 데이터를 뜻함 (지정되지 않은 파일 타입을 의미) 
		}
		//브라우저에게 어떤 타입의 데이터를 보내는지 알려줌
		response.setContentType(mimeType);
		
		//인코딩 타입 지정 : 파일명이 한글일 수 있으니 깨짐 방지를 위해 지정해줌
		String encoding = new String(file.getBytes("utf-8"),"8859_1");
		
		//헤더에 파일명을 넣어줌
		response.setHeader("content-Disposition", "attachmemt; filename="+encoding);
		
		OutputStream out = response.getOutputStream();
		byte[] buff = new byte[4096];
		int len;
		while((len=fis.read(buff))>0) {
			out.write(buff,0,len);
		}
		fis.close();
	}

}
