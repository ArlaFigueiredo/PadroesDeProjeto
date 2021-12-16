package adapter;

import model.ProdutoIF;

public class WebinarAdapter implements ProdutoIF{
	
	private Webinar webinar;
	
	public WebinarAdapter(String id, String title, String hoster, double price, long minutes) {
		this.webinar = new Webinar(id, title, hoster, price, minutes);
	}
	
	public String getCodigo() {
		return this.webinar.getId();
	}
	
	public String getNome() {
		return this.webinar.getTitle();
	}
	
	public double getPreco() {
		return this.webinar.getPrice();
	}
	
	public long getCargaHoraria() {
		// TODO CONVERTER PARA O TIPO DA DISCIPLINA
		return this.webinar.getMinutes();
	}
	
	public double getPercentualCumprido() {
		if(this.webinar.wasWatched())
			return 1;
		else
			return 0;
	} 

}
