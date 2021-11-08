
public class Aplicacao {
	
	public static TipoProduto PRODUTO = TipoProduto.DISCIPLINA;
	public static String codigo = "50784";
	public static String nome = "Abstract Factory";
	private ProdutoFactory produtoFactory;
	
	
	public Aplicacao() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		this.produtoFactory = (ProdutoFactory) (Class.forName(Aplicacao.PRODUTO.getFactoryName()).newInstance());
	}
	
	public void comprar() throws InterruptedException {
		
	}
	
	public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		Aplicacao app = new Aplicacao();
		CatalogoCursos catalogo = CatalogoCursos.getGerente();
		
		CursoBuilder builderCurso = new CursoBuilder();
		
		Disciplina disciplina =(Disciplina) app.produtoFactory.getProduto("123","Vidas Secas");
		disciplina.setCargaHoraria(10);
		Disciplina disciplina2 =(Disciplina) app.produtoFactory.getProduto("321","Espadachim de Carvão");
		disciplina2.setCargaHoraria(10);
		Disciplina disciplina3 =(Disciplina) app.produtoFactory.getProduto("213","A Mente de Freud");
		disciplina3.setCargaHoraria(10);
		
		
		builderCurso.addDisciplinas(disciplina);
		builderCurso.addDisciplinas(disciplina2);
		builderCurso.addDisciplinas(disciplina3);
		builderCurso.setCodigo("123");
		builderCurso.setNome("UAU");
		
		Curso curso = builderCurso.build();
		Ementa ementa = curso.getEmenta();
		
		System.out.println(curso.getChTotal());
		ementa.print();
	}

}
