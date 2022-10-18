import java.util.Random;

public class Guerreiro extends Combatente{
	private Arma espada = new Arma("sword", 25);
    
	public Guerreiro(String identificacao){
    	super(identificacao);
	}
    
	public int corte(){
    	return espada.cortar();
	}
    
	public int empurrao(){
    	return 10;
	}
	
	@Override
	public void atacar(Combatente adversario){
		float auxAtaque = (float)Math.random();
		if(auxAtaque < 0.5){
			adversario.defender(empurrao());
		}
		else{
			adversario.defender(corte());
		}

	}
    
}
