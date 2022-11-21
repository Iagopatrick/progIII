package src;

public class Besta extends Combatente{

    public Besta(String identificacao, int energia){
        super(identificacao, energia);
    }


    public int mordida(){
        return 40;
    }

    public int cabecada(){
        return 30;
    }

    
    public void atacar(Combatente adversario) {
        if(Math.random() < 0.5){
            adversario.defender(mordida());
        }
        else{
            adversario.defender(cabecada());
        }
    }

}
