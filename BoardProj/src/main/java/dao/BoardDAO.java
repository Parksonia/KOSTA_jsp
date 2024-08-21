package dao;

import dto.Board;

public interface BoardDAO {

		void insertBoard(Board board) throws Exception;
		Board selectBoard(Integer num) throws Exception;
}
