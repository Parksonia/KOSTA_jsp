package service;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.Board;
import util.PageInfo;

public interface BoardService {
	//컨트롤러를 거치지 않고 서비스에서 데이터를 바로 넘겨받으려고함-> HttpServletRequest
	
	void boardWrite(HttpServletRequest request) throws Exception;
	
	Board boardDetail(Integer num) throws Exception;
	
	void imageView(HttpServletRequest request, OutputStream out,String file) throws Exception;
	
	//게시글 수정
	Integer boardModify(HttpServletRequest request) throws Exception;

	List<Board>boardList(PageInfo pageInfo) throws Exception;

	// 상세보기에 좋아요 표시하기 위함
	Integer checkHear(String memberId,Integer boardNum) throws Exception;
}
