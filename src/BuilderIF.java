import java.util.List;

public interface BuilderIF {
	public void setNome(String nome);
	public void setCodigo(String codigo);
	public void setLivros(List<Livro> livros);
	public void setDisciplinas(List<Disciplina> disciplinas);
}
