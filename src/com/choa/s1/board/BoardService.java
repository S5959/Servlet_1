package com.choa.s1.board;

import java.sql.Date;
import java.util.ArrayList;

public class BoardService {
	
	private BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	
	public void boardInsert(BoardDTO boardDTO) throws Exception {
		
		System.out.println("------BoardInsert------");
		System.out.println(boardDTO.getTitle());
		System.out.println(boardDTO.getWriter());
		System.out.println(boardDTO.getContents());
		
		boardDTO.setHit(0);
		
		int result = boardDAO.boardInsert(boardDTO);
		
		System.out.println(result + " --- 1 이상이면 성공, 아니면 실패");
	}
	
	public ArrayList<BoardDTO> boardList() throws Exception {
		ArrayList<BoardDTO> ar = boardDAO.boardList();
		
		//System.out.println("BoardService " + ar);
		return ar;
	}
}
