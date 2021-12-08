package model;

public enum TipoProduto {
	
	LIVRO("LivroFactory"), 
	DISCIPLINA("DisciplinaFactory");
	
	String className;
	
	private TipoProduto(String className) {
		this.className = className;
	}
	
	public String getFactoryName() {
		return this.className;
	}

}
