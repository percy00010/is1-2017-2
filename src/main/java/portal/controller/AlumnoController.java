package portal.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import portal.model.Alumno;
import portal.model.Curso;
import portal.service.AlumnoService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

  @Autowired
  AlumnoService alumnoService;

  @RequestMapping
  public String listarAlumnos(ModelMap model,
      @RequestParam(value = "message", required = false) String message) {
    List<Alumno> alumnos = alumnoService.getAll();
    model.addAttribute("alumnos", alumnos);
    model.addAttribute("message", message);
    return "alumno/list";
  }

  @RequestMapping("/{codigo}")
  public String editarAlumno(ModelMap model, @PathVariable("codigo") String codigo) {
    Alumno alumno = alumnoService.getByCodigo(codigo);
    model.addAttribute("alumno", alumno);
    model.addAttribute("fullName", String.format("%s/%s, %s", alumno.getApellidoPaterno(),
        alumno.getApellidoMaterno(), alumno.getNombres()));
    return "alumno/editar";
  }

  @RequestMapping("/new")
  public String nuevoAlumno(ModelMap model) {
    Alumno alumno = new Alumno();
    model.addAttribute("alumno", alumno);
    model.addAttribute("title", "Nuevo Alumno");
    return "alumno/editar";
  }
  
  @RequestMapping("/initsearch")
  public String iniciar() {
    return "alumno/post";
  }
  
  @RequestMapping("/inits")
  public String iniciarBusqueda() {
    return "alumno/cursem";
  }
  
  @RequestMapping(value = "/infor", method = RequestMethod.POST)
  public String buscarCurso(@ModelAttribute Alumno cursoChanged, ModelMap model){
    Alumno talumno = alumnoService.getAlumnoName(cursoChanged.getNombres());
    model.addAttribute("alumno", talumno);
    return "alumno/alumno";
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String saveAlumno(@ModelAttribute Alumno alumnoChanged, ModelMap model) {
    alumnoService.save(alumnoChanged);
    return "redirect:/alumno?message=El alumno se actualizo correctamente";
    // return listarAlumnos(model);
  }

}
