package src;
public class Espada extends Arma{
    private int dano;
    private int durabilidade;
    
    public int cortar(){
        return dano;
    }

    public int golpear(){
        durabilidade -= 10;
        if(durabilidade <= 0){

            return cortar();
        }
        return 5;
    }

    public Espada(int dano, int durabilidade){
        this.dano = dano;
        this.durabilidade = durabilidade;
    }

}