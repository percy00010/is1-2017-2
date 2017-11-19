package portal.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portal.model.Alumno;
import portal.repository.AlumnoRepository;

@Service
public class AlumnoService {

  @Autowired
  AlumnoRepository repository;

  public List<Alumno> getAll() {
    return repository.findAll();
  }

  public Alumno getByCodigo(String codigo) {
    return repository.findOne(codigo);
  }
  
  public Alumno getAlumnoName(String name){
	  return repository.findAlumnoName(name);
  }

  public Alumno save(Alumno alumnoChanged) {
    System.out.println("Modificando: " + alumnoChanged.getCodigo());
    Alumno alumno = repository.findOne(alumnoChanged.getCodigo());
    if (alumno != null) {
      alumno.setApellidoPaterno(alumnoChanged.getApellidoPaterno());
      alumno.setApellidoMaterno(alumnoChanged.getApellidoMaterno());
      alumno.setNombres(alumnoChanged.getNombres());
    } else {
      alumno = alumnoChanged;
    }
    return repository.save(alumno);
  }
}

