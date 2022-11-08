package src;
public class Lutador extends Combatente{
	public Lutador(String identificacao){
    	super(identificacao);
	}

	public Lutador(String identificacao, int energia){
		super(identificacao, energia);
	}


    int socar(){
		return 30;
	}
    int chutar(){
		return 30;
	}

	@Override
	public void atacar(Combatente adversario){
		if(Math.random() > 0.5){
			adversario.defender(socar());
		}
		else{
			adversario.defender(chutar());
		}
	}

	
}
