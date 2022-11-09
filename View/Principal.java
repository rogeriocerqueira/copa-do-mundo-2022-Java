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

import Controller.DAOMatch;
import Controller.DAOReferee;
import Controller.DAOSoccer;
import Controller.DAOTeam;
import Controller.DAOTechnician;
import View.OperationDef;
import View.RegistrationDef;
import Model.Group;

/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/	

public class SysCopa2 {
	
	public static void main(String[] args) {
		
		String name = ""; 
		String nationality = ""; 
		String teamKey = ""; 
		String technician = "";
		String groupName = "";
		String date = "";
		String local = "";
		String teamOne = "";
		String teamTwo = "";
		String groupMatch = "";
		String codMatch = ""; 
		String time = "";
		
		int yellowCard = 0;
		int redCard = 0; 
		int points = 0; 
		int golsT1 = 0;
		int golsT2 = 0; 
		int rank = 0;
		
		int operation = 0;  /* Registra a escolha dos tipos de operação e tipos de usuário */
		int registration = 0;
		int endProgram = 0;
		
		/*Intanciação dos objetos referentes ao package Controller e DAO's de cada classe especifica */
		
		DAOSoccer nSoccer = new DAOSoccer( name,  nationality,  yellowCard,  redCard, points);
		
		DAOTechnician nTechnician = new DAOTechnician( name,  nationality,  teamKey,  redCard,  yellowCard);
		
		DAOReferee nReferee = new DAOReferee( name,  nationality);
		
		DAOTeam nTeam = new DAOTeam( name,  technician,  groupName,  rank);
		
		DAOMatch nMatch = new DAOMatch ( date,  local,  teamOne,  teamTwo,  groupMatch,  codMatch,  time, golsT1,  golsT2);
		
		Group GsChampions = new Group();
		
		
		
		/*Implementação dos objetos de operação*/
		
		
		@SuppressWarnings("resource")
		Scanner read = new Scanner( System.in );
		
		do { 
			
			OperationDef choiceOne = new OperationDef();
			operation = choiceOne.definitionOne();
			
			RegistrationDef choiceTwo = new RegistrationDef();
			registration = choiceTwo.definitionTwo(operation);
			
			switch (operation) {			
			
/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
			case 1: /*Operação = Cadastro*/
				
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
					GsChampions.addOnGroup(time);
					
				}
				
				else if (registration ==5) {
					
					/* LEITURA DAS VARIAVEIS */
					System.out.println("Digite a data da partida: \n " + "Exemplo d formato 00110011");
					date = read.nextLine();
					
					System.out.println("Digite o local da partida: \n ");
					local = read.nextLine();
					
					System.out.println("Digite o horário da partida:\n -> 7:00 \n -> 10:00  \n -> 13:00 \n -> 16:00 \n ");
					time = read.nextLine();
					
					System.out.println("Digite o time 1: \n");
					teamOne = read.nextLine();
					
					System.out.println("Digite o time 2: \n");
					teamTwo = read.nextLine();
					
					System.out.println("Digite o grupo do qual faz parte os times: \n");
					groupMatch = read.nextLine();
					
					System.out.println("Digite o nº de gols do time" + teamOne + ":" + "\n");
					golsT1 = read.nextInt();
					
					System.out.println("Digite o nº de gols do time" + teamTwo + ":" + "\n");
					golsT2 = read.nextInt();
					
					nMatch.registrationMatch();
					
				}
				
				
				else System.out.println(" Digite uma opção válida ! \n ");
								
			break;	

/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
			
			case 2: /*Operação = Buscar*/
				
				
				if (registration == 1) { 
					
					System.out.println("Digite o nome do jogador que deseja buscar:  \n");
					String searchName = read.nextLine();
					nSoccer.readOne(searchName);
				
				}
				
				else if (registration == 2) {
					
					System.out.println("Digite o nome do técnico que deseja buscar:  \n");
					String searchName = read.nextLine();
					nTechnician.readOne(searchName);
				
				}

				else if (registration == 3 ) {
					
					System.out.println("Digite o nome do árbitro que deseja buscar:  \n");
					String searchName = read.nextLine();
					nReferee.readOne(searchName);
				
				}

				else if (registration == 4 ) {
					
					System.out.println("Digite o nome da seleção que deseja buscar:  \n");
					String searchName = read.nextLine();
					nTeam.readOne(searchName);
					nSoccer.readAll(); /*PRECISA SER REVISADO !!!!!!!!*/
				}
				
				else if (registration == 5 ) {
					String searchDate, searchLocal,searchTime;
					
					System.out.println("Digite as seguintes informações para a busca:  \n");
					
					System.out.println("-> Data da partida:\n");
					searchDate = read.nextLine();
					
					System.out.println("->Local da partida: \n");
					searchLocal = read.nextLine();
					
					System.out.println("->Horário da partida: \n");
					searchTime = read.nextLine();
					
					nMatch.personalitySearch(searchDate, searchLocal, searchTime);
					
				}
				
				else System.out.println(" Digite uma opção válida ! \n ");
				
			break;
/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
			
			case 3: /*Operação = Listar*/
				
				if (registration == 1) {nSoccer.readAll();
				
				}
				
				else if (registration == 2) {nTechnician.readAll();
				
				}

				else if (registration == 3 ) {nReferee.readAll();
				
				}

				else if (registration == 4 ) {nTeam.readAll();
				
				}
				
				else if (registration == 5 ) {nMatch.showEvery();
				
				}
				
				else System.out.println(" Digite uma opção válida ! \n ");
				
			break;
/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
			
			case 4: /*Operação = Atualizar*/
				
				boolean confirm = false;
				int update = 0;
				
				if (registration == 1) {
					
					System.out.println("\n");
					System.out.println("1 -Atualizar nome do jogador\n ");
					System.out.println("2- Atualizar nacionalidade\n");
					System.out.println("3- Atualizar quantidade de cartões amerelos\n");
					System.out.println("4- Atualizar quantidade de cartões vermelhos\n");
					System.out.println("5- Atualizar quantidade de gols\n");
					
					update = read.nextInt();
					
					System.out.println("Digite o nome do jogador que deseja corrigir: \n");
					String searchName = read.nextLine();
					
					if (update == 1) {
						
						System.out.println("Digite o nome CORRETO do jogador que deseja corrigir: \n");
						String newName = read.nextLine();
						
						confirm = nSoccer.updateName( searchName, newName);
					
					}
					
					else if (update == 2) {
						
						System.out.println("Digite o nome CORRETO do país do jogador que deseja corrigir: \n");
						String newNationality = read.nextLine();
						
						confirm = nSoccer.updateNationality(searchName,newNationality);
					
					}
					
					else if (update == 3) {
						
						System.out.println("Digite a quatidade CORRETA de cartões amarelos do jogador que deseja corrigir: \n");
						int newYellowCard = read.nextInt();
						confirm = nSoccer.updateYellowCard(searchName, newYellowCard);
					
					}
					
					else if (update == 4) {
						
						System.out.println("Digite a quatidade CORRETA de cartões vermelhos do jogador que deseja corrigir: \n");
						int newRedCard = read.nextInt();
						confirm = nSoccer.updateRedCard(searchName, newRedCard);
					
					}
					
					else if (update == 5) {
						
						System.out.println("Digite a quatidade CORRETA de gols do jogador que deseja corrigir: \n");
						int newPoints = read.nextInt();
						confirm = nSoccer.upadatePoints(searchName, newPoints);
					}
					
					else System.out.println(" Digite uma opção válida ! \n ");
					
				}
				
				else if (registration == 2) {
					
					System.out.println("\n");
					System.out.println("1 -Atualizar nome do técnico\n ");
					System.out.println("2- Atualizar nacionalidade\n");
					System.out.println("3- Atualizar quantidade de  cartões amerelos\n");
					System.out.println("4- Atualizar quantidade de cartões vermelhos\n");
					System.out.println("5- Atualizar quantidade de gols\n");
					
					update = read.nextInt();
					
					System.out.println("Digite o nome do técnico que deseja corrigir: \n");
					String searchName = read.nextLine();
					
					if (update == 1) {
					
						System.out.println("Digite o nome CORRETO do técnico que deseja corrigir: \n");
						String newName = read.nextLine();
					
						confirm = nTechnician.updateName( searchName, newName);
					}
	
					else if (update == 2 ) {
						
						System.out.println("Digite o nome CORRETO do país do técnico que deseja corrigir: \n");
						String newNationality = read.nextLine();
						
						confirm = nTechnician.updateNationality( searchName, newNationality);
					
					}
	
					else if (update == 3 ) {
						
						System.out.println("Digite a quatidade CORRETA de cartões amarelos do técnico que deseja corrigir: \n");
						int newYellowCard = read.nextInt();
						confirm = nTechnician.updateYellowCard(searchName, newYellowCard);
					
					}
					
					else if (registration == 4 ) {
						
						System.out.println("Digite a quatidade CORRETA de cartões vermelhos do jogador que deseja corrigir: \n");
						int newRedCard = read.nextInt();
						confirm = nTechnician.updateRedCard(searchName, newRedCard);
					
					}
					
					else if (registration == 5 ) {
					
					System.out.println("Digite a seleção CORRETA do técnico que deseja corrigir: \n");
					String newTeamKey = read.nextLine();
					confirm = nTechnician.updateTeamKey(searchName,newTeamKey);
					
					}
					
					else System.out.println(" Digite uma opção válida ! \n ");
				}	
				
				else if (registration == 3) {
					
					System.out.println("1 -Atualizar nome do árbitro\n ");
					System.out.println("2- Atualizar nacionalidade\n");
					
					update = read.nextInt();
					
					System.out.println("Digite o nome do árbitro que deseja corrigir: \n");
					String searchName = read.nextLine();
					
					if (update == 1) {
					
						
					
						System.out.println("Digite o nome CORRETO do árbitro que deseja corrigir: \n");
						String newName = read.nextLine();
					
						confirm = nReferee.updateName( searchName, newName);
					
					}
					
					else if (update == 2 ) {
						
						System.out.println(" Digite o nome CORRETO do país do árbitro que deseja corrigir: \n" );
						String newNationality = read.nextLine();
						
						confirm = nReferee.updateNationality( searchName, newNationality);
						
					}
					
					else System.out.println(" Digite uma opção válida ! \n ");
				}	
				
				else if (registration == 4) {
					
					System.out.println("1 -Atualizar nome do seleção\n ");
					System.out.println("2- Atualizar do técnico da seleção\n");
					
					update = read.nextInt();
					
					System.out.println("Digite o nome da seleção que deseja corrigir: \n");
					String searchName = read.nextLine();
						
					if (update == 1) {
						
						System.out.println("Digite o nome CORRETO da seleção que deseja corrigir: \n");
						String newName = read.nextLine();
						
						confirm = nTeam.updateName( searchName, newName);
					
					}
	
					else if (update == 2 ) nTeam.updatetechnician();
					
					else System.out.println(" Digite uma opção válida ! \n ");
				}
				
				else if (registration == 5) {
					
					String searchDate, searchLocal,searchTime;
					
					System.out.println("Digite as seguintes informações para a busca:  \n");
					
					System.out.println("-> Data da partida:\n");
					searchDate = read.nextLine();
					
					System.out.println("->Local da partida: \n");
					searchLocal = read.nextLine();
					
					System.out.println("->Horário da partida: \n");
					searchTime = read.nextLine();
					
					nMatch.deleteMatch(searchDate, searchLocal, searchTime);
					
					/*-------------------------------------------------------------------------------------------------------------------- */
					System.out.println("Digite a data da partida: \n");
					date = read.nextLine();
					
					
					System.out.println("Digite o local da partida: \n");
					local = read.nextLine();
					
					System.out.println("Digite o horário da partida:\n -> 7:00 \n -> 10:00 hrs \n -> 13;00 hrs \n -> 16:00 \n");
					time = read.nextLine();
					
					System.out.println("Digite o time 1: \n");
					teamOne = read.nextLine();
					
					System.out.println("Digite o time 2: \n");
					teamTwo = read.nextLine();
					
					System.out.println("Digite o nº de gols do time" + teamOne + ":" + "\n");
					golsT1 = read.nextInt();
					
					System.out.println("Digite o nº de gols do time" + teamTwo + ":" + "\n");
					golsT2 = read.nextInt();
					
					nMatch.registrationMatch();
					
					
					
				}
				
					else System.out.println ("Digite uma opção válida !!!");
				
				
				if (confirm = true) {
					System.out.println("Atualização feita com sucesso !");
					}
				else System.out.println("Não foi possivel localizar essa informação !");
			
				
			break;
				
/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
				
			case 5: /*Operação = Deletar*/
				
				if (registration == 1) {
					
					System.out.println(" Digite o nome do jogador que deseja deletar: ");
					String deleteName = read.nextLine();
					
					confirm = nSoccer.delete(deleteName);
				}
				
				else if (registration == 2) {
					
					System.out.println(" Digite o nome do técnico que deseja deletar: ");
					String deleteName = read.nextLine();
					
					 confirm = nTechnician.delete(deleteName);
				}

				else if (registration == 3 ) {
					
					System.out.println(" Digite o nome do árbitro que deseja deletar: ");
					String deleteName = read.nextLine();
			
					confirm = nReferee.delete(deleteName);
				}

				else if (registration == 4 ) {
					
					System.out.println(" Digite o nome da seleção que deseja deletar: \n");
					String deleteName = read.nextLine();
					
					System.out.println(" Digite o grupo da seleção: \n");
					String dGroup = read.nextLine();
					
					confirm = nTeam.delete(deleteName);
					GsChampions.deleteOfGroup(deleteName, dGroup);
				
				}
				
				else if (registration == 5 ) {
					
					String searchDate, searchLocal,searchTime;
					
					System.out.println("Digite as seguintes informações para a busca:  \n");
					
					System.out.println("-> Data da partida:\n");
					searchDate = read.nextLine();
					
					System.out.println("->Local da partida: \n");
					searchLocal = read.nextLine();
					
					System.out.println("->Horário da partida: \n");
					searchTime = read.nextLine();
					
					nMatch.deleteMatch(searchDate, searchLocal, searchTime);
				
				}
				
				else System.out.println("Digite uma opção válida ");
				
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
