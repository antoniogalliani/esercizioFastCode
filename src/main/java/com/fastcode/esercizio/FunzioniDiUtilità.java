package com.fastcode.esercizio;

import java.io.File;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.fastcode.esercizio.dao.MimeTypeDao;
import com.fastcode.esercizio.entità.MimeType;

public class FunzioniDiUtilità {

	
	/*
	 * restituisce un'entità risultatoMimeType dato un File  
	 */
	public static RisultatoMimeType ottieniRisultatoMimeType(File file) {

		RisultatoMimeType risultatoMimeType = new RisultatoMimeType();
		risultatoMimeType.setFilename(file.getAbsolutePath());

		// cerco il mimeTypeDelFile
		String mimeType = ritornaMimeTypeDelFile(file);

		// valido il mimeTypeADb
		boolean validazione = validoMimeTypeADb(mimeType);
		risultatoMimeType.setValidated(validazione);

		return risultatoMimeType;
	}
	
	
	/*
	 * popola un'arrayList di File data una directory iniziale
	 */
	public static void popolaListaFile(File directory, ArrayList<File> listaFile) {

		if (directory.isFile()) {
			listaFile.add(directory);
		} else if (directory.isDirectory()) {
			for (File file : directory.listFiles()) {
				popolaListaFile(file, listaFile);
			}

		}

	}

	
	
	
	/*
	 *  ritorna il mimeType del File passato come parametro
	 */
	private static String ritornaMimeTypeDelFile(File file) {

		FileNameMap fileNameMap = URLConnection.getFileNameMap();
		String mimeType = fileNameMap.getContentTypeFor(file.getName());
		System.out.println("Il mime type rilevato è: " + mimeType);

		return mimeType;
	}

	
	
	
	/*
	 * Ricerca a db la stringa che rappresenta il mimeType
	 */
	private static boolean validoMimeTypeADb(String mimeType) {

		boolean risultato = false;

		// cerco il mimeType ottenuto nel db
		MimeTypeDao mimeTypeDao = new MimeTypeDao();
		Long occorrenze = mimeTypeDao.countOccurrencesInMimeType(mimeType);

		// se ho occorrenze valido
		if (occorrenze > 0)
			risultato = true;

		return risultato;
	}


}
