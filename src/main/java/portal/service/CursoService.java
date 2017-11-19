package portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import portal.model.Curso;
import portal.repository.CursoRepository;

@Service
public class CursoService {
	 @Autowired
	  CursoRepository repository;

	  public List<Curso> getAll() {
	    return repository.findAll();
	  }
	  
	  public Curso getCursoCodigo(String codigo) {
		    return repository.findOne(codigo);
	  }
	  
	  /*public List<Curso> getCursoMatch(String name) {
		    return repository.findCursoMatch(name);
	  }*/
}
