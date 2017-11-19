package portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import portal.model.Curso;
import portal.service.CursoService;

@Controller
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	  CursoService cursoService;

	  @RequestMapping
	  public String listarCursos(ModelMap model,
	      @RequestParam(value = "message", required = false) String message) {
	    List<Curso> cursos = cursoService.getAll();
	    model.addAttribute("cursos", cursos);
	    model.addAttribute("message", message);
	    return "curso/list";
	  }
	  
	  @RequestMapping("/initsearch")
	  public String iniciar() {
	    return "curso/post";
	  }
	  
	  @RequestMapping(value = "/codigo", method = RequestMethod.POST)
	  public String buscarCurso(@ModelAttribute Curso cursoChanged, ModelMap model) {
	    Curso tcurso = cursoService.getCursoCodigo(cursoChanged.getCodigo());
	    model.addAttribute("curso", tcurso);
	    return "curso/buscar";
	  }
}
