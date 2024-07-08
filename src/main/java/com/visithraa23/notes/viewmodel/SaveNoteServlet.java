package com.visithraa23.notes.viewmodel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.visithraa23.notes.dto.Note;
import com.visithraa23.notes.repository.NoteRepository;

@WebServlet("/saveNote")
public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		if (content == null) {
			content = "";
		}

		int wordCount = content.trim().split("\\s+").length;
		String lastEdited = NoteRepository.getInstance().getCurrentDateTime();

		Note note = new Note(title, content, wordCount, lastEdited);
		boolean linesAffected = NoteRepository.getInstance().save(note);

		HttpSession session = request.getSession();

		if (linesAffected) {
			session.setAttribute("saveMessage", "Note saved successfully!");
		} else {
			session.setAttribute("saveMessage", "Something went wrong. Try again Later..");
		}

		response.sendRedirect("notes.jsp");
	}
}
