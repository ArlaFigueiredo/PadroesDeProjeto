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
import observer.CheckpointChangedEmail;
import observer.CheckpointChangedLogger;
import observer.CheckpointChangedSMS;
import singleton.CatalogoCursos;

public class Aplicacao {
	
	public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Aplicacao.teste();
	}
	
	public static void teste() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Aplicacao app = new Aplicacao();
		CursoBuilder builderCurso = new CursoBuilder();
		List<Curso.Situacao> snapshots = new ArrayList<Curso.Situacao>();
		
		Disciplina disciplina =(Disciplina) ProdutoFactory.getProduto(TipoProduto.DISCIPLINA,"123","Padr�es Criacionais");
		disciplina.setCargaHoraria(10);
		Disciplina disciplina2 =(Disciplina) ProdutoFactory.getProduto(TipoProduto.DISCIPLINA,"321","Padr�es Comportamentais");
		disciplina2.setCargaHoraria(10);
		Disciplina disciplina3 =(Disciplina) ProdutoFactory.getProduto(TipoProduto.DISCIPLINA,"213","Padr�es Estruturais");
		disciplina3.setCargaHoraria(10);
		
		builderCurso.setCodigo("123");
		builderCurso.setNome("Padr�es de Projeto");
		builderCurso.addDisciplinas(disciplina);
		builderCurso.addDisciplinas(disciplina2);
		builderCurso.addDisciplinas(disciplina3);
		
		Curso curso = builderCurso.build();
		curso.attachStateChangedObserver(new CheckpointChangedLogger());
		curso.attachStateChangedObserver(new CheckpointChangedSMS());
		curso.attachStateChangedObserver(new CheckpointChangedEmail());
		
		curso.avancar("Padr�es Criacionais", 0.20);
		curso.avancar("Padr�es Comportamentais", 0.50);
		curso.avancar("Padr�es Estruturais", 0.80);
		
		snapshots.add(curso.getCheckpoint());
		
		curso.avancar("Padr�es Criacionais", 0.30);
		curso.avancar("Padr�es Comportamentais", 0.30);
		curso.avancar("Padr�es Estruturais", 0.30);
		
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
