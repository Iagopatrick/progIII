

public class Guerreiro extends Lutador implements Tanque{
	static int qntdArmas = 0;
	private Arma armas[];
	private int resistencia = 50;

	public Guerreiro(String identificacao){
    	super(identificacao);
		if(Math.random() > 0.5){
			armas[0] = new Espada(25, 25);
		}
		else{
			armas[0]= new Lanca(2, 40);
		}
	}
    
	public int resistencia(int damage){
		resistencia -= (int)damage / 2;
		if(resistencia < 0){
			resistencia = 0;
		}
		return resistencia;
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
			adversario.defender(armas[0].golpear());
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
