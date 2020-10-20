package com.choa.s1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.choa.s1.board.BoardDTO;
import com.choa.s1.board.BoardService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        boardService = new BoardService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Encoding
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String path = request.getRequestURL().toString();
		
		path = path.substring(path.lastIndexOf("/"));
		System.out.println(path);
		String info = "";
		
		if(path.equals("/boardList.board")) {
			System.out.println("Board List");
			info = "./boardList.jsp";
			
			ArrayList<BoardDTO> ar = null;
			
			try {
				ar = boardService.boardList();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			request.setAttribute("boardList", ar);
			
		} else if (path.equals("/boardWrite.board")) {
			info = "/board/boardWrite.jsp";
		} else if (path.equals("/boardWriteProcess.board")) {

			System.out.println( request.getParameter("title") );
			System.out.println( request.getParameter("writer") );
			System.out.println( request.getParameter("contents") );
			
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setTitle( request.getParameter("title") );
			boardDTO.setWriter( request.getParameter("writer") );
			boardDTO.setContents( request.getParameter("contents") );
			
			try {
				boardService.boardInsert(boardDTO);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			info = "/board/boardList.jsp";
		} else {
			System.out.println("Index");
			info = "./index.jsp";
		}
		//if else 끝
		
		RequestDispatcher view = request.getRequestDispatcher(info);
		view.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
