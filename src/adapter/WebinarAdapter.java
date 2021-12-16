package adapter;

import composite.ComponenteIF;
import model.Disciplina;

public class WebinarAdapter extends Disciplina implements ComponenteIF{
	
	private Webinar webinar;
	
	public WebinarAdapter(String codigo, String nome) {
		super(codigo, nome);
	}
	
	public WebinarAdapter(WebinarAdapter webinarAdapter) {
		super(webinarAdapter);
	}
	
	public WebinarAdapter(String id, String title, String hoster, double price, long minutes) {
		super(id, title);
		this.webinar = new Webinar(id, title, hoster, price, minutes);
	}
	
	@Override
	public String getCodigo() {
		return this.webinar.getId();
	}
	
	@Override
	public String getNome() {
		return this.webinar.getTitle();
	}
	
	@Override
	public double getPreco() {
		return this.webinar.getPrice();
	}
	
	@Override
	public int getCargaHoraria() {
		return (int)(this.webinar.getMinutes()/60);
	}
	
	@Override
	public double getPercentualCumprido() {
		if(this.webinar.wasWatched())
			return 1.0;
		else
			return 0.0;
	} 

}
