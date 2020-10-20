package com.choa.s1.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.choa.s1.util.DBConnector;

public class BoardDAO {
	private DBConnector dbConnector;
	
	public BoardDAO() {
		dbConnector = new DBConnector();
	}
	
	public int boardInsert(BoardDTO boardDTO) throws Exception {
		Connection con = dbConnector.getConnection();
		
		//4. sql문 작성
		String sql = "insert into board values("+
					"(select max(num) from board)+1, ?, ?, ?, sysdate, ?)";
		
		//5. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//6. ? 값 세팅
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getWriter());
		st.setString(3, boardDTO.getContents());
		st.setLong(4, boardDTO.getHit());
		
		//7. 최종전송 및 결과처리
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	public ArrayList<BoardDTO> boardList() throws Exception {
		ArrayList<BoardDTO> ar = new ArrayList<>();
		Connection con = dbConnector.getConnection();
		
		//4. sql문 작성
		String sql = "select * from board order by num desc";
		
		//5. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//6. ? 세팅 - 있으면
		
		//7. 최종전송 및 결과처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			/*
			System.out.println(rs.getLong("num"));
			System.out.println(rs.getString("title"));
			System.out.println(rs.getDate("regdate"));
			*/
			BoardDTO boardDTO = new BoardDTO();
			
			boardDTO.setNum(rs.getLong("num"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setWriter(rs.getString("writer"));
			boardDTO.setContents(rs.getString("contents"));
			boardDTO.setRegDate(rs.getDate("regdate"));
			boardDTO.setHit(rs.getLong("hit"));
			
			ar.add(boardDTO);
		}
		
		//8. 자원 해제
		rs.close();
		st.close();
		con.close();
		
		//System.out.println("BoardDAO " + ar);
		return ar;
	}
}
