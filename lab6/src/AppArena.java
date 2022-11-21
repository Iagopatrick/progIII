package src;
import java.util.ArrayList;
// import java.util.Iterator;

// import javax.swing.JFileChooser;
// import javax.swing.JOptionPane;

import java.io.BufferedReader;
// import java.io.File;
import java.io.FileReader;
import java.io.IOException;
// import java.net.URL;



public class AppArena {
    static int qntdBoxeadores = 0;
    static int qntdGuerreiros = 0;

    Combatente combatentes[];
    static int qntdCombatentes = 0;


    private Combatente[] geraCombatentes(int qntdCombatentes){
        Combatente[] combatentes = new Combatente[qntdCombatentes];
        for(int i = 0; i < qntdCombatentes; i++){
            if(Math.random() < 0.5){
                combatentes[i] = new Boxeador("Boxeador " + ++qntdBoxeadores);
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
            turno *= -1;
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
            System.out.println("Torneio comeca com: " + combatentes[i].getIdentificacao() +":"+ combatentes[i].getEnergia() + " vs " + combatentes[i+1].getIdentificacao() + ":" + combatentes[i].getEnergia());
            Combatente ganhador = combate(combatentes[i], combatentes[i+1]);
            System.out.println("Vencedor e: " + ganhador.getIdentificacao());
        }
    }



    public AppArena(String csvFilePath) {
		ArrayList<Combatente> combatentes = new ArrayList<Combatente>(); 
		
		String line = "";
		String splitBy = ";";
		try {
			//parsing a CSV file into BufferedReader class constructor  
			//BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Dell\\Desktop\\csvDemo.csv"));
			BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
			while ((line = br.readLine()) != null)
            //returns a Boolean value  
			{
                String[] data = line.split(splitBy);
                int energia = Integer.parseInt(data[2]);
				if(data[0].equalsIgnoreCase("Boxeador")) {
					Boxeador boxeador = new Boxeador(data[1], energia);
					combatentes.add(boxeador);
				}
                else if(data[0].equalsIgnoreCase("Besta")){
                    Besta besta = new Besta(data[0], energia);
                    combatentes.add(besta);
                }
                else {

						Guerreiro guerreiro = new Guerreiro(data[1], energia);
                        

                        int index = combatentes.indexOf(guerreiro);
                        if(index == -1){
                            combatentes.add(guerreiro);
                        }
                        else{
                            guerreiro = (Guerreiro) combatentes.get(index);
                        }
                        // Colocando armas
                        if(data.length == 6){
                            String descicaoArma = data[3];
							String nomeGolpe = data[4];
							int poderOfensivo = Integer.parseInt(data[5]);
													
							//Verifica se arma já foi criada					
							Arma arma = guerreiro.getArma(descicaoArma);
							if(arma == null) {
								arma = new Arma(descicaoArma);
								guerreiro.addArma(arma);
							}
							
							arma.addGolpe(nomeGolpe, poderOfensivo);	
							
							
                        }
                        if(data.length == 9) {
							String descicaoArmadura = data[6];
							int poderDefensivo = Integer.parseInt(data[7]);
							int estadoConservacao = Integer.parseInt(data[8]);
																									
							Armadura armadura = new Armadura(descicaoArmadura,poderDefensivo,estadoConservacao);
							guerreiro.addArmadura(armadura);
							
						}

					}
				
                    qntdCombatentes++;
            }
            this.combatentes = new Combatente[combatentes.size()];
            combatentes.toArray(this.combatentes); //converte arraylist para vetor.
            br.close();
            
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

    public AppArena(int qntdCombatentes){
        AppArena.qntdCombatentes = qntdCombatentes;
        combatentes = geraCombatentes(qntdCombatentes);
    }


    public static void main(String[] args) {
    	String filePath;
        filePath = "C:/Users/Iago Patrick/Desktop/progIII/lab6/src/arquivoArena.csv";


        AppArena arena = new AppArena(filePath);
        arena.torneio();


	}

}
