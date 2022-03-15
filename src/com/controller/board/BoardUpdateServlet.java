package com.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BoardDAO;
import com.vo.BoardVO;

@WebServlet("/updatePost")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardUpdateServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String board_id = request.getParameter("board_id");
		BoardVO board = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();

		board.setBoard_id(board_id);
		board.setContent(request.getParameter("content"));
		board.setTitle(request.getParameter("title"));
		board.setCategory(request.getParameterValues("category"));
		boardDAO.updatePost(board);

		RequestDispatcher dispatcher = request.getRequestDispatcher("boardList.jsp");
		dispatcher.forward(request, response);

	}

}
