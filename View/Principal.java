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
package View;
import java.util.Scanner;
import DAO.DAOReferee;
import DAO.DAOSoccer;
import DAO.DAOTeam;
import DAO.DAOTechnician;
public class Principal {
	
	public static void main(String[] args) {
		int operation = 0, registration = 0, endProgram = 0, update = 0; /* Registra a escolha do tipo de operacao que o usuario quer realizar */
		
		
		/* DECLARAÇÃO DOS ATRIBUTOS  */
		int redCard, yellowCard, points; 
		String name, nationality;
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		
		/* ------------------------------------------------------
		 
		 
		  								FORMULÁRIO
		  								
		 *--------------------------------------------------------*/

		System.out.println("Digite o nome da Selecao:");
		name = read.nextLine();
		
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
		
	
		
		DAOSoccer nSoccer = new DAOSoccer(name, nationality, yellowCard, redCard, points); 
		
		DAOTechnician nTechnician = new DAOTechnician();
		DAOTeam nTeam = new DAOTeam(); 
		DAOReferee nReferee = new DAOReferee(); 
		
		
		do {
			System.out.println("--------------------\n");
			System.out.println("\t Menu \t \n");
			System.out.println("--------------------\n");
			System.out.println(" 1 - Cadastrar\n"
							 + " 2 - Buscar por uma categoria\n"
							 + " 3 - Lista todos da Categoria \n"
							 + " 4 - Atualizar Informacoes \n"
							 + " 5 - Deletar \n");
			operation = read.nextInt();
			
			switch (operation) {
			
			case 1: 
				System.out.println("Qual tipo de Cadastro deseja realizar?\n ");
				System.out.println("1- Jogador\n");
				System.out.println("2- Técnico\n");
				System.out.println("3- Arbitro\n");
				System.out.println("4- Selecao\n");
			
				registration = read.nextInt();
				
				if (registration == 1) nSoccer.create();
				
				else if (registration == 2) nTechnician.create();

				else if (registration == 3 ) nReferee.create();

				else if (registration == 4 ) {
					nTeam.create();
					String aux[] = new String[26];
					aux = nSoccer.ListSoccer("Brasil");
					
				}
				
				
				else System.out.println("Digite uma opção válida ");
								
				break;	
				
			case 2: 
				System.out.println("Qual tipo de Operacao deseja Listar?\n ");
				System.out.println("1- Listar Jogador\n");
				System.out.println("2- Listar Técnico\n");
				System.out.println("3- Listar Arbitro\n");
				System.out.println("4- Listar Selecao\n");
				registration = read.nextInt(); /* Lista o tipo escolhido pelo usuario */
				
				if (registration == 1) {
					String nameSearch;
					System.out.println("Digite o nome do Jogador que deseja procurar:\n");
					nameSearch = read.nextLine();
					nSoccer.readOne(nameSearch);
				}
				
				else if (registration == 2) nTechnician.readOne();

				else if (registration == 3 ) nReferee.readOne();

				else if (registration == 4 ) {
					nTeam.readOne();
					nSoccer.readAll();
				}
				
				else System.out.println("Digite uma opçcao valida ");
				
				break;
				
			case 3:
				System.out.println("Qual tipo de Operacao deseja Atualizar?\n ");
				System.out.println("2- Listar todos os técnicos\n");
				System.out.println("3- Listar todos os arbitros\n");
				System.out.println("4- Listar todos as selecoes\n");
				registration = read.nextInt(); /* Lista todos as categorias */
				
				
				if (registration == 2) nTechnician.readAll();

				else if (registration == 3 ) nReferee.readAll();

				else if (registration == 4 ) nTeam.readAll();
				
				else System.out.println("Digite uma opçcao valida ");
				
				break;
				
			case 4: 
				
				System.out.println("Qual tipo de Operacao deseja atualizar?\n ");
				System.out.println("1- Atualizar Informacoes do Jogador\n");
				System.out.println("2- Atualizar Informacoes do Técnico\n");
				System.out.println("3- Atualizar Informacoes do  Arbitro\n");
				System.out.println("4- Atualizar Informacoes da Selecao\n");
				registration = read.nextInt(); /* Deleta o tipo escolhido pelo usuario */
				
				if (registration == 1) {
					System.out.println("\n");
					System.out.println("1 -Atualizar Nome do jogador?\n ");
					System.out.println("2- Atualizar Nacionalidade\n");
					System.out.println("3- Atualizar Quantidade Cartao Amerelo\n");
					System.out.println("4- Atualizar Quantidade Cartao Vermelho\n");
					System.out.println("5- Atualizar Quantidade de Gols\n");
					update = read.nextInt();
					
					if (update == 1) {
						
						System.out.println("Digite o nome do jogador que deseja antigo nome:\n");
						String seachName = read.nextLine();
						System.out.println("Digite o novo nome:\n");
						String updaterName = read.nextLine();
						
						
						if (nSoccer.updateName(name, updaterName )) {
							System.out.println("O nome " + seachName + " foi atualizado para " + updaterName + "\n");
						}
						
						else System.out.println("O nome " + seachName + "não foi encontrado:\n");
							
					}
					
					else if (update == 2) { 
						
						String searcSoccer;
						
						System.out.println("Digite do jogador que deseja alterar a nacionalidade:");
						searcSoccer = read.nextLine();
						
						System.out.println("Digite da nacionalidade do jogadoe que deseja alterar:\n");
						String updaterNationality = read.nextLine();
						
						//Lembrando o que devemos atualizar tanbém o time de acordo com a alteração da nacionalidade
						if (nSoccer.updateName(searcSoccer, updaterNationality )) {
							System.out.println("O nome " + searcSoccer + " foi atualizado para " + updaterNationality + "\n");
						}
						
						else System.out.println("O nome " + searcSoccer + "não foi encontrado:\n");

					}
					
					else if (update == 3) { 
						
						System.out.println("Digite o nome do jogador que deseja buscar:");
						String searchName = read.next();
						System.out.println("Digite a quantidade de cartoes amarelo que o jogador recebeu:");
						int updateYellowCard = read.nextInt();
						
						if (nSoccer.updateYellowCard(searchName, updateYellowCard)) {
							System.out.println("O cartão do jogador " + searchName + " foi atualizado corretamente\n");
						}
						
						else System.out.println("O nome " + searchName + "não foi encontrado, não houve alterações em cartões:\n");
						
					}
					
					else if (update == 4) {
						
						System.out.println("Digite o nome do jogador que deseja buscar:");
						String searchName = read.next();
						System.out.println("Digite a quantidade de cartoes vermelhos que o jogador recebeu:");
						int updateredCard = read.nextInt();
						
						if(nSoccer.updateRedCard(searchName,updateredCard)) {
							
							System.out.println("O cartão do jogador " + searchName + " foi atualizado corretamente\n");

						}
						else {
							
						System.out.println("O cartão do jogador " + searchName + " foi atualizado corretamente\n");

						}
					}
					
					else if (update == 5) {
					
						System.out.println("Digite o nome do jogador que deseja buscar:");
						String searchName = read.next();
						System.out.println("Digite a quantidade de gols do jogador:");
						int updaterPoints= read.nextInt();
						
						nSoccer.upadatePoints(searchName, updaterPoints );
						
					
					
					}

				if (registration == 2) {
					
					System.out.println("\n");
					System.out.println("1 -Atualizar Nome do Tecnico?\n ");
					System.out.println("2- Atualizar Nacionalidade\n");
					System.out.println("3- Atualizar Quantidade Cartao Amerelo\n");
					System.out.println("4- Atualizar Quantidade Cartao Vermelho\n");
					System.out.println("5- Atualizar Quantidade de Gols\n");
					
					if (registration == 1) nTechnician.updateName();
	
					else if (registration == 2 ) nTechnician.updateNationality();
	
					else if (registration == 3 ) nTechnician.updateYellowCard();
					
					else if (registration == 4 ) nTechnician.updateRedCard();
					
					else if (registration == 5 ) nTechnician.updateTeamKey();
					
					else System.out.println("Digite uma opçcao valida ");
				}	
				
				if (registration == 3) {
					System.out.println("1 -Atualizar Nome do arbitro?\n ");
					System.out.println("2- Atualizar nacionalidade\n");
					registration = read.nextInt();
					
					if (registration == 1) nReferee.updateName();
	
					else if (registration == 2 ) nReferee.updateNationality();
				}	
				
				if (registration == 4) {
					System.out.println("1 -Atualizar nome do selecao?\n ");
					System.out.println("2- Atualizar do tecnico da selecao\n");
					registration = read.nextInt();
					
					if (registration == 1) nTeam.updateName();
	
					else if (registration == 2 ) nTeam.updatetechnician();
				}	
			}
				break;
				
			case 5: 
				System.out.println("Qual tipo de Operacao deseja Deletar?\n");
				System.out.println("1- Deletar Jogador\n");
				System.out.println("2- Deletar Técnico\n");
				System.out.println("3- Deletar Arbitro\n");
				System.out.println("4- Deletar Selecao\n");
				registration = read.nextInt(); /* Deleta o tipo escolhido pelo usuario */
				
				if (registration == 1) {
					
					System.out.println("Digite o nome do jogador que deseja deletar:\n");
					String deleteName = read.nextLine();
					
					if (nSoccer.delete(deleteName)) System.out.println("O nome " + deleteName + " foi deletado");
					else System.out.println("O nome " + deleteName + "não foi encontrado");
						
				}
					
				
				else if (registration == 2) nTechnician.delete();

				else if (registration == 3 ) nReferee.delete();

				else if (registration == 4 ) nTeam.delete();
				
				else System.out.println("Digite uma opçcao valida ");
				
				break;
				
			default: 
				System.out.println("Opcao Invalida?\n ");
				
		System.out.println("Deseja continuar no programa ?");
		System.out.println("0 - Sim \t 1 - Nao \n ");
		endProgram = read.nextInt();
	}
		} while(endProgram == 0);
		
	}
}
		

		
