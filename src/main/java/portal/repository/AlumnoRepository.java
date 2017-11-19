package portal.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import portal.model.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno, String>{
  List<Alumno> findAll();
}
