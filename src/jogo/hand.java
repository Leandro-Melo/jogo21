package jogo;

import java.util.ArrayList;
import java.util.Scanner;

public class hand {

	private ArrayList <card> cardHandUsuario = new ArrayList<>() ;
	private ArrayList <card> cardHandBanca = new ArrayList<>() ;
	private int pointsUsuario;
	private int pointsBanca = 0;
	String resposta;
	
	deck d = new deck();
	
	Scanner sc = new Scanner(System.in);
	
	public hand() {
		
	}
	//mão da banca
	int aux =0;//variavel auxiliar para contabilizar quantas cartas puxadas em cada mão
	//metodo para iniciar o jogo
	public void jogo() {
		d.embaralhar();//embaralha o deck
		//adiciona uma carta ao array e roda o do adicionando +1 carta
		cardHandBanca.add(d.getCard());
		do {
			cardHandBanca.add(d.getCard());
			if(cardHandBanca.size() > 2) {//verifica se a carta puxada é alguma fora as 2 iniciais
				card temp = null;
				for(card c : cardHandBanca) {
					System.out.println(c);
					temp = c;
				}
				pointsBanca += temp.getPoints(temp.name);//soma os pontos da ultima carta puxada
				
				if(pointsBanca>21) {//verifica se os passaram de 21
					if(temp.name.equalsIgnoreCase("ace")) {//muda o valar do ace de 11 para 1 caso tenha algum na mão
						pointsBanca -= 10;
					}
				}
			}else {//se for as cartas iniciais vão somar todos os pontos das cartas
				for(card c : cardHandBanca) {
					pointsBanca += c.getPoints(c.name);
					System.out.println(c);
				}
			}
			
			System.out.println("A banca tem " + pointsBanca + " pontos!\n");//mostra os pontos da banca
			if(aux<3) {
				aux++;
			}else {break;}//sai do loop caso atingir o maximo de cartas
		}while(pointsBanca < 16);//loop enquanto os pontos não atingirem 16 
		
//--------------------------------------------------------/////--------------------------------------------------------	
		//mão do usuário
		aux =0;//reseta a variavel auxiliar
		//adiciona uma carta ao array e roda o do adicionando +1 carta
		cardHandUsuario.add(d.getCard());
		do {
			cardHandUsuario.add(d.getCard());
			if(cardHandUsuario.size() > 2) {//verifica se a carta puxada é alguma fora as 2 iniciais
				card temp = null;
				for(card c : cardHandUsuario) {
					System.out.println(c);
					temp = c;
				}
				pointsUsuario += temp.getPoints(temp.name);//soma os pontos da ultima carta puxada
				
				if(pointsUsuario>21) {//verifica se os passaram de 21
					if(temp.name.equalsIgnoreCase("ace")) {//muda o valar do ace de 11 para 1 caso tenha algum na mão
						pointsUsuario -= 10;
					}
				}
				
			}else {//se for as cartas iniciais vão somar todos os pontos das cartas
				for(card c : cardHandUsuario) {
					pointsUsuario += c.getPoints(c.name);
					System.out.println(c);
				}
			}
			
			
			//verifica se não foi atingido o número maximo de cartas foi atingido ou chegou ao 21
			if(aux<3 && pointsUsuario < 21) {
				System.out.println("Você tem " + pointsUsuario + " pontos, quer pegar outra carta?[sim/não]");//se não acabou o jogo é perguntado se quer puxar outra carta ou não
				resposta = sc.nextLine();
				aux++;
			}else {//sai do loop caso o jogo tenha acabado(foi atingido o número maximo de cartas foi atingido ou chegou ao 21)
				System.out.print("\n");
				break;
				}
			System.out.print("\n");
			
		}while(resposta.equalsIgnoreCase("sim"));//loop enquando quiser puxar outra carta
		
		//mostra quantos pontos o usuario e banca fizeram
		System.out.println("Você tem " + pointsUsuario + " pontos e a banca tem " + pointsBanca + " pontos");
		
		//verifica as condições para vitoria do usuario
		if((pointsUsuario > pointsBanca && pointsUsuario < 22) || (pointsUsuario == 21 && (pointsBanca < 21 || pointsBanca > 21)) || (pointsUsuario < pointsBanca && pointsBanca > 21)) {
			System.out.println("Parabéns você venceu!!!!!!");
		}
		
		//verifica as condições para vitoria da banca
		else if((pointsUsuario > pointsBanca && pointsBanca < 22) || (pointsBanca == 21 && pointsUsuario < 21 || pointsUsuario > 21) || (pointsBanca < pointsUsuario && pointsUsuario > 21)) {
			System.out.println("A banca venceu, você perdeu");
		}
		
		//verifica se os pontos e a quantidade de cartas são iguais para um empate
		else if(pointsBanca == pointsUsuario && cardHandBanca.size() == cardHandUsuario.size()) {
			System.out.println("Empatou!!!");
		}
		
		//se os pontos são iguais mas a quantidade de cartas não mostra o vencedor por meio de quem atingiu os pontos com menos cartas
		else {
			System.out.println(cardHandBanca.size() > cardHandUsuario.size() ? "Parabéns você venceu por " 
					+ (cardHandBanca.size() - cardHandUsuario.size()) + " cartas!!!!!!" : "A banca venceu, você perdeu por " 
					+ (cardHandUsuario.size() - cardHandBanca.size() + " cartas"));
		}
	}
	
	
}
