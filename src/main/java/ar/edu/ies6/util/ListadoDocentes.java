package ar.edu.ies6.util;

import java.util.ArrayList;
import java.util.List;

import ar.edu.ies6.model.Docente;

public class ListadoDocentes {
	
	private static List <Docente> listado = new ArrayList<>();
	
	public ListadoDocentes() {
		// TODO Auto-generated constructor stub
	}

	public static List<Docente> getListado() {
		return listado;
	}

	public static void setListado(List<Docente> listado) {
		ListadoDocentes.listado = listado;
	}
}
