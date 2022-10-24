public class AppArena {
    static int qntdLutadores = 0;
    static int qntdGuerreiros = 0;

    static Combatente combatentes[];
    static int qntdCombatentes = 0;


    private Combatente[] geraCombatentes(int qntdCombatentes){
        Combatente[] combatentes = new Combatente[qntdCombatentes];
        for(int i = 0; i < qntdCombatentes; i++){
            if(Math.random() < 0.5){
                combatentes[i] = new Lutador("Boxeador " + ++qntdLutadores);
            }
            else{
                combatentes[i] = new Guerreiro("Guerreiro " + ++qntdGuerreiros);
            }
            System.out.println(combatentes[i].getIdentificacao());
        }
        return combatentes;
    }

    public Combatente combate(Combatente combatente1, Combatente combatente2){
        int turno = 1;
        while(combatente1.getIsAlive() && combatente2.getIsAlive() ){
            if (turno == 1){
                combatente1.atacar(combatente2);
                if(combatente2.getIsAlive() != false){
                    combatente2.atacar(combatente1);
                }
            }
            else{
                combatente2.atacar(combatente2);
                if(combatente1.getIsAlive() != false){
                    combatente1.atacar(combatente1);
                }
            }
            turno += -1;
            System.out.println("[" + combatente1.getIdentificacao() + " - " + combatente1.getEnergia() + "]");
            System.out.println("[" + combatente2.getIdentificacao() + " - " + combatente2.getEnergia() + "]");
            
        }

        if(combatente1.getIsAlive() == true){
            return combatente1;
        }
        else{
            return combatente2;
        }
    }

    public void torneio(){
        for(int i = 0; i < qntdCombatentes - 1; i+= 2){
            System.out.println("Torneio comeca com: " + combatentes[i].getIdentificacao() + " vs " + combatentes[i+1].getIdentificacao());
            Combatente ganhador = combate(combatentes[i], combatentes[i+1]);
            System.out.println("Vencedor e: " + ganhador.getIdentificacao());
        }
    }



    public AppArena(int qntdCombatentes){
        AppArena.qntdCombatentes = qntdCombatentes;
        combatentes = geraCombatentes(qntdCombatentes);
    }


    public static void main(String[] args) {
    	
        AppArena arena = new AppArena(4);
        arena.torneio();


	}

}
