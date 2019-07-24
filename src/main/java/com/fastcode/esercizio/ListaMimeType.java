package com.fastcode.esercizio;

import java.util.ArrayList;
import java.util.List;

import com.fastcode.esercizio.entità.MimeType;

public class ListaMimeType {
	
	List<MimeType> lista;
	
	

	public ListaMimeType(ArrayList<MimeType> lista) {
		super();
		this.lista = lista;
	}

	public ListaMimeType() {

	}

	public List<MimeType> getLista() {
		return lista;
	}

	public void setLista(List<MimeType> listaDaDb) {
		this.lista = listaDaDb;
	}
	
	
	
	

}
