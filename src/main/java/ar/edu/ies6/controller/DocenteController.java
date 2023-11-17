package ar.edu.ies6.controller;

import ar.edu.ies6.model.Docente;
import ar.edu.ies6.service.DocenteService;

import java.lang.Integer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DocenteController {
	
	@Autowired
	Docente doc;
	
	@Autowired
	DocenteService docenteService;
	
	@GetMapping({"/docente"})
	public ModelAndView cargarDocente () {
					
		ModelAndView modelView = new ModelAndView ("docente");
		modelView.addObject("docente", doc);
		return modelView;
	}
	
	@PostMapping("/cargarDocente")
	public ModelAndView cargarDocente (@ModelAttribute("docente")Docente docente) {
		
		docenteService.guardarDocente (docente);
		ModelAndView modelView = new ModelAndView("listadoDocentes");
		modelView.addObject("listado", docenteService.buscarTodosDocentes());
		return modelView;	
	}
	
	@GetMapping({"/eliminarDocente/{dni}"})
	public String eliminarDocente (@PathVariable Integer dni) throws Exception {	
		docenteService.eliminarDocente(dni);
		return "redirect:/mostrarListado";
	}
	
	@GetMapping("/mostrarListadoDocente")
	public ModelAndView mostrarDocentes () {
		ModelAndView listado = new ModelAndView ("listadoDocentes");
		listado.addObject("listado", docenteService.buscarTodosDocentes());
		return listado;
	}
	
	@GetMapping({"/modificarDocente/{dni}"})
	public ModelAndView modificarAlumno (@PathVariable Integer dni) throws Exception {
		ModelAndView modificaAlumno = new ModelAndView ("docente");
			modificaAlumno.addObject("docente", docenteService.encontrarUnDocente(dni));
		return modificaAlumno;
	}
	
	@PostMapping("/modificarDocente")
	public ModelAndView modificarUnAlumno (@ModelAttribute("docente")Docente docente) {
		docenteService.guardarDocente(docente);
		ModelAndView modelView = new ModelAndView ("listadoDocentes");
		modelView.addObject("listado", docenteService.buscarTodosDocentes());
		return modelView;	
	}
}
