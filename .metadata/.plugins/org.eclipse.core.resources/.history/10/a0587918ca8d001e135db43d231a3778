package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.BoardDTO;

@Mapper
public interface BoardMapper {
	// int를 boolean으로 해도 됨
		public int insertBoard(BoardDTO params);
		public BoardDTO selectBoardDetail(Long idx);
		public int updateBoard(BoardDTO params);
		public int deleteBoard(Long idx);
		public List<BoardDTO> selectBoardList();
		public int selectBoardTotalCount();
}
