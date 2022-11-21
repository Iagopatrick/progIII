package src;
import java.util.ArrayList;

public  class Arma{
	ArrayList<Golpe> golpes;
	String nome;

	public Arma(String nome) {	
		this.nome = nome;
		this.golpes = new ArrayList();
	}

	

	public void addGolpe(String nomeGolpe, int poderOfensivo) {
		golpes.add(new Golpe(nomeGolpe,  poderOfensivo));
	}


    
	public Golpe pegarGolpeRandomico() {
		if(golpes.size() > 0) {
			int tipoGolpe = (int) (Math.random() * golpes.size());
			return golpes.get(tipoGolpe);						
		}
		return null;
	}
}
