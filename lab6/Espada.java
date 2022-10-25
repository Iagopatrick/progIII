public class Espada implements Arma{
    private int dano;
    private int durabilidade;
    
    public int cortar(){
        return dano;
    }

    public int golpear(){
        return cortar();
    }

    public Espada(int dano, int durabilidade){
        this.dano = dano;
        this.durabilidade = durabilidade;
    }

}