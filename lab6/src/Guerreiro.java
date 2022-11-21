package src;

import java.util.ArrayList;

public class Guerreiro extends Lutador{
	
	private ArrayList<Arma> armas;
	private ArrayList<Armadura> armaduras;
	

	public Guerreiro(String identificacao){
    	super(identificacao);
	}


	public Guerreiro(String identificacao, int energia){
		super(identificacao, energia);
	}
    
	public void addArma(Arma arma) {
		armas.add(arma);
	}


    public void addArmadura(Armadura armadura) {
		armaduras.add(armadura);
	}
	

	public void addArma(ArrayList<Arma> armas){
		this.armas.addAll(armas);
	}

	public void addArmadura(ArrayList<Armadura> armaduras){
		this.armaduras.addAll(armaduras);
	}

	public ArrayList<Arma> getArmas(){
		return armas;
	}

	public Arma getArma(String nomeArma) {
		
		for (Arma arma : armas) {
			if(arma.nome.equals(nomeArma)) {
				return arma;
			}
		}
		return null;
		
	}

	public ArrayList<Armadura> getArmaduras() {
		return armaduras;
	}
	


	public Armadura getArmadura(String nomeArmadura) {

		for (Armadura armadura : armaduras) {
			if(armadura.nome.equals(nomeArmadura)) {
				return armadura;
			}
		}
		return null;
		
	}
	
	public int ataqueArma(){
		if(armas.size() > 0){
			int tipoArma = (int) (Math.random() * armas.size());
			Arma arma = armas.get(tipoArma);
			return arma.pegarGolpeRandomico().poderOfensivo;
		}
		return 0;
	}


	
	public String textToCSV() {
		String retorno = "";	
		String header = "Guerreiro;" + this.identificacao +";" + String.format("%.2f", this.energia) + ";";
		
		for (Arma arma : armas) {
			ArrayList<Golpe> golpes = arma.golpes;
			for (Golpe golpe : golpes) {
				retorno+=header + arma.nome + ";" + golpe.nomeDoGolpe + ";" + String.format("%.2f", golpe.poderOfensivo) + "\r\n";
			}
		}
		
		for (Armadura armadura : armaduras) {
			retorno+=header + ";;;" + armadura.nome+ ";" +String.format("%.2f",armadura.poderDeDefesa) + ";" + String.format("%.2f",armadura.poderDeDefesa) + "\r\n";
		}
		
		return retorno;
	};




	@Override
	public void atacar(Combatente adversario){
		float auxAtaque = (float)Math.random();
		if(auxAtaque < 0.3){
			adversario.defender(socar());
		}
		else if (auxAtaque < 0.6){
			adversario.defender(chutar());
		}
		else{
			adversario.defender(ataqueArma());
		}
	}

    
}
