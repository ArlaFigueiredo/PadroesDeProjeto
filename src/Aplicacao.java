import java.util.ArrayList;
import java.util.List;

public class Aplicacao {
	
	public static TipoProduto PRODUTO = TipoProduto.DISCIPLINA;
	public static String codigo = "50784";
	public static String nome = "Abstract Factory";
	private ProdutoFactory produtoFactory;
	
	
	public Aplicacao() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		this.produtoFactory = (ProdutoFactory) (Class.forName(Aplicacao.PRODUTO.getFactoryName()).newInstance());
	}
	
	public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		//Aplicacao.testeFactory();
		Aplicacao.testeBuilder();
		//Aplicacao.testePrototypeSingleton();
	}
	
	public static void testeFactory() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Aplicacao app = new Aplicacao();
		ProdutoIF disciplina = app.produtoFactory.getProduto("321","Padrões Criacionais");
		System.out.println(disciplina.getDetalhes());
		
		
		/*Testa a criação de um livro
		Aplicacao app = new Aplicacao();
		ProdutoIF disciplina = app.produtoFactory.getProduto("123","GOF GANG");
		System.out.println(disciplina.getDetalhes());
		*/
	}
	
	public static void testeBuilder() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Aplicacao app = new Aplicacao();
		CursoBuilder builderCurso = new CursoBuilder();
		List<Curso.Situacao> snapshots = new ArrayList<Curso.Situacao>();
		
		Disciplina disciplina =(Disciplina) app.produtoFactory.getProduto("123","Padrões Criacionais");
		disciplina.setCargaHoraria(10);
		Disciplina disciplina2 =(Disciplina) app.produtoFactory.getProduto("321","Padrões Comportamentais");
		disciplina2.setCargaHoraria(10);
		Disciplina disciplina3 =(Disciplina) app.produtoFactory.getProduto("213","Padrões Estruturais");
		disciplina3.setCargaHoraria(10);
		
		builderCurso.setCodigo("123");
		builderCurso.setNome("Padrões de Projeto");
		builderCurso.addDisciplinas(disciplina);
		builderCurso.addDisciplinas(disciplina2);
		builderCurso.addDisciplinas(disciplina3);
		
		Curso curso = builderCurso.build();
		curso.avancar("Padrões Criacionais", 0.20);
		curso.avancar("Padrões Comportamentais", 0.50);
		curso.avancar("Padrões Estruturais", 0.80);
		
		snapshots.add(curso.getCheckpoint());
		
		curso.avancar("Padrões Criacionais", 0.30);
		curso.avancar("Padrões Comportamentais", 0.30);
		curso.avancar("Padrões Estruturais", 0.30);
		
		System.out.println(snapshots.get(0));
		Ementa ementa = curso.buildEmenta();
		System.out.println("Ementa: \n");
		ementa.print();
		
		curso.restore(snapshots.get(0));
		
		Ementa ementa2 = curso.buildEmenta();
		System.out.println("Ementa: \n");
		ementa2.print();
		
		
		/*Curso curso = builderCurso.build();
		Ementa ementa = curso.buildEmenta();
		
		System.out.println(curso.getDetalhes()+"\n");
		System.out.println("Ementa: \n");
		ementa.print();*/
	}
	
	public static void testePrototypeSingleton() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		Aplicacao app = new Aplicacao();
		CursoBuilder builderCurso = new CursoBuilder();
		CatalogoCursos catalogo = CatalogoCursos.getCatalogo();
		
		Disciplina disciplina =(Disciplina) app.produtoFactory.getProduto("123","Padrões Criacionais");
		disciplina.setCargaHoraria(10);
		Disciplina disciplina2 =(Disciplina) app.produtoFactory.getProduto("321","Padrões Comportamentais");
		disciplina2.setCargaHoraria(10);
		Disciplina disciplina3 =(Disciplina) app.produtoFactory.getProduto("213","Padrões Estruturais");
		disciplina3.setCargaHoraria(10);
		
		builderCurso.setCodigo("123");
		builderCurso.setNome("Padrões de Projeto");
		builderCurso.addDisciplinas(disciplina);
		builderCurso.addDisciplinas(disciplina2);
		builderCurso.addDisciplinas(disciplina3);
		
		Curso curso = builderCurso.build();
		catalogo.addCurso(curso.prototipar());
		CatalogoCursos catalogo2 = CatalogoCursos.getCatalogo();
		CursoBuilder builderCurso2 = new CursoBuilder();
		
		Disciplina disciplina4 =(Disciplina) app.produtoFactory.getProduto("123","Padrões Criacionais");
		disciplina4.setCargaHoraria(5);
		Disciplina disciplina5 =(Disciplina) app.produtoFactory.getProduto("321","Padrões Comportamentais");
		disciplina5.setCargaHoraria(5);
		Disciplina disciplina6 =(Disciplina) app.produtoFactory.getProduto("213","Padrões Estruturais");
		disciplina6.setCargaHoraria(5);
		
		builderCurso2.setCodigo("321");
		builderCurso2.setNome("Padrões de Projeto 2");
		builderCurso2.addDisciplinas(disciplina4);
		builderCurso2.addDisciplinas(disciplina5);
		builderCurso2.addDisciplinas(disciplina6);
		
		Curso curso2 = builderCurso2.build();
		
		
		catalogo2.addCurso(curso2.prototipar());
		
		Curso cursoEncontrado =(Curso) catalogo2.getCurso("Padrões de Projeto");
		System.out.println(cursoEncontrado.getChTotal());
		
	}

}
