package com.fastcode.esercizio.entità;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="mimetype")
public class MimeType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	Integer id;
	
	@Column(name="mimeType")
	String mimeType;

	
	
	public MimeType() {
		super();
	}


	public MimeType(Integer id, String mimeType) {
		super();
		this.id = id;
		this.mimeType = mimeType;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getmimeType() {
		return mimeType;
	}

	public void setmimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	
	
	

}
