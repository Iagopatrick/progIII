public class Arma{
	private String nome;
	private int dano;
    
	public Arma(String nome, int dano){
    	this.dano = dano;
    	this.nome = nome;
	}
    
	public int cortar(){
    	return dano;
	}
    
	public String getNome(){
		return nome;
	}
    
}
