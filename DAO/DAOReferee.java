package DAO;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import Model.Referee;

public class DAOReferee implements IDAO {
	private ArrayList <Referee> referee = new ArrayList<Referee>();

	
	@Override
	public void create() {
		
		/* DECLARAÇÃO DOS ATRIBUTOS  */
		String name, nationality;
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
	
		
		/* GERA UM CÓDIGO ÚNICO PELA RECURSIVIDADE DO METODO GENERATEUUID() */
		String codreferee = generateUuid();
		
		/* LEITURA DAS VARIAVEIS */
		System.out.println("Digite o nome do Arbitro:");
		name = read.nextLine();
		
		
		System.out.println("Digite a nacionalidade do Arbitro:");
		nationality = read.nextLine();
;
		
		/*INSTANCIANDO O OBJETO E SETANDO OS VALORES  */
		Referee nreferee = new Referee(); 
		nreferee.setUuid(codreferee);
		nreferee.setName(name);
		nreferee.setNationality(nationality);
		
		
		/* ADICIONANDO O OBJETO NO ARRAYLIST */
		referee.add(nreferee); // Criando o objeto e instanciando no ArrayList
		
		
	}
	
	@Override
	public void readAll() {
		int i = 0; 
		System.out.println(" \n Lista de todos os Arbitros: \n");
		for(i = 0; i<referee.size(); i++ ) {
			
			System.out.println(referee.get(i).getName() + "\n");		
		}
		
	}
	
	@Override
	public void readOne() {
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		System.out.println("Digite o nome do Arbitro que deseja procurar:\n");
		String name = read.nextLine();
		for(int i = 0; i<referee.size(); i++ ) {
			
			String nameComp = referee.get(i).getName();
			
			if (nameComp.equals(name)) { 
				System.out.println("\n");
				System.out.println("Nome:" + referee.get(i).getUuid() + "\n");
				System.out.println("Nome:" + referee.get(i).getName() + "\n");
				System.out.println("Nacionalidade:" + referee.get(i).getNationality() + "\n");
				System.out.println("--------------------------");
			}
			else {
				System.out.println("O Arbitro " + name + " nao existe na lista\n");
				
			}
			
		}
		
	}
	
	@Override
	public void updateName() {
		String actuallyName, updateName; 
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		
		System.out.println("Digite o nome do Arbitro que deseja alterar:");
		actuallyName = read.nextLine();
		
		
		
		for(int i = 0; i<referee.size(); i++) {
			String nameComp = referee.get(i).getName();
			if (actuallyName.equals(nameComp)) {
				
				System.out.println("Digite o nome correto:");
				updateName = read.nextLine();
				referee.get(i).setName(updateName);
			} 
		}
		
		
			
	}
	
	public void updateNationality() {
		String searchName, updateNationality; 
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		
		System.out.println("Digite o nome do Arbitro que deseja alterar:");
		searchName = read.nextLine();
		
		/* Busca pelo nome e altera a seleção do Arbitro. */
		 
		for(int i = 0; i<referee.size(); i++) {
			String nameComp = referee.get(i).getName();
			if (searchName.equals(nameComp)) {
				
				System.out.println("Digite o nome correto:");
				updateNationality = read.nextLine();
				referee.get(i).setNationality(updateNationality);
			} 
		}
		
			
	}
	
	@Override
	public void delete() {
		String name; 
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		System.out.println("Digite o nome do Arbitro:");
		name = read.nextLine();
		
		for(int i = 0; i<referee.size(); i++) {
			String nameComp = referee.get(i).getName();
			if (name == nameComp) referee.remove(i);
		}
			
	}
	
	private String generateUuid() { 
		
		//Gera um código aleatorio
        Random generator = new Random();
        int uuid =   generator.nextInt(9999);

        //Verifica a unicidade do codigo
        String codReferee; 
        for(int i = 0; i < referee.size(); i++) {
        	codReferee = referee.get(i).getUuid();
        	if (codReferee.equals("Ref"+uuid)) {
        		generateUuid();	
        	}
        }
        return "Ref"+uuid;
    }
	
}
	

