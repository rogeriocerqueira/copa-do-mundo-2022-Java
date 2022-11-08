/*******************************************************************************
Autor: João Victor Macedo dos Santos Lima e Rogério dos Santos Cerqueira
Componente Curricular: EXA863 - MI Programação
Concluido em: 26/09/2022
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/

package Main; /*MVC*/

import java.util.Scanner;
import Controller.DAOReferee;
import Controller.DAOSoccer;
import Controller.DAOTeam;
import Controller.DAOTechnician;
import View.OperetionDef;
import View.RegistrationDef;

/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/	

public class Principal {
	
	public static void main(String[] args) {
		
		int endProgram = 0; /* Registra a escolha do tipo de operacao que o usuario quer realizar */
		
		/*Intanciação dos objetos referentes ao package Controller e DAO's de cada classe especifica */
		DAOSoccer nSoccer = new DAOSoccer(String name, String nationality, int redCard, int yellowCard, int points);
		DAOTechnician nTechnician = new DAOTechnician(String name, String nationality, String teamKey, int redCard, int yellowCard);
		DAOReferee nReferee = new DAOReferee(String name, String nationality);
		DAOTeam nTeam = new DAOTeam(String name, String technician, String groupName);
		DAOGroup nGroup = new DAOTeam(String name, String technician);
		DAOMatch nTeam = new DAOTeam(String name, String technician);
		
		/*Implementação dos objetos de operação*/
		
		
		@SuppressWarnings("resource")
		Scanner read = new Scanner( System.in );
		
		do { 
			
			OperationDef choiceOne = new OperationDef();
			int operation = choiceOne.definitionOne;
			
			
			switch (operation) {
			
			
/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
			case 1: /*Operação = Cadastro*/
				
				RegistrationDef choiceTwo = new RegistrationDef(operation);
				int registration = choiceTwo.definitionTwo;
				
				if (registration == 1) {
					
					/* LEITURA DAS VARIAVEIS */
					System.out.println("Digite o nome do jogador:");
					name = read.nextLine();
					
					
					System.out.println("Digite o país de nascimento ou naturalização do jogador:");
					nationality = read.nextLine();
					
					System.out.println("Digite a quantidade de cartões amarelos do jogador:");
					yellowCard = read.nextInt();

					
					System.out.println("Digite a quantidade de cartões vermelhos do jogador:");
					redCard = read.nextInt();
					
					
					System.out.println("Digite a quantidade de gols do jogador:");
					points = read.nextInt();
					
					nSoccer.create();
				}
				
				else if (registration == 2) {
					
					/* LEITURA DAS VARIAVEIS */
					System.out.println("Digite o nome do técnico:");
					name = read.nextLine();
					
					
					System.out.println("Digite o país de nascimento ou naturalização do técnico:");
					nationality = read.nextLine();
					
					System.out.println("Digite a seleção do técnico:");
					teamKey = read.nextLine();
					
					System.out.println("Quantidade cartões amarelos do técnico:");
					yellowCard = read.nextInt();

					
					System.out.println("Quantidade cartão de cartões vermelhos do técnico:");
					
					nTechnician.create();
				}

				else if (registration == 3 ) {
					
					/* LEITURA DAS VARIAVEIS */
					System.out.println("Digite o nome do árbitro:");
					name = read.nextLine();
					
					
					System.out.println("Digite o país de nascimento ou naturalização do árbitro:");
					nationality = read.nextLine();
					
					nReferee.create();
				}

				else if (registration == 4 ) {
					
					/* LEITURA DAS VARIAVEIS */
					System.out.println("Digite o nome da seleção:");
					name = read.nextLine();
					
					
					System.out.println("Digite o nome do técnico da seleção:");
					nationality = read.nextLine();
					
					System.out.println("Digite o grupo da seleção:");
					groupName = read.nextLine();
					
					nTeam.create();
					
				}
				
				
				else System.out.println(" Digite uma opção válida ! /n ");
								
			break;	

/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
			
			case 2: /*Operação = Buscar*/
				
				RegistrationDef choiceTwo = new RegistrationDef(opration);
				int registration = choiceTwo.definitionTwo;
				
				if (registration == 1) { 
					
					System.out.println("Digite o nome do jogador que deseja buscar:  /n");
					String searchname = read.nextLine();
					nSoccer.readOne(searchName);
				
				}
				
				else if (registration == 2) {
					
					System.out.println("Digite o nome do técnico que deseja buscar:  /n");
					String searchname = read.nextLine();
					nTechnician.readOne(searchName);
				
				}

				else if (registration == 3 ) {
					
					System.out.println("Digite o nome do árbitro que deseja buscar:  /n");
					String searchname = read.nextLine();
					nReferee.readOne(searchName);
				
				}

				else if (registration == 4 ) {
					
					System.out.println("Digite o nome da seleção que deseja buscar:  /n");
					String searchname = read.nextLine();
					nTeam.readOne(searchName);
					nSoccer.readAll(); /*PRECISA SER REVISADO !!!!!!!!*/
				}
				
				else System.out.println(" Digite uma opção válida ! /n ");
				
			break;
/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
			
			case 3: /*Operação = Listar*/
				
				RegistrationDef choiceTwo = new RegistrationDef(opration);
				int registration = choiceTwo.definitionTwo;
				
				if (registration == 1) {nSoccer.readAll();
				
				}
				
				else if (registration == 2) {nTechnician.readAll();
				
				}

				else if (registration == 3 ) {nReferee.readAll();
				
				}

				else if (registration == 4 ) {nTeam.readAll();
				
				}
				
				else System.out.println(" Digite uma opção válida ! /n ");
				
			break;
/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
			
			case 4: /*Operação = Atualizar*/
				
				boolean confirm = false;
				int update = 0;
				
				RegistrationDef choiceTwo = new RegistrationDef(opration);
				int registration = choiceTwo.definitionTwo;
				
				if (registration == 1) {
					
					System.out.println("\n");
					System.out.println("1 -Atualizar nome do jogador\n ");
					System.out.println("2- Atualizar nacionalidade\n");
					System.out.println("3- Atualizar quantidade de cartões amerelos\n");
					System.out.println("4- Atualizar quantidade de cartões vermelhos\n");
					System.out.println("5- Atualizar quantidade de gols\n");
					
					update = read.nextInt();
					
					System.out.println("Digite o nome do jogador que deseja corrigir: /n");
					String searchName = read.nextLine();
					
					if (update == 1) {
						
						System.out.println("Digite o nome CORRETO do jogador que deseja corrigir: /n");
						String newName = read.nextLine();
						
						confirm = nSoccer.updateName(String searchName, String newName);
					
					}
					
					else if (update == 2) {
						
						System.out.println("Digite o nome CORRETO do país do jogador que deseja corrigir: /n");
						String newNationality = read.nextLine();
						
						confirm = nSoccer.updateNationality(searchName,newNationality);
					
					}
					
					else if (update == 3) {
						
						System.out.println("Digite a quatidade CORRETA de cartões amarelos do jogador que deseja corrigir: /n");
						String newYellowCard = read.nextLine();
						confirm = nSoccer.updateYellowCard(searchName, newYellowCard);
					
					}
					
					else if (update == 4) {
						
						System.out.println("Digite a quatidade CORRETA de cartões vermelhos do jogador que deseja corrigir: /n");
						String newRedCard = read.nextLine();
						confirm = nSoccer.updateRedCard(searchName, newRedCard);
					
					}
					
					else if (update == 5) {
						
						System.out.println("Digite a quatidade CORRETA de gols do jogador que deseja corrigir: /n");
						String newPoints = read.nextLine();
						confirm = nSoccer.upadatePoints();
					}
					
					else System.out.println(" Digite uma opção válida ! /n ");
					
				}
				
				else if (registration == 2) {
					
					System.out.println("\n");
					System.out.println("1 -Atualizar nome do técnico\n ");
					System.out.println("2- Atualizar nacionalidade\n");
					System.out.println("3- Atualizar quantidade de  cartões amerelos\n");
					System.out.println("4- Atualizar quantidade de cartões vermelhos\n");
					System.out.println("5- Atualizar quantidade de gols\n");
					
					update = read.nextInt();
					
					System.out.println("Digite o nome do técnico que deseja corrigir: /n");
					String searchName = read.nextLine();
					
					if (update == 1) {
					
						System.out.println("Digite o nome CORRETO do técnico que deseja corrigir: /n");
						String newName = read.nextLine();
					
						comfirm = nTechnician.updateName(String searchName, String newName);
					}
	
					else if (update == 2 ) {
						
						System.out.println("Digite o nome CORRETO do país do técnico que deseja corrigir: /n");
						String newNationality = read.nextLine();
						
						confirm = nTechnician.updateNationality(String searchName, String newNationality);
					
					}
	
					else if (update == 3 ) {
						
						System.out.println("Digite a quatidade CORRETA de cartões amarelos do técnico que deseja corrigir: /n");
						String newYellowCard = read.nextLine();
						confirm = nTechnician.updateYellowCard(searchName, newYellowCard);
					
					}
					
					else if (registration == 4 ) {
						
						System.out.println("Digite a quatidade CORRETA de cartões vermelhos do jogador que deseja corrigir: /n");
						String newRedCard = read.nextLine();
						confirm = nTechnician.updateRedCard(searchName, newYellowCard);
					
					}
					
					else if (registration == 5 ) {
					
					System.out.println("Digite a seleção CORRETA do técnico que deseja corrigir: /n");
					String newTeamKey = read.nextLine();
					confirm = nTechnician.updateTeamKey(searchName,newTeamKey);
					
					}
					
					else System.out.println(" Digite uma opção válida ! /n ");
				}	
				
				else if (registration == 3) {
					
					System.out.println("1 -Atualizar nome do árbitro\n ");
					System.out.println("2- Atualizar nacionalidade\n");
					
					update = read.nextInt();
					
					System.out.println("Digite o nome do árbitro que deseja corrigir: /n");
					String searchName = read.nextLine();
					
					if (update == 1) {
					
						
					
						System.out.println("Digite o nome CORRETO do árbitro que deseja corrigir: /n");
						String newName = read.nextLine();
					
						comfirm = nReferee.updateName(String searchName, String newName);
					
					}
					
					else if (update == 2 ) {
						
						System.out.println(" Digite o nome CORRETO do país do árbitro que deseja corrigir: /n" );
						String newNationality = read.nextLine();
						
						confirm = nReferee.updateNationality(String searchName, String newNationality);
						
					}
					
					else System.out.println(" Digite uma opção válida ! /n ");
				}	
				
				else if (registration == 4) {
					
					System.out.println("1 -Atualizar nome do seleção\n ");
					System.out.println("2- Atualizar do técnico da seleção\n");
					
					update = read.nextInt();
					
					System.out.println("Digite o nome da seleção que deseja corrigir: /n");
					String searchName = read.nextLine();
						
					if (update == 1) {
						
						System.out.println("Digite o nome CORRETO da seleção que deseja corrigir: /n");
						String newName = read.nextLine();
						
						comfirm = nTeam.updateName(String searchName, String newName);
					
					}
	
					else if (update == 2 ) nTeam.updatetechnician();
					
					else System.out.println(" Digite uma opção válida ! /n ");
				}
				
				else System.out.println ("Digite uma opção válida !!!");
				
				
				if (confirm = true) {
					System.out.println("Atualização feita com sucesso !");
				}
				else System.out.println("Não foi possivel localizar essa informação !");
				
			break;
				
/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
				
			case 5: /*Operação = Deletar*/
				
				RegistrationDef choiceTwo = new RegistrationDef(opration);
				int registration = choiceTwo.definitionTwo;
				
				boolean confirm = false;
				
				if (registration == 1) {
					
					System.out.println(" Digite o nome do jogador que deseja deletar: ");
					String deleteName = read.nextLine();
					
					confirm = nSoccer.delete(deleteName);
				}
				
				else if (registration == 2) {
					
					System.out.println(" Digite o nome do técnico que deseja deletar: ");
					String deleteName = read.nextLine();
					
					confirm = Technician.delete(deleteName);
				}

				else if (registration == 3 ) {
					
					System.out.println(" Digite o nome do árbitro que deseja deletar: ");
					String deleteName = read.nextLine();
					
					confirm = nReferee.delete(deleteName);
				}

				else if (registration == 4 ) {
					
					System.out.println(" Digite o nome da seleção que deseja deletar: ");
					String deleteName = read.nextLine();
					
					confirm = nTeam.delete(deleteName);
				
				}
				
				else System.out.println("Digite uma opção válida ");
				
				if(confirm == true) System.out.println( deleteName + "foi deletado !");
				else System.out.println( deleteName + "não foi encontrado!");
				
				break;
				
			default: 
				System.out.println("Opção invalida !!! \n ");
				
			}
				
		System.out.println("Deseja continuar no programa ?");
		System.out.println("0 - Sim \t 1 - Nao \n ");
		endProgram = read.nextInt();
		
		} while(endProgram == 0);

	}
	
}

/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

/*Fim*/
