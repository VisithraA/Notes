package com.visithraa23.notes.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.visithraa23.notes.dto.Note;

public class NoteRepository {

	public static NoteRepository repository;
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;

	private NoteRepository() {
		entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	public static NoteRepository getInstance() {
		if (repository == null) {
			repository = new NoteRepository();
		}
		return repository;
	}

	public List<Note> getNotes() {
		Query query = entityManager.createQuery("Select note.* from Note note");
		List<Note> notes = query.getResultList();
		return notes;
	}

	public void addNote(String title,String content) {
		Note note =new Note(title, content);
		entityTransaction.begin();
		entityManager.persist(note);
		entityTransaction.commit();
	}

	public void updateNote(Note note) {
		// TODO Auto-generated method stub

	}

	public void deleteNote(int id) {
		// TODO Auto-generated method stub

	}

}
