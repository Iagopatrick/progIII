public class Lutador extends Combatente implements Boxeador{
	public Lutador(String identificacao){
    	super(identificacao);
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
		return 35
	}
	public int combo(){
		return 110;
	}



	@Override
	public void atacar(Combatente adversario){
		float auxAtaque = (float) Math.random();
		if(0.0 <= auxAtaque < 0.2){
			adversario.defender(jab());
		}
		if else(0.2 <= auxAtaque < 0.4){
			adversario.defender(direto());
		}
		if else(0.4 <= auxAtaque < 0.6){
			adversario.defender(cruzado());
		}
		if else(0.6 <= auxAtaque < 0.8){
			adversario.defender(gancho());
		}
		else{
			adversario.defender(combo());
		}
	}
}
