package ar.edu.ies6.controller;

import java.time.LocalDate;
import ar.edu.ies6.model.Alumno;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.ies6.util.ListadoAlumnos;

@Controller
public class AlumnoController {
	
	@GetMapping({"/index", "/", "/home", "/alumno"})
	public ModelAndView cargarAlumno () {
		
		Alumno alu = new Alumno();		
		ModelAndView modelView = new ModelAndView ("index");
		modelView.addObject("alumno", alu);
		return modelView;
	}
	
	@PostMapping("/cargarAlumno")
	public ModelAndView cargarAlumno (@ModelAttribute("alumno")Alumno alumno) {
		
		ListadoAlumnos.getListado().add(alumno);
		ModelAndView modelView = new ModelAndView ("listadoAlumnos");
		modelView.addObject("listado", ListadoAlumnos.getListado());
		return modelView;	
	}
}
