package src;
public class Boxeador extends Lutador implements ArtesMarciais{

    public Boxeador(String identificacao){
        super(identificacao);
        energia = 150;
    }
	
	public Boxeador(String identificacao, int energia){
		super(identificacao, energia);
	}


    public int jab(){
		return 20;
	}
    public int direto(){
		return 25;
	}
    public int cruzado(){
		return 30;
	}
    public int gancho(){
		return 35;
	}
	public int combo(){
		return 110;
	}



	public String textToCSV() {
		String retorno = "Boxeadr;" + this.identificacao +";" + String.format("%.2f", this.energia) + "\r\n";
		return retorno;
	};

	@Override
	public void atacar(Combatente adversario){
		float auxAtaque = (float) Math.random();
		if(0.0 <= auxAtaque && auxAtaque < 0.2){
			
			adversario.defender(jab());
		}
		else if(0.2 <= auxAtaque && auxAtaque < 0.4){
			

			adversario.defender(direto());
		}
		else if(0.4 <= auxAtaque && auxAtaque < 0.6){
			

			adversario.defender(cruzado());
		}
		else if(0.6 <= auxAtaque && auxAtaque< 0.8){
			
			adversario.defender(gancho());

		}
		else{
			

			adversario.defender(combo());
		}
	}
}
