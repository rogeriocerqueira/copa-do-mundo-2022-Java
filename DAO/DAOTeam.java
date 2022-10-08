package DAO;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;
import Model.Team;

public class DAOTeam  implements IDAO{
	ArrayList <Team> team = new ArrayList<Team>();
	Hashtable <String, String[]> listSoccers = new Hashtable<>();

	
	//@Override
	public void create() {
		
		/* DECLARAÇÃO DOS ATRIBUTOS  */ 
		String name, technician;
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
	
		
		/* GERA UM CÓDIGO ÚNICO PELA RECURSIVIDADE DO METODO GENERATEUUID() */
		String codteam = generateUuid();
		
		System.out.println("Digite o nome do tecnico da Selecao:");
		technician = read.nextLine();
				
		/*INSTANCIANDO O OBJETO E SETANDO OS VALORES  */
		Team nteam = new Team();
		nteam.setUuid(codteam);
		nteam.setName(name);
		nteam.setTechnician(technician);
		
		
		/* ADICIONANDO O OBJETO NO ARRAYLIST */
		team.add(nteam); // Criando o objeto e instanciando no ArrayList
		
		
	}

	//@Override
	public void readAll() {
		int i = 0; 
		System.out.println(" \n Lista de Selecoes: \n");
		for(i = 0; i<team.size(); i++ ) {
			
			System.out.println(team.get(i).getName() + "\n");		
		}
		
	}
	
	//@Override
	public void readOne() {
		
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		System.out.println("Digite o nome da Selecao que deseja procurar:\n");
		String name = read.nextLine();
		for(int i = 0; i<team.size(); i++ ) {
			
			String nameComp = team.get(i).getName();
			
			if (nameComp.equals(name)) { 
				System.out.println("\n");
				System.out.println("Codigo:" + team.get(i).getUuid() + "\n");
				System.out.println("Nome:" + team.get(i).getName() + "\n");
				System.out.println("Jogadores:");
				
				System.out.println("--------------------------");
				
			}
			else {
				System.out.println("A Selecao " + name + " nao existe na lista\n");
				
			}
			
		}
		
	}
	
	//@Override
	public void updateName() {
		String actuallyName, updateName; 
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		
		System.out.println("Digite o nome da Selecao que deseja alterar:");
		actuallyName = read.nextLine();
		
		
		
		for(int i = 0; i<team.size(); i++) {
			String nameComp = team.get(i).getName();
			if (actuallyName == nameComp) {
				
				System.out.println("Digite o nome correto:");
				updateName = read.nextLine();
				team.get(i).setName(updateName);
			} 
		}
		
		
			
	}
	
	public void updatetechnician() {
		String searchName, updateTechnician; 
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		
		System.out.println("Digite o nome da Selecao que deseja alterar:");
		searchName = read.nextLine();
		
		/* Busca pelo nome e altera a seleção do Selecao. */
		 
		for(int i = 0; i<team.size(); i++) {
			String nameComp = team.get(i).getName();
			if (searchName == nameComp) {
				
				System.out.println("Digite o nome correto:");
				updateTechnician = read.nextLine();
				team.get(i).setTechnician(updateTechnician);
			} 
		}
		
			
	}
	
	//@Override
	public void delete() {
		String name; 
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		System.out.println("Digite o nome da Selecao:");
		name = read.nextLine();
		
		for(int i = 0; i<team.size(); i++) {
			String nameComp = team.get(i).getName();
			if (name == nameComp) team.remove(i);
		}
		
	}
	
	private String generateUuid() { 
		
		//Gera um código aleatorio
        Random generator = new Random();
        int uuid =   generator.nextInt(9999);

        //Verifica a unicidade do codigo
        String codTeam; 
        for(int i = 0; i < team.size(); i++) {
        	codTeam = team.get(i).getUuid();
        	if (codTeam.equals("Team"+uuid)) {
        		generateUuid();	
        	}
        }
        return "Team"+uuid;
    }
	
	public void listSoccer (String nameTeam, String[] listSoccer ) {
		listSoccers.put(nameTeam, listSoccer);
	}
	
}

