package src;
import java.util.ArrayList;
import java.util.Locale;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;



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

// Parte do combate no app

    public void listarCombatentes(){
        System.out.println("Combatentes:");
		for (int i = 0; i < combatentes.length; i++) {
			System.out.println(" "+ i + ": " + combatentes[i]);
		}
    }

    
    public int qntdCombatentesVivos(){
        int retorno = 0;
        for(int i = 0; i < combatentes.length; i++){
            retorno += combatentes[i].getIsAlive()? 1:0;
        }
        return retorno;
    }

    public int indiceProxCombatente(int index){
        int i = index;
        while(i != (index - 1)){
            if(i > combatentes.length - 1){
                i = 0;
            }
            if(combatentes[i].getIsAlive()){
                return i;
            }
            i++;
        }
        return -1;
        
    }
    public void torneio(){
        listarCombatentes();
        int index = 0;
        while(qntdCombatentesVivos() > 1){
            int indiceCombatente1 = indiceProxCombatente(index);
            Combatente combatente1 = combatentes[indiceCombatente1];
            
            index = indiceCombatente1 + 1;
            
            int indiceCombatente2 = indiceProxCombatente(index);
            
            
            if(indiceCombatente2 != -1){
                Combatente combatente2 = combatentes[indiceCombatente2];
                System.out.println("Combate: " + combatente1.getIdentificacao() +":"+ combatente1.getEnergia()  + " vs " + combatente2.getIdentificacao() + ":" + combatente2.getEnergia());
                index = indiceCombatente2 + 1;
                combate(combatente1, combatente2);
            }
        }


    }

    public void combate(Combatente combatente1, Combatente combatente2){
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

        Combatente vencedor = combatente1.getIsAlive()? combatente1:combatente2;

        System.out.println("Vencedor e: " + vencedor.getIdentificacao());

        if((combatente1 instanceof Guerreiro) && (combatente2 instanceof Guerreiro)){
            Combatente perdedor = combatente1.getIsAlive()? combatente2:combatente1;
            ((Guerreiro)vencedor).addArma(((Guerreiro)perdedor).getArmas());
            ((Guerreiro)vencedor).addArmadura(((Guerreiro)perdedor).getArmaduras());
            
        }

        
    }
    
    public Combatente getVencedor(){
        
        if(qntdCombatentes == 1){
            int indice = indiceProxCombatente(0);
            return combatentes[indice];
        }
        return null;
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
    	// String filePath;
        // filePath = "C:/Users/Iago Patrick/Desktop/progIII/lab6/src/arquivoArena.csv";


        // AppArena arena = new AppArena(filePath);
        // arena.torneio();

        
        

		Locale.setDefault(Locale.ENGLISH); //necessário para o Lab 09
		String strFileName = "./saida.csv";		

		try {
			//AppArena arena =  new AppArena(filePath);
			
				
			//Path fileName = Path.of("./res/torneios.csv");
			Path fileName = Path.of(strFileName);
			
			Files.writeString(
					fileName, 
					"tipoPersonagem;nomePersonagem;nivelEnergia;descricaoArma;"
							+ "descicaoGolpe;poderOfensivoGolpe;descricaoArmadura;"
							+ "poderDefesaArmadura;estadoConservacaoArmadura\r\n");


			for (int i = 0; i < 10; i++) {		   
				AppArena arena =  new AppArena(10);
				arena.torneio();
				Combatente campeao = arena.getVencedor();		

		    	//Files.writeString(fileName, campeao.toString()+"\r\n");
				Files.writeString(fileName, campeao.textToCSV(), StandardOpenOption.APPEND);

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro na gravação do arquivo");
			e.printStackTrace();
		}

	}

}
