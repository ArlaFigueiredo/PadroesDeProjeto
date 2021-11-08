
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
		Diretor diretor = new Diretor("1", "Curso de Qualidade");
		
		Disciplina disciplina =(Disciplina) app.produtoFactory.getProduto("123","Vidas Secas");
		disciplina.setCargaHoraria(10);
		
		Disciplina disciplina2 =(Disciplina) app.produtoFactory.getProduto("321","Espadachim de Carvão");
		disciplina2.setCargaHoraria(10);
		
		Disciplina disciplina3 =(Disciplina) app.produtoFactory.getProduto("213","A Mente de Fred");
		disciplina3.setCargaHoraria(10);
		
		
		diretor.addDisciplina(disciplina);
		diretor.addDisciplina(disciplina2);
		diretor.addDisciplina(disciplina3);
		
		diretor.construct(builderCurso);
		
		Curso curso = builderCurso.build();
		
		EmentaBuilder ementaBuilder = new EmentaBuilder();
		
		diretor.construct(ementaBuilder);
		
		Ementa ementa = ementaBuilder.build();
		
		catalogo.addCurso(curso.prototipar());
		
		
		Disciplina disciplina4 =(Disciplina) app.produtoFactory.getProduto("123","Vidas Secas");
		disciplina4.setCargaHoraria(5);
		
		Disciplina disciplina5 =(Disciplina) app.produtoFactory.getProduto("321","Espadachim de Carvão");
		disciplina5.setCargaHoraria(5);
		
		Disciplina disciplina6 =(Disciplina) app.produtoFactory.getProduto("213","A Mente de Fred");
		disciplina6.setCargaHoraria(5);
		
		
		Curso cursoEncontrado = (Curso) catalogo.getCurso("Curso de Qualidade");
		System.out.println(cursoEncontrado.getChTotal());
	}

}
