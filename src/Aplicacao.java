import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import builder.CursoBuilder;
import factory.ProdutoFactory;
import factory.TipoProduto;
import model.Curso;
import model.Disciplina;
import model.Ementa;
import model.ProdutoIF;
import observer.CheckpointNotifyEmail;
import observer.CheckpointNotifyLogger;
import observer.CheckpointNotifySMS;
import singleton.CatalogoCursos;

public class Aplicacao {
	
	public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Aplicacao.teste();
	}
	
	public static void teste() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Aplicacao app = new Aplicacao();
		CursoBuilder builderCurso = new CursoBuilder();
		List<Curso.Situacao> snapshots = new ArrayList<Curso.Situacao>();
		
		Disciplina disciplina =(Disciplina) ProdutoFactory.getProduto(TipoProduto.DISCIPLINA,"123","Padrões Criacionais");
		disciplina.setCargaHoraria(10);
		Disciplina disciplina2 =(Disciplina) ProdutoFactory.getProduto(TipoProduto.DISCIPLINA,"321","Padrões Comportamentais");
		disciplina2.setCargaHoraria(10);
		Disciplina disciplina3 =(Disciplina) ProdutoFactory.getProduto(TipoProduto.DISCIPLINA,"213","Padrões Estruturais");
		disciplina3.setCargaHoraria(10);
		
		builderCurso.setCodigo("123");
		builderCurso.setNome("Padrões de Projeto");
		builderCurso.addDisciplinas(disciplina);
		builderCurso.addDisciplinas(disciplina2);
		builderCurso.addDisciplinas(disciplina3);
		
		Curso curso = builderCurso.build();
		curso.addObserver(new CheckpointNotifyLogger());
		curso.addObserver(new CheckpointNotifySMS());
		curso.addObserver(new CheckpointNotifyEmail());
		
		curso.avancar("Padrões Criacionais", 0.20);
		curso.avancar("Padrões Comportamentais", 0.50);
		curso.avancar("Padrões Estruturais", 0.80);
		
		snapshots.add(curso.getCheckpoint());
		
		curso.avancar("Padrões Criacionais", 0.30);
		curso.avancar("Padrões Comportamentais", 0.30);
		curso.avancar("Padrões Estruturais", 0.30);
		
		/*System.out.println(snapshots.get(0));
		Ementa ementa = curso.buildEmenta();
		System.out.println("Ementa: \n");
		ementa.print();
		
		curso.restore(snapshots.get(0));
		
		Ementa ementa2 = curso.buildEmenta();
		System.out.println("Ementa: \n");
		ementa2.print();
		
		
		Curso curso = builderCurso.build();
		Ementa ementa = curso.buildEmenta();
		
		System.out.println(curso.getDetalhes()+"\n");
		System.out.println("Ementa: \n");
		ementa.print();*/
	}
	
}
