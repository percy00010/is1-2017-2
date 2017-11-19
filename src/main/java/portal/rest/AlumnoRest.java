package portal.rest;

import portal.model.Alumno;
import portal.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumno")
public class AlumnoRest {

    @Autowired
    AlumnoService alumnoService;

    @RequestMapping("/listar.json")
    @ResponseBody
    public List<Alumno> listarAlumnos() {
        List<Alumno> alumnos = alumnoService.getAll();
        return alumnos;
    }

    @RequestMapping("/{codigo}.json")
    @ResponseBody
    public Alumno alumno(@PathVariable("codigo") String codigo) {
        Alumno alumno = alumnoService.getByCodigo(codigo);
        return alumno;
    }
}
