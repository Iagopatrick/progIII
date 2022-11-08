package src;
import java.util.ArrayList;

public class Guerreiro extends Lutador implements Tanque{
	static int qntdArmas = 0;
	private Arma armas[];
	private int resistencia = 50;

	// public Guerreiro(String identificacao){
    // 	super(identificacao);
	// 	Arma arma;
		
	// 	if(Math.random() > 0.5){
	// 		arma = new Espada(25, 25);
	// 	}
	// 	else{
	// 		arma= new Lanca(20, 40);
	// 	}
	// 	addArma(arma);
	// }


	public Guerreiro(String identificacao, int energia){
		super(identificacao, energia);
		Arma arma;
		
		if(Math.random() > 0.5){
			arma = new Espada(25, 25);
		}
		else{
			arma= new Lanca(20, 40);
		}
		addArma(arma);

	}
    
	public int armor(int damage){
		resistencia -= damage/3;
		// System.out.println(resistencia);
		
		if(resistencia < 0){
			resistencia = 0;
		}
		return resistencia;
	}
	


    
	public int empurrao(){
    	return 10;
	}

	public void addArma(Arma arma){
		ArrayList<Arma> armas = new ArrayList<Arma>();
		armas.add(arma);
		this.armas = new Arma[armas.size()];
		armas.toArray(this.armas);

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
		energia -= ataque - armor(ataque);
		if (energia < 0){
			energia = 0;
		}
	}
    
}
