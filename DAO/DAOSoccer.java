package DAO;
import Model.Soccer;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class DAOSoccer implements IDAO {
	ArrayList <Soccer> soccer = new ArrayList<Soccer>();

	
	//@Override
	public void create() {
		
		/* DECLARAÇÃO DOS ATRIBUTOS  */
		int redCard, yellowCard, points; 
		String name, nationality;
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
	
		
		/* GERA UM CÓDIGO ÚNICO PELA RECURSIVIDADE DO METODO GENERATEUUID() */
		String codSoccer = generateUuid();
		
		/* LEITURA DAS VARIAVEIS */
		System.out.println("Digite o nome do jogador:");
		name = read.nextLine();
		
		
		System.out.println("Digite a nacionalidade do jogador:");
		nationality = read.nextLine();
		
		
		System.out.println("Quantidade cartão de cartão Amarelo:");
		yellowCard = read.nextInt();

		
		System.out.println("Quantidade cartão de cartão Vermelho:");
		redCard = read.nextInt();
		if(redCard > 1) redCard = 1;
		
		System.out.println("Quantidade de Gols:");
		points = read.nextInt();
		
		/*INSTANCIANDO O OBJETO E SETANDO OS VALORES  */
		Soccer nSoccer = new Soccer(); 
		nSoccer.setUuid(codSoccer);
		nSoccer.setName(name);
		nSoccer.setNationality(nationality);
		nSoccer.setYellowCard(yellowCard);
		nSoccer.setRedCard(redCard);
		nSoccer.setPoints(points);	
		
		/* Verificando as quantidades de cartões do jogador */
		checkerCards(nSoccer);
		
		/* ADICIONANDO O OBJETO NO ARRAYLIST */
		soccer.add(nSoccer); // Criando o objeto e instanciando no ArrayList
		
		
		
	}
	
	//@Override
	public void readAll() {
		int i = 0; 
		System.out.println(" \n Lista de todos os Jogadores: \n");
		System.out.println("--------------------------");
		for(i = 0; i<soccer.size(); i++ ) {
			
			System.out.println(soccer.get(i).getName() + "\n");		
		}
		
	}
	 
	
	//@Override
	public void readOne() {
		
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		String name;
		
		System.out.println("Digite o nome do Jogador que deseja procurar:\n");
		name = read.nextLine();
		for(int i = 0; i<soccer.size(); i++ ) {
			
			String nameComp = soccer.get(i).getName();
			
			if (nameComp.equals(name)) { 
				System.out.println("\n");
				System.out.println("--------------------------");
				System.out.println("Codigo:" + soccer.get(i).getUuid() + "\n");
				System.out.println("Nome:" + soccer.get(i).getName() + "\n");
				System.out.println("Nacionalidade:" + soccer.get(i).getNationality() + "\n");
				System.out.println("Cartão Amarelo:" + soccer.get(i).getYellowCard() + "\n");
				System.out.println("Cartão Vermelho:" + soccer.get(i).getRedCard() + "\n");
				System.out.println("Quantidade de Gols:" + soccer.get(i).getPoints() + "\n");
				System.out.println("--------------------------");
			}
			else {
				System.out.println("O jogador " + name + " nao existe na lista\n");
				
			}
		}
		
	}
	
	//@Override
	public void updateName() {
		String actuallyName, updateName; 
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		
		System.out.println("Digite o nome do jogador que deseja alterar:");
		actuallyName = read.nextLine();
		
		
		
		for(int i = 0; i<soccer.size(); i++) {
			String nameComp = soccer.get(i).getName();
			if (actuallyName.equals(nameComp)) {
				
				System.out.println("Digite o nome correto:");
				updateName = read.nextLine();
				soccer.get(i).setName(updateName);
				System.out.println("O nome: " + actuallyName + " foi alterado com sucesso" + updateName);
			} 
		}
		
		
				
	}
	
	public void updateNationality() {
		String searchName, updateNationality; 
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		
		System.out.println("Digite o nome do jogador que deseja alterar:");
		searchName = read.nextLine();
		
		/* Busca pelo nome e altera a seleção do jogador. */
		 
		for(int i = 0; i<soccer.size(); i++) {
			String nameComp = soccer.get(i).getName();
			if (searchName.equals(nameComp)) {
				
				System.out.println("Digite o nome correto:");
				updateNationality = read.nextLine();
				soccer.get(i).setNationality(updateNationality);
			} 
		}
	}
	
	public void updateYellowCard() {
		String searchName; 		
		int updateYellowCard;
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		
		System.out.println("Digite o nome do jogador que deseja buscar:");
		searchName = read.next();
		
		/* Busca pelo nome e altera a seleção do jogador. */
		for(int i = 0; i<soccer.size(); i++) {
			String nameComp = soccer.get(i).getName();
			
			/* Verificando a existencia do jogador na lista */
			if (searchName.equals(nameComp)) {
				System.out.println("Digite a quantidade de cartoes amarelo:");
				updateYellowCard = read.nextInt();
				soccer.get(i).setYellowCard(updateYellowCard);	
				/* Verifica se o limite de catões possiveis estao sendo atendidos */
				checkerCards(soccer.get(i));
			} 
		}
			
	}
	
	public void updateRedCard() {
		String searchName; 		
		int updateRedCard;
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		
		System.out.println("Digite o nome do jogador que deseja buscar:");
		searchName = read.next();
		
		/* Busca pelo nome e altera a seleção do jogador. */
		for(int i = 0; i<soccer.size(); i++) {
			String nameComp = soccer.get(i).getName();			
			/* Verificando a existencia do jogador na lista */
			if (searchName.equals(nameComp)) {
				System.out.println("Digite a quantidade de cartao Vermelho:");
				updateRedCard = read.nextInt();
				soccer.get(i).setYellowCard(updateRedCard);	
				/* Verifica se o limite de catões possiveis estao sendo atendidos */
				checkerCards(soccer.get(i));
			} 
		}
			
	}
	
	public void upadatePoints() {
		String searchName; 
		int updatePoints;
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		
		System.out.println("Digite o nome do jogador que deseja buscar:");
		searchName = read.next();
		
		/* Busca pelo nome e altera a quantidade de gols do jogador. */
		for(int i = 0; i<soccer.size(); i++) {
			String nameComp = soccer.get(i).getName();
			if (searchName.equals(nameComp)) {
				
				System.out.println("Digite a quantidade de gols que ele fez:");
				updatePoints = read.nextInt();
				soccer.get(i).setPoints(updatePoints);
			} 
		}
			
	}
	
	//@Override
	public void delete() {
		String name;
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		System.out.println("Digite o nome do jogador:");
		name = read.nextLine();
		//Procura o nome no ArrayList e remove se encontrar
		for(int i = 0; i<soccer.size(); i++) {
			String nameComp = soccer.get(i).getName();
			if (name.equals(nameComp)) soccer.remove(i);
			System.out.println("O nome: " + name + " foi deletado com sucesso");
		}
		
		
	}
	
	private String generateUuid() { 
		
		//Gera um código aleatorio
        Random generator = new Random();
        int uuid =   generator.nextInt(9999);

        //Verifica a unicidade do codigo
        String codSoccer; 
        for(int i = 0; i < soccer.size(); i++) {
        	codSoccer = soccer.get(i).getUuid();
        	if (codSoccer.equals("Jog"+uuid)) {
        		generateUuid();	
        	}
        }
       
        return "Jog"+uuid;
    }
	
	private void checkerCards (Soccer nSoccer ) {
		
		/*Garantindo que o numero nao exceda o limite */ 
		if(nSoccer.getYellowCard() >= 2) { 
			nSoccer.setRedCard(1);
			nSoccer.setYellowCard(2);
		}
		
		else if (nSoccer.getRedCard() > 1 ) {
			nSoccer.setRedCard(1);
			
		}
	}
	
	/*Recebe o nome da selecao e retorna um array de string com nomes dos jogadores */
	public String[] ListSoccer(String teamNationality) {
		String[] nameSoccer = new String[26];
		String team;
		for (int i = 0; i < soccer.size(); i++) {
			team = soccer.get(i).getNationality();
			if(teamNationality.equals(team))
				nameSoccer[i] = soccer.get(i).getName();
		}
		return nameSoccer;
	}
	
}