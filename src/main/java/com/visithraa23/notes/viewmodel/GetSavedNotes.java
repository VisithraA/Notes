package com.visithraa23.notes.viewmodel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.visithraa23.notes.dto.Note;
import com.visithraa23.notes.repository.NoteRepository;

@WebServlet("/getNotes")
public class GetSavedNotes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Note> notesList = NoteRepository.getInstance().getNotes();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(notesList);
		System.out.println(json);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}
}
