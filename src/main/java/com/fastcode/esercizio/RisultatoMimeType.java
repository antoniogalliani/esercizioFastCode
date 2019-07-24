package com.fastcode.esercizio;

public class RisultatoMimeType {

	String filename;
	boolean validated;

	public RisultatoMimeType(String filename, boolean validated) {
		super();
		this.filename = filename;
		this.validated = validated;
	}

	public RisultatoMimeType() {
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

}
