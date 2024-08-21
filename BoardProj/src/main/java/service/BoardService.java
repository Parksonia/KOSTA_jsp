package service;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import dto.Board;

public interface BoardService {
	//컨트롤러를 거치지 않고 서비스에서 데이터를 바로 넘겨받으려고함-> HttpServletRequest
	void boardWrite(HttpServletRequest request) throws Exception;
	Board boardDetail(Integer num) throws Exception;
	void imageView(HttpServletRequest request, OutputStream out,String file) throws Exception;
	
}
