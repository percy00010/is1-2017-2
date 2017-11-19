package portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import portal.model.Curso;

public interface CursoRepository extends CrudRepository<Curso, String>{
	  List<Curso> findAll();
	  
	  /*@Query("select c from curso c where c.nombre like %?1%")
	  List<Curso> findCursoMatch(String name);*/
}
