import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import adapter.WebinarAdapter;
import bridge.Basico;
import bridge.CapaDura;
import bridge.Colorido;
import bridge.Digital;
import bridge.VersaoIF;
import builder.CursoBuilder;
import composite.ComponenteIF;
import composite.CursoComposto;
import factory.ProdutoFactory;
import factory.TipoProduto;
import factory.TipoNotificacao;
import memento.Situacao;
import model.Curso;
import model.Disciplina;
import model.Livro;


public class Aplicacao {
	
	public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Aplicacao.teste();
	}
	
	public static void teste() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		
		/*CursoBuilder builderCurso = new CursoBuilder();
		
		Disciplina disciplina1 =(Disciplina) ProdutoFactory.getProduto(TipoProduto.DISCIPLINA,"1","Padrões Criacionais Java");
		disciplina1.setCargaHoraria(10);
		disciplina1.setPreco(30);
		Disciplina disciplina2 =(Disciplina) ProdutoFactory.getProduto(TipoProduto.DISCIPLINA,"2","Padrões Comportamentais Java");
		disciplina2.setCargaHoraria(20);
		disciplina2.setPreco(40);
		Disciplina disciplina3 =(Disciplina) ProdutoFactory.getProduto(TipoProduto.DISCIPLINA,"3","Padrões Estruturais Java");
		disciplina3.setCargaHoraria(30);
		disciplina3.setPreco(50);
		
		builderCurso.setCodigo("10");
		builderCurso.setNome("Padrões de Projeto Java");
		builderCurso.addDisciplinas(disciplina1);
		builderCurso.addDisciplinas(disciplina2);
		builderCurso.addDisciplinas(disciplina3);
		Curso curso = builderCurso.build();
		
		
		CursoBuilder builderCurso2 = new CursoBuilder();
		
		Disciplina disciplina4 =(Disciplina) ProdutoFactory.getProduto(TipoProduto.DISCIPLINA,"4","Padrões Criacionais Python");
		disciplina4.setCargaHoraria(40);
		disciplina4.setPreco(100);
		Disciplina disciplina5 =(Disciplina) ProdutoFactory.getProduto(TipoProduto.DISCIPLINA,"5","Padrões Comportamentais Python");
		disciplina5.setCargaHoraria(50);
		disciplina5.setPreco(150);
		Disciplina disciplina6 =(Disciplina) ProdutoFactory.getProduto(TipoProduto.DISCIPLINA,"6","Padrões Estruturais Python");
		disciplina6.setCargaHoraria(60);
		disciplina6.setPreco(200);
		
		builderCurso2.setCodigo("20");
		builderCurso2.setNome("Padrões de Projeto Python");
		builderCurso2.addDisciplinas(disciplina4);
		builderCurso2.addDisciplinas(disciplina5);
		builderCurso2.addDisciplinas(disciplina6);
		Curso curso2 = builderCurso2.build();
		
		Disciplina disciplina7 =(Disciplina) ProdutoFactory.getProduto(TipoProduto.DISCIPLINA,"7","Principios SOLID");
		disciplina7.setCargaHoraria(60);
		disciplina7.setPreco(10);
		
		CursoComposto cursoComposto = new CursoComposto("30", "Padrões de Projeto");
		cursoComposto.addComponente(curso);
		cursoComposto.addComponente(curso2);
		cursoComposto.addComponente(disciplina7);
		System.out.println(cursoComposto.getPreco());
		System.out.println(cursoComposto.getComponentes());
		*/
		
		
		// SEGUNDA QUESTAO 
		/*
		VersaoIF versao = new Colorido();
		Livro livro =(Livro) ProdutoFactory.getProduto(TipoProduto.LIVRO,"3","Padrões Estruturais");
		livro.setVersao(versao);
		livro.setPreco(30.00);
		System.out.println(livro.getPreco());
		*/
		
		// TERCEIRA QUESTAO 
		
		/*
		CursoBuilder builderCurso = new CursoBuilder();
		
		Disciplina disciplina1 =(Disciplina) ProdutoFactory.getProduto(TipoProduto.DISCIPLINA,"1","Padrões Criacionais Java");
		disciplina1.setCargaHoraria(10);
		disciplina1.setPreco(30);
		Disciplina disciplina2 =(Disciplina) ProdutoFactory.getProduto(TipoProduto.DISCIPLINA,"2","Padrões Comportamentais Java");
		disciplina2.setCargaHoraria(20);
		disciplina2.setPreco(40);
		Disciplina disciplina3 =(Disciplina) ProdutoFactory.getProduto(TipoProduto.DISCIPLINA,"3","Padrões Estruturais Java");
		disciplina3.setCargaHoraria(30);
		disciplina3.setPreco(50);
		Disciplina webinarAdapt = (Disciplina) new WebinarAdapter("0085", "BUILDER NA PRÁTICA", "MANOEL NETO", 60.0, 30);
		
		builderCurso.setCodigo("10");
		builderCurso.setNome("Padrões de Projeto Java");
		builderCurso.addDisciplinas(disciplina1);
		builderCurso.addDisciplinas(disciplina2);
		builderCurso.addDisciplinas(disciplina3);
		builderCurso.addDisciplinas(webinarAdapt);
		Curso curso = builderCurso.build();
		System.out.println(curso.getPercentualCumpridoDisciplinas());
		*/
	}
	
}
