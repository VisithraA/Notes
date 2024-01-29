package com.visithraa23.notes.viewmodel;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visithraa23.notes.dto.Note;
import com.visithraa23.notes.repository.NoteRepository;

@WebServlet("/notes")
public class NoteViewModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Note> noteList=NoteRepository.getInstance().getNotes();
		request.setAttribute("noteList", noteList);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("notes.jsp");
		requestDispatcher.forward(request, response);
	}

}
