package DAO;
import Model.Soccer;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class DAOSoccer implements IDAO {
	ArrayList <Soccer> soccer = new ArrayList<Soccer>();
	
	String name, nationality, codSoccer = generateUuid();
	int redCard, yellowCard, points;
	Scanner read = new Scanner(System.in);
	
	public DAOSoccer(String name, String nationality, int redCard, int yellowCard, int points){
		super();
		this.name = name;
		this.nationality = nationality;
		this.redCard = redCard;
		this.yellowCard = yellowCard;
		this.points = points;
	}

	//@Override
	public void create() {
		
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
	
	@Override
	public void readAll() {
		int i = 0; 
		System.out.println(" \n Lista de todos os Jogadores: \n");
		System.out.println("--------------------------");
		for(i = 0; i<soccer.size(); i++ ) {
			
			System.out.println(soccer.get(i).getName() + "\n");		
		}
		
	}
	
	@Override
	public void readOne(String name) {
		
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
	
	@Override
	public boolean updateName(String searchName, String updaterName) {
		String actuallyName; 
		for(int i = 0; i<soccer.size(); i++) {
			actuallyName = soccer.get(i).getName();
			
			if (actuallyName.equals(updaterName)) {
				soccer.get(i).setName(updaterName);
				return true;
			}
		}	
		return false;
	}
	
	@Override
	public boolean delete(String deleteName) {
		
		//Procura o nome no ArrayList e remove se encontrar
		for(int i = 0; i<soccer.size(); i++) {
			String nameComp = soccer.get(i).getName();
			if (name.equals(nameComp)) {
				soccer.remove(i);
				return true;
			}
		}
		
		return false;
			
	}
	
	
	public boolean updateNationality(String searchNationality, String updateNationality) {
		String actuallyName; 
		for(int i = 0; i<soccer.size(); i++) {
			actuallyName = soccer.get(i).getName();
			
			if (actuallyName.equals(searchNationality)) {
				soccer.get(i).setName(updateNationality);
				return true;
			}
		}	
		return false;
	}
		
		public boolean updateYellowCard(String nameSoccer, int updateYellowCard) {

			/* Busca pelo nome e altera a seleção do jogador. */
			for(int i = 0; i<soccer.size(); i++) {
				String nameComp = soccer.get(i).getName();
				
				/* Verificando a existencia do jogador na lista */
				if (nameComp.equals(nameSoccer)) {
					soccer.get(i).setYellowCard(updateYellowCard);	
					/* Verifica se o limite de catões possiveis estao sendo atendidos */
					checkerCards(soccer.get(i));
					return true;
				} 
			}
				
			return false;
		}
		
		public boolean updateRedCard(String nameSoccer, int updateRedCard) {
			
			/* Busca pelo nome e altera a seleção do jogador. */
			for(int i = 0; i<soccer.size(); i++) {
				String nameComp = soccer.get(i).getName();
				
				/* Verificando a existencia do jogador na lista */
				if (nameComp.equals(nameSoccer)) {
					soccer.get(i).setYellowCard(updateRedCard);	
					/* Verifica se o limite de catões possiveis estao sendo atendidos */
					checkerCards(soccer.get(i));
					return true;
				} 
			}
			return false;
		}
		
		public boolean upadatePoints(String searchName, int updaterPoints) {

			
			/* Busca pelo nome e altera a quantidade de gols do jogador. */
			for(int i = 0; i<soccer.size(); i++) {
				String nameComp = soccer.get(i).getName();
				if(searchName.equals(nameComp)) {
					soccer.get(i).setPoints(updaterPoints);
					return true;
				} 
			}
			return false;
				
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


