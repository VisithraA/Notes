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

	public NoteRepository() {
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
		Query query = entityManager.createQuery("Select note from Note note");
		List<Note> notes = query.getResultList();
		return notes;
	}

	

}
