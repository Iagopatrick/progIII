package src;
public abstract class Combatente {
	protected boolean isAlive;
	protected String identificacao;
	protected int energia;
    
	public abstract void atacar(Combatente adversario);
       	 
	public void defender(int ataque){
    	energia -= ataque;
		if (energia < 0){
			energia = 0;
		}
	}
    
    
    public boolean getIsAlive(){
		if(energia <= 0){
			isAlive = false;
		}
        return isAlive;
    }
	
	public String getIdentificacao(){
		return identificacao;
	}

	public int getEnergia(){
		return energia;
	}

	public Combatente(String identificacao){
		this.identificacao = identificacao;
		energia = 100;
		isAlive = true;
	}

	public Combatente(String identificacao, int energia){
		this.energia = energia;
		this.identificacao = identificacao;
		isAlive = true;
	}
}
