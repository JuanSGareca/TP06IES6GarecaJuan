package ar.edu.ies6.controller;

import ar.edu.ies6.model.Alumno;
import ar.edu.ies6.service.AlumnoService;
import java.lang.Integer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AlumnoController {
	
	@Autowired
	Alumno alu;
	
	@Autowired
	AlumnoService alumnoService;
	
	@GetMapping({"/index", "/", "/home", "/alumno"})
	public ModelAndView cargarAlumno () {
					
		ModelAndView modelView = new ModelAndView ("index");
		modelView.addObject("alumno", alu);
		return modelView;
	}
	
	@PostMapping("/cargarAlumno")
	public ModelAndView cargarAlumno (@ModelAttribute("alumno")Alumno alumno) {
		
		alumnoService.guardarAlumno(alumno);
		ModelAndView modelView = new ModelAndView ("listadoAlumnos");
		modelView.addObject("listado", alumnoService.buscarTodosAlumnos());
		return modelView;	
	}
	
	@GetMapping({"/eliminarAlumno/{dni}"})
	public String eliminarAlumno (@PathVariable Integer dni) throws Exception {	
		alumnoService.eliminarAlumno(dni);
		return "redirect:/mostrarListado";
	}
	
	@GetMapping("/mostrarListado")
	public ModelAndView mostrarAlumnos () {
		ModelAndView listado = new ModelAndView ("listadoAlumnos");
		listado.addObject("listado", alumnoService.buscarTodosAlumnos());
		return listado;
	}
	
	@GetMapping({"/modificarAlumno/{dni}"})
	public ModelAndView modificarAlumno (@PathVariable Integer dni) throws Exception {
		ModelAndView modificaAlumno = new ModelAndView ("index");
			modificaAlumno.addObject("alumno", alumnoService.encontrarUnAlumno(dni));
		return modificaAlumno;
	}
	
	@PostMapping("/modificarAlumno")
	public ModelAndView modificarUnAlumno (@ModelAttribute("alumno")Alumno alumno) {
		alumnoService.guardarAlumno(alumno);
		ModelAndView modelView = new ModelAndView ("listadoAlumnos");
		modelView.addObject("listado", alumnoService.buscarTodosAlumnos());
		return modelView;	
	}
}
