package portal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import portal.model.Curso;

public interface CursoRepository extends CrudRepository<Curso, String>{
	  List<Curso> findAll();
	}
