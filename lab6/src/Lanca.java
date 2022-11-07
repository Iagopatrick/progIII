package src;
public class Lanca extends Arma{
    private int dano;
    private int durabilidade = 100;



    public int perfurar(){
        if(durabilidade > 0){
            durabilidade -= 10;
            return dano;
            
        }
        return 0;
    }
    public int arremessar(){
        durabilidade = 0;
        return dano*10;
    }

    public int golpear(){
        if(Math.random()>= 0.3){
            return perfurar();
        }
        else{
            return arremessar();
        }

    }

    public Lanca(int dano, int durabilidade){
        this.dano = dano;
        this.durabilidade = durabilidade;
    }

}