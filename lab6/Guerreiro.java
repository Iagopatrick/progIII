import java.util.Random;

public class Guerreiro extends Combatente implements Tanque{
	private Arma espada = new Arma("sword", 25);
	resistencia = 50;

	public Guerreiro(String identificacao){
    	super(identificacao);
	}
    
	public int resistencia(int damage){
		resistencia -= damage;
		if(resistencia < 0){
			resistencia = 0
		}
		return resistencia;
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

	@Override
	public void defender(int ataque){
		energia -= ataque - resistencia(ataque);
		if (energia < 0){
			energia = 0;
		}
	}
    
}
