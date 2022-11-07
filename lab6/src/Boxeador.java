package src;
public class Boxeador extends Lutador implements Boxe{

    public Boxeador(String identificacao){
        super(identificacao);
        energia = 150;
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
