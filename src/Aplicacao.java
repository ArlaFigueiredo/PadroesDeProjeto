import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import builder.CursoBuilder;
import factory.ProdutoFactory;
import factory.TipoProduto;
import factory.TipoNotificacao;
import memento.Situacao;
import model.Curso;
import model.Disciplina;


public class Aplicacao {
	
	public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Aplicacao.teste();
	}
	
	public static void teste() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Aplicacao app = new Aplicacao();
		CursoBuilder builderCurso = new CursoBuilder();
		List<Situacao> snapshots = new ArrayList<Situacao>();
		
		Disciplina disciplina1 =(Disciplina) ProdutoFactory.getProduto(TipoProduto.DISCIPLINA,"1","Padrões Criacionais");
		disciplina1.setCargaHoraria(10);
		Disciplina disciplina2 =(Disciplina) ProdutoFactory.getProduto(TipoProduto.DISCIPLINA,"2","Padrões Comportamentais");
		disciplina2.setCargaHoraria(20);
		Disciplina disciplina3 =(Disciplina) ProdutoFactory.getProduto(TipoProduto.DISCIPLINA,"3","Padrões Estruturais");
		disciplina3.setCargaHoraria(30);
		
		builderCurso.setCodigo("10");
		builderCurso.setNome("Padrões de Projeto");
		builderCurso.addDisciplinas(disciplina1);
		builderCurso.addDisciplinas(disciplina2);
		builderCurso.addDisciplinas(disciplina3);
		
		Curso curso = builderCurso.build();
		curso.addNotificacao(TipoNotificacao.EMAIL);
		curso.addNotificacao(TipoNotificacao.SMS);
		curso.addNotificacao(TipoNotificacao.LOGGER);
		
		curso.avancar("Padrões Criacionais", 0.20);
		curso.avancar("Padrões Comportamentais", 0.50);
		curso.avancar("Padrões Estruturais", 0.80);
		
		snapshots.add(curso.getCheckpoint());
		
		System.out.println(curso.getPercentualCumpridoDisciplinas());
		System.out.println(curso.getChCumprida());
		
		curso.avancar("Padrões Criacionais", 0.50);
		curso.avancar("Padrões Comportamentais", 0.40);
		curso.avancar("Padrões Estruturais", 0.20);
		
		System.out.println(curso.getPercentualCumpridoDisciplinas());
		System.out.println(curso.getChCumprida());
		System.out.println(curso.getStatus());
		
		//curso.restore(snapshots.get(0));
		curso.cancelar();
		
		System.out.println(curso.getPercentualCumpridoDisciplinas());
		System.out.println(curso.getChCumprida());
		System.out.println(curso.getStatus());
	}
	
}
