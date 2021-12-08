package factory;

public enum TipoProduto {
	
	LIVRO("factory.LivroFactory"), 
	DISCIPLINA("factory.DisciplinaFactory"),
	CURSO("factory.CursoFactory");
	
	String className;
	
	private TipoProduto(String className) {
		this.className = className;
	}
	
	public String getFactoryName() {
		return this.className;
	}

}
