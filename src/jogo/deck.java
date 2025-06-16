package jogo;

import java.util.Random;

public class deck {

	card[] cardArray = new card[52];
	
	deck(){ //constructor
		int suits = 4;
		int cardType = 13;
		int cardCount = 0;
		for(int i = 1; i <= suits; i++)
			for(int j = 1; j <= cardType; j++){
				cardArray[cardCount] = new card(i,j);
				cardCount++;
			}
	 }
	
	//metodo para imprimir o deck completo de cartas
	public void print(){
		for(int i = 0; i < cardArray.length; i++)
			System.out.println(cardArray[i]);
	}
	
	//metodo para embaralhar o deck
	public void embaralhar() {
        Random random = new Random();//randam do java.util para randomizar um numero como indice para adicionar a proxima carta
        for (int i = cardArray.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);//gera um numero aleatorio e posiciona o item nesse indice entre 0-51
            card temp = cardArray[i];
            cardArray[i] = cardArray[j];
            cardArray[j] = temp;
        }
    }
	
    
    //metodo para puxar uma carta do deck
	public card getCard() {
		card temp = cardArray[51];  // Pega o último valor (índice 51)
		// Desloca todos os valores do vetor uma posição para a frente
	    for (int i = 50; i >= 0; i--) {
	        cardArray[i + 1] = cardArray[i];
	    }

	    // Coloca o último valor no índice 0
	    cardArray[0] = temp;

	    return temp;
	}
	
}
