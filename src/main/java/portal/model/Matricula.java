package portal.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Matricula {

  @Id
  private Integer id;

  @OneToMany(mappedBy = "matricula")
  private List<CursoMatricula> cursoMatriculados;
  
  @ManyToOne
  @JoinColumn(name = "alumno_codigo")
  private Alumno alumno;

  private String Semestre;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<CursoMatricula> getCursoMatriculados() {
		return cursoMatriculados;
	}
	
	public void setCursoMatriculados(List<CursoMatricula> cursoMatriculados) {
		this.cursoMatriculados = cursoMatriculados;
	}
	
	public Alumno getAlumno() {
		return alumno;
	}
	
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	public String getSemestre() {
		return Semestre;
	}
	
	public void setSemestre(String semestre) {
		Semestre = semestre;
	}
 
}
