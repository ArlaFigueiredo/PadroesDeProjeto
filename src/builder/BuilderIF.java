package builder;

import model.Disciplina;
import model.Livro;

public interface BuilderIF {
	public void setNome(String nome);
	public void setCodigo(String codigo);
	public void addLivros(Livro livro);
	public void addDisciplinas(Disciplina disciplina);
}
