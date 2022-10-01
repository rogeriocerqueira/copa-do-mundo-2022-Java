package DAO;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import Model.Technician;

public class DAOTechnician implements IDAO {
	ArrayList<Technician> technician = new ArrayList<Technician>();
	
	@Override
	public void create() {
				
		Technician nTechnician = new Technician();
		
		/* DECLARAÇÃO DOS ATRIBUTOS  */
		int redCard, yellowCard; 
		String name, nationality, teamKey;
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		
		/* GERA UM CÓDIGO ÚNICO PELA RECURSIVIDADE DO METODO GENERATEUUID() */
		String codtechnician = generateUuid();
		
		/* LEITURA DAS VARIAVEIS */
		System.out.println("Digite o nome do Tecnico:");
		name = read.nextLine();
		
		
		System.out.println("Digite a nacionalidade do Tecnico:");
		nationality = read.nextLine();
		
		System.out.println("Digite a Selecao do Tecnico:");
		teamKey = read.nextLine();
		
		System.out.println("Quantidade cartão de cartão Amarelo:");
		yellowCard = read.nextInt();

		
		System.out.println("Quantidade cartão de cartão Vermelho:");
		redCard = read.nextInt();
		if(redCard > 1) redCard =1;
		
		/*INSTANCIANDO O OBJETO E SETANDO OS VALORES  */
		nTechnician.setUuid(codtechnician);
		nTechnician.setName(name);
		nTechnician.setNationality(nationality);
		nTechnician.setYellowCard(yellowCard);
		nTechnician.setRedCard(redCard);
		nTechnician.setTeamKey(teamKey);
	
		
		/* Verificando as quantidades de cartões do Tecnico */
		checkerCards(nTechnician);
		technician.add(nTechnician);
		
		
	}
	
	
	@Override
	public void readAll() {
		int i = 0; 
		System.out.println(" \n Lista de todos os Jogadores: \n");
		for(i = 0; i<technician.size(); i++ ) {
			
			System.out.println(technician.get(i).getName() + "\n");		
		}
		
	}
	
	@Override
	public void readOne() {
		
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		System.out.println("Digite o nome do Tecnico que deseja procurar:\n");
		String name = read.nextLine();
		for(int i = 0; i<technician.size(); i++ ) {
			
			String nameComp = technician.get(i).getName();
			
			if (nameComp.equals(name)) { 
				System.out.println("\n");
				System.out.println("Codigo: " + technician.get(i).getUuid() + "\n");
				System.out.println("Nome: " + technician.get(i).getName() + "\n");
				System.out.println("Nacionalidade: " + technician.get(i).getNationality() + "\n");
				System.out.println("Cartão Amarelo: " + technician.get(i).getYellowCard() + "\n");
				System.out.println("Cartão Vermelho: " + technician.get(i).getRedCard() + "\n");
				System.out.println("--------------------------");
			}
			else {
				System.out.println("O Tecnico " + name + " nao existe na lista\n");
				
			}
			
		}
		
	}
	
	@Override
	public void updateName() {
		String actuallyName, updateName; 	
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		
		System.out.println("Digite o nome do Tecnico que deseja alterar:");
		actuallyName = read.nextLine();
		
		
		
		for(int i = 0; i<technician.size(); i++) {
			String nameComp = technician.get(i).getName();
			if (actuallyName == nameComp) {
				
				System.out.println("Digite o nome correto:");
				updateName = read.nextLine();
				technician.get(i).setName(updateName);
			} 
		}
		
		;
			
	}
	
	public void updateNationality() {
		String searchName, updateNationality;
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		
		System.out.println("Digite o nome do Tecnico que deseja alterar:");
		searchName = read.nextLine();
		
		/* Busca pelo nome e altera a seleção do Tecnico. */
		 
		for(int i = 0; i<technician.size(); i++) {
			String nameComp = technician.get(i).getName();
			if (searchName == nameComp) {
				
				System.out.println("Digite o nome correto:");
				updateNationality = read.nextLine();
				technician.get(i).setNationality(updateNationality);
			} 
		}
		;
			
	}
	
	public void updateYellowCard() {
		String searchName; 		
		int updateYellowCard;
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		
		System.out.println("Digite o nome do Tecnico que deseja buscar:");
		searchName = read.nextLine();
		
		/* Busca pelo nome e altera a seleção do Tecnico. */
		for(int i = 0; i<technician.size(); i++) {
			String nameComp = technician.get(i).getName();
			
			/* Verificando a existencia do Tecnico na lista */
			if (searchName == nameComp) {
				System.out.println("Digite a quantidade de cartoes amarelo:");
				updateYellowCard = read.nextInt();
				technician.get(i).setYellowCard(updateYellowCard);	
				/* Verifica se o limite de catões possiveis estao sendo atendidos */
				checkerCards(technician.get(i));
			} 
		}
		;
			
	}
	
	public void updateRedCard() {
		String searchName; 		
		int updateRedCard;
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		
		System.out.println("Digite o nome do Tecnico que deseja buscar:");
		searchName = read.nextLine();
		
		/* Busca pelo nome e altera a seleção do Tecnico. */
		for(int i = 0; i<technician.size(); i++) {
			String nameComp = technician.get(i).getName();			
			/* Verificando a existencia do Tecnico na lista */
			if (searchName == nameComp) {
				System.out.println("Digite a quantidade de cartao Vermelho:");
				updateRedCard = read.nextInt();
				technician.get(i).setYellowCard(updateRedCard);	
				/* Verifica se o limite de catões possiveis estao sendo atendidos */
				checkerCards(technician.get(i));
			} 
		}
		;
			
	}
	
	public void updateTeamKey() {
		String searchName; 		
		int updateTeamKey;
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		
		System.out.println("Digite o nome do Tecnico que deseja buscar:");
		searchName = read.nextLine();
		
		/* Busca pelo nome e altera a seleção do Tecnico. */
		for(int i = 0; i<technician.size(); i++) {
			String nameComp = technician.get(i).getName();			
			/* Verificando a existencia do Tecnico na lista */
			if (searchName == nameComp) {
				System.out.println("Digite a quantidade de cartao Vermelho:");
				updateTeamKey = read.nextInt();
				technician.get(i).setYellowCard(updateTeamKey);	
				/* Verifica se o limite de catões possiveis estao sendo atendidos */
				checkerCards(technician.get(i));
			} 
		}
		;
			
	}
	
	@Override
	public void delete() {
		String name; 
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		System.out.println("Digite o nome do Tecnico:");
		name = read.nextLine();
		
		for(int i = 0; i<technician.size(); i++) {
			String nameComp = technician.get(i).getName();
			if (name == nameComp) technician.remove(i);
		}
		;
		
		
	}
	
	private String generateUuid() { 
		
		//Gera um código aleatorio
        Random generator = new Random();
        int uuid =   generator	.nextInt(9999);

        //Verifica a unicidade do codigo
        String codTechnician; 
        for(int i = 0; i < technician.size(); i++) {
        	codTechnician = technician.get(i).getUuid();
        	if (codTechnician.equals("Tec"+uuid)) {
        		generateUuid();	
        	}
        }
        
        return "Tec"+uuid;
    }
	private void checkerCards (Technician nTechnician ) {
		
		/*Garantindo que o numero nao exceda o limite */ 
		if(nTechnician.getYellowCard() >= 2) { 
			nTechnician.setRedCard(1);
			nTechnician.setYellowCard(2);
		}
		
		else if (nTechnician.getRedCard() > 1 ) {
			nTechnician.setRedCard(1);
			
		}
	}

}
