package portal.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import portal.model.Curso;
import portal.model.Tmp;
import portal.service.MatriculaService;

@Controller
@RequestMapping("/matricula")
public class MatriculaController {
	@Autowired
	  MatriculaService matriculaService;
	
	/*@RequestMapping(value = "/semestre", method = RequestMethod.POST)
	  public String buscarSemestre(@ModelAttribute Tmp tmpChanged, ModelMap model){
	    List<Curso> cursos = matriculaService.getCursoSemestre(tmpChanged.getCurso(), tmpChanged.getSemestre());
	    model.addAttribute("curso", cursos);
	    return "curso/buscar";
	  }*/
}
