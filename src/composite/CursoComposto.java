package composite;

import java.util.ArrayList;
import java.util.List;
import model.Produto;


public class CursoComposto extends Produto implements ComponenteIF{
	
	private List<ComponenteIF> componentes;
	
	public CursoComposto(CursoComposto cursoComposto) {
		super(cursoComposto);
		this.componentes = new ArrayList<ComponenteIF>();
	}
	
	public CursoComposto(String codigo, String nome) {
		super(codigo, nome);
		this.componentes = new ArrayList<ComponenteIF>();
	}
	
	public void addComponente(ComponenteIF comp) {
		this.componentes.add(comp);
	}
	
	public List<ComponenteIF> getComponentes() {
		return this.componentes;
	}
	
	public int getCargaHoraria() {
		int CHTotal = 0;
		for(ComponenteIF comp : this.componentes)
			CHTotal += comp.getCargaHoraria();
		
		return CHTotal;
	}
	
	public double getPercentualCumprido() {
		double pctCumprido = 0;
		int iCount = 0;
		for(ComponenteIF comp : this.componentes) {
            pctCumprido += comp.getPercentualCumprido();
			iCount += 1;
		}
		
		return pctCumprido/iCount;
	}
	
	public double getPreco() {
		double somaPrecos = 0;
		for(ComponenteIF comp : this.componentes)
			somaPrecos += comp.getPreco();

		return somaPrecos * 0.8;
	}
	
	public String toString() {
		String detalhes =  "Nome: "+ this.getNome() 
						+ "/ Codigo: "+ this.getCodigo();
		return detalhes;
	}
}
