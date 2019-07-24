package com.fastcode.esercizio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.fastcode.esercizio.dao.MimeTypeDao;
import com.fastcode.esercizio.entità.MimeType;

@Path("/")
public class EsercizioFastCodeWebService {

	@POST
	@Path("/ottieniListaMimeTypeConsentiti")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public ListaMimeType ottieniListaMimeTypeConsentiti() {

		MimeTypeDao mimeTypeDao = new MimeTypeDao();
		ListaMimeType lista = new ListaMimeType();
		List<MimeType> listaDaDb = mimeTypeDao.getAll();
		lista.setLista(listaDaDb);

		return lista;
	}

	@POST
	@Path("/controllaMimeType")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public Response controllaMimeType(@FormParam("path") String path) {

		ArrayList<RisultatoMimeType> risultati = new ArrayList<RisultatoMimeType>();

		File directory = new File(path);
//		if (!directory.isDirectory())
//			return Response.status(Response.Status.BAD_REQUEST)
//					.entity(new String("Non è stato passato il nome di una directory.")).build();

		ArrayList<File> listaFile = new ArrayList<File>();
		FunzioniDiUtilità.popolaListaFile(directory, listaFile);

		for (File f : listaFile) {
			RisultatoMimeType risultato = FunzioniDiUtilità.ottieniRisultatoMimeType(f);
			risultati.add(risultato);
		}
		

		return Response.ok(new RisultatiMimeType(risultati), MediaType.APPLICATION_JSON).build();
	}

}