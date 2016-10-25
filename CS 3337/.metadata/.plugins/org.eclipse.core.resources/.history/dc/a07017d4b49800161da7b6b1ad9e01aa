package blackjack;

import javafx.scene.image.Image;

public class Card {
	private int rank;
	private String suit;
	
	public Card(){}
	
	public Card(int rank, String suit){
		this.rank = rank;
		this.suit = suit;
	}
	
	public int getRank(){
		return rank;
	}
	
	public String getSuit(){
		return suit;
	}
	
	//changes the number rank value to a face card's as a string
	public String displayFaceCard(){
		if(rank == 11)
			return "Jack";
		else if(rank == 12)
			return "Queen";
		else if(rank == 13)
			return "King";
		else
			return "Ace";
	}
	
	//gets blackjack value
	public int getValue(){
		int value;
		
		if(rank <= 10)
			value = rank;
		else if(rank <= 13 && rank > 10)
			value = 10;
		else
			value = 11;
		return value;
	}
	
	//gets image of card. card(0, "0") gives card back
	public Image getImage(){
		Image card = new Image("blackjack/resource/ace4.png");
		String file = "blackjack/resource/";
		
		switch(rank){
		case 0:
			card = new Image(file +"cardback.png");
			break;
		case 2:
			file += "two";
			break;
		case 3:
			file += "three";
			break;
		case 4:
			file += "four";
			break;
		case 5:
			file += "five";
			break;
		case 6:
			file += "six";
			break;
		case 7:
			file += "seven";
			break;
		case 8:
			file += "eight";
			break;
		case 9:
			file += "nine";
			break;
		case 10:
			file += "ten";
			break;
		case 11:
			file += "jack";
			break;
		case 12:
			file += "queen";
			break;
		case 13:
			file += "king";
			break;
		case 14:
			file += "ace";
			break;
		}
		
		switch(suit){
		case "0":
			break;
		case " of Diamonds":
			file += "1.png";
			break;
		case " of Clubs":
			file += "2.png";
			break;
		case " of Hearts":
			file += "3.png";
			break;
		case " of Spades":
			file += "4.png";
			break;
		}
		
		card = new Image(file);
		
		return card;
	}
	
	public String toString(){
		if(rank > 10)
			return (displayFaceCard() + suit);
		else
			return (rank + suit);
	}
}
