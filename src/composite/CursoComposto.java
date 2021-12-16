package composite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import factory.TipoNotificacao;
import model.Curso;
import model.Disciplina;
import model.Livro;
import model.ProdutoIF;
import observer.CheckpointObserver;
import prototype.Prototipavel;
import state.AtivoState;

public class CursoComposto extends Curso implements ProdutoIF, Prototipavel{
	
	private List<Curso> cursos;
	
	
	private CursoComposto(CursoComposto curso) {
		super(curso);
		for(Curso c : curso.cursos)
			this.cursos.add((Curso)c.prototipar());
	}
	
	public CursoComposto(String codigo, String nome) {
		super(codigo, nome);
		this.disciplinas = new ArrayList<Disciplina>();
		this.livros = new ArrayList<Livro>();
		this.cursos = new ArrayList<Curso>();
		this.observers = new HashMap<TipoNotificacao,CheckpointObserver>();
		this.state = new AtivoState();
	}
	
	public CursoComposto(String codigo, String nome, List<Livro> livros,List<Disciplina> disciplinas, List<Curso> cursos) {
		super(codigo, nome, livros, disciplinas);
		this.cursos = cursos;
	}
	
	public void addCurso(Curso curso) {
		this.cursos.add(curso);
	}
	
	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = new ArrayList<Curso>(cursos);
	}
	
	@Override
	public int getChTotal() {
		int CHTotal = 0;
		for(Disciplina disciplina : this.disciplinas)
			CHTotal += disciplina.getCargaHoraria();
		for(Curso curso : this.cursos)
			CHTotal += curso.getChTotal();
		
		return CHTotal;
	}
	
	@Override
	public double getChCumprida() {
		double pctCumprido = 0;
		int iCount = 0;
		for(Disciplina disciplina : disciplinas) {
            pctCumprido += disciplina.getPercentualCumprido();
			iCount += 1;
		}
		for(Curso curso : this.cursos)
			pctCumprido += curso.getChCumprida();
			iCount += 1;
		
		return pctCumprido/iCount;
	}
	
	@Override
	public double getPreco() {
		double somaPrecosDisc = 0;
		double somaPrecosLivr = 0;
		double somaPrecosCur = 0;
		for(Curso curso : this.cursos)
			somaPrecosCur += curso.getPreco();
		for(Disciplina disciplina : this.disciplinas)
			somaPrecosDisc += disciplina.getPreco();
		for(Livro livro : this.livros)
			somaPrecosLivr += livro.getPreco();

		return (somaPrecosDisc + somaPrecosCur) * 0.8 + somaPrecosLivr * 0.9;
	}
	
	public Prototipavel prototipar() {
		CursoComposto novoCurso = new CursoComposto(this);
		for(Disciplina disciplina : novoCurso.disciplinas)
            disciplina.reset();
		return novoCurso;
	}

}
