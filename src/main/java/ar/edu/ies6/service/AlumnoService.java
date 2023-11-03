package ar.edu.ies6.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import ar.edu.ies6.model.Alumno;

@Service
public class AlumnoService {
	
		public void guardarAlumno(Alumno alumno) {	
		}

		public void eliminarAlumno(Integer dni) {	
		}
		
		public List<Alumno>buscarTodosAlumnos() {
			List<Alumno> listado = new ArrayList<>();
			return listado;
		}
		
		public void modificarAlumno (Alumno alumno) {
		}
}
