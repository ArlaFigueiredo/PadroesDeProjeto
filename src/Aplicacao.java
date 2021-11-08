
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
		
		CursoBuilder builder = new CursoBuilder();
		
		Disciplina disciplina =(Disciplina) app.produtoFactory.getProduto("123","Vidas Secas");
		disciplina.setCargaHoraria(10);
		builder.addDisciplina(disciplina);
		Disciplina disciplina2 =(Disciplina) app.produtoFactory.getProduto("321","Espadachim de Carvão");
		disciplina2.setCargaHoraria(10);
		builder.addDisciplina(disciplina2);
		Disciplina disciplina3 =(Disciplina) app.produtoFactory.getProduto("213","A Mente de Fred");
		disciplina3.setCargaHoraria(10);
		builder.addDisciplina(disciplina3);
		
		builder.setNome("Curso de Qualidade");
		builder.setCodigo("1");
		
		Curso curso = builder.build();
		
		catalogo.addCurso(curso.prototipar());
		
		CursoBuilder builder2 = new CursoBuilder();
		Disciplina disciplina4 =(Disciplina) app.produtoFactory.getProduto("123","Vidas Secas");
		disciplina4.setCargaHoraria(5);
		builder2.addDisciplina(disciplina4);
		Disciplina disciplina5 =(Disciplina) app.produtoFactory.getProduto("321","Espadachim de Carvão");
		disciplina5.setCargaHoraria(5);
		builder2.addDisciplina(disciplina5);
		Disciplina disciplina6 =(Disciplina) app.produtoFactory.getProduto("213","A Mente de Fred");
		disciplina6.setCargaHoraria(5);
		builder2.addDisciplina(disciplina6);
		
	
		builder2.setNome("Curso sem Qualidade");
		builder2.setCodigo("2");
		
		Curso curso2 = builder2.build();
		
		catalogo.addCurso(curso2);
		
		Curso cursoEncontrado = (Curso) catalogo.getCurso("Curso sem Qualidade");
		System.out.println(cursoEncontrado.getChTotal());
	}

}
