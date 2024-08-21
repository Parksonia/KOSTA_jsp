package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDAO;
import dao.BoardDAOImpl;
import dto.Board;

public class BoardServiceImpl implements BoardService {

	private BoardDAO boarddao;
	public BoardServiceImpl() {
		this.boarddao = new BoardDAOImpl();
	}
	
	@Override
	public void boardWrite(HttpServletRequest request) throws Exception {

	  String path =request.getServletContext().getRealPath("upload"); // 톰캣 서버에 올라가있는 upload 폴더의 물리적 path를 얻어오는 기능
	  int size=10*1024*1024; // 크기지정 10MB
	
	  MultipartRequest multi = new MultipartRequest(request,path,size,"utf-8",
			  										new DefaultFileRenamePolicy());

	  Board board = new Board();
	  board.setSubject(multi.getParameter("subject"));
	  board.setContent(multi.getParameter("content"));
	  board.setWriter(multi.getParameter("writer"));
	  board.setFilename(multi.getFilesystemName("file"));
	  boarddao.insertBoard(board);
	}

	@Override
	public Board boardDetail(Integer num) throws Exception {
		Board board = boarddao.selectBoard(num);
		if(board ==null) throw new Exception("글 번호 오류");
				
		return board ;
	}

	@Override
	public void imageView(HttpServletRequest request,OutputStream out, String file) throws Exception {
		FileInputStream fis =null;
		String path = request.getServletContext().getRealPath("upload");
		
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

}
