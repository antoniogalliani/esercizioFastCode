package com.fastcode.esercizio.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fastcode.esercizio.SessionManager;
import com.fastcode.esercizio.entità.MimeType;

public class MimeTypeDao implements Dao<MimeType> {



	public Integer save(MimeType t) {

		Session session = SessionManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created " + t.toString());
		return t.getId();
	}

	public Optional<MimeType> get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MimeType> getAll() {

		Session session = SessionManager.getSessionFactory().openSession();
		session.beginTransaction();
		List<MimeType> resultList = session.createQuery("from MimeType").list();
		session.close();
		
		return resultList;
		
	}

	public void update(MimeType t) {
		// TODO Auto-generated method stub

	}

	public void delete(MimeType t) {
		// TODO Auto-generated method stub

	}

	public void deleteAll() {
		// TODO Auto-generated method stub

	}
	
	
	public Long countOccurrencesInMimeType(String mimeType) {
		
		Session session = SessionManager.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("select count(*) from MimeType m where m.mimeType=:mimeT");
		query.setParameter("mimeT", mimeType);
		Long risultato = (Long)query.uniqueResult();
		session.close();
		
		return risultato;
		
	}

	     

}
