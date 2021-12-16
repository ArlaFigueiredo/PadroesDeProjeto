import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
		
		CursoBuilder builderCurso = new CursoBuilder();
		// Historico de Checkpoints
		Stack<Situacao> snapshots = new Stack<Situacao>();
		
		Disciplina disciplina1 =(Disciplina) ProdutoFactory.getProduto(TipoProduto.DISCIPLINA,"1","Padr�es Criacionais");
		disciplina1.setCargaHoraria(10);
		Disciplina disciplina2 =(Disciplina) ProdutoFactory.getProduto(TipoProduto.DISCIPLINA,"2","Padr�es Comportamentais");
		disciplina2.setCargaHoraria(20);
		Disciplina disciplina3 =(Disciplina) ProdutoFactory.getProduto(TipoProduto.DISCIPLINA,"3","Padr�es Estruturais");
		disciplina3.setCargaHoraria(30);
		
		builderCurso.setCodigo("10");
		builderCurso.setNome("Padr�es de Projeto");
		builderCurso.addDisciplinas(disciplina1);
		builderCurso.addDisciplinas(disciplina2);
		builderCurso.addDisciplinas(disciplina3);
		Curso curso = builderCurso.build();
		
		curso.addNotificacao(TipoNotificacao.EMAIL);
		curso.addNotificacao(TipoNotificacao.SMS);
		curso.addNotificacao(TipoNotificacao.WHATSAPP);
		
		System.out.println(curso.getNotificacoesAtivas());
		
		curso.removeNotificacao(TipoNotificacao.WHATSAPP);
		System.out.println(curso.getNotificacoesAtivas());
		
		
		curso.avancar("Padr�es Criacionais", 0.20);
		curso.avancar("Padr�es Comportamentais", 0.50);
		curso.avancar("Padr�es Estruturais", 0.80);
		
		snapshots.push(curso.getCheckpoint());
		
		System.out.println(curso.getPercentualCumpridoDisciplinas());
		System.out.println("Percentual Cumprido Curso");
		System.out.println(curso.getChCumprida());
		
		curso.avancar("Padr�es Criacionais", 0.80);
		curso.avancar("Padr�es Comportamentais", 0.50);
		curso.avancar("Padr�es Estruturais", 0.20);
		
		System.out.println(curso.getPercentualCumpridoDisciplinas());
		System.out.println("Percentual Cumprido Curso");
		System.out.println(curso.getChCumprida());
		System.out.println(curso.getStatus());
		
		//curso.restore(snapshots.pop());
		//curso.cancelar();
		
		System.out.println(curso.getPercentualCumpridoDisciplinas());
		System.out.println("Percentual Cumprido Curso");
		System.out.println(curso.getChCumprida());
		System.out.println(curso.getStatus());
	}
	
}
