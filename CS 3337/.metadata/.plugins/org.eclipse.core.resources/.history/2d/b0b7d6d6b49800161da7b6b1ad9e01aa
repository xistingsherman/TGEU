package blackjack;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainController implements Initializable{
	private Deck deck = new Deck();
	private Image cardBack = new Image("blackjack/resource/cardBack.png");
	
	//conditions for dealing, betting, hitting, and standing
	private boolean shuffled = false;
	private boolean hasDealt = false;
	private int numberOfAces = 0;
	private boolean alreadyBet = false;
	private boolean bust = false;
	
	private int money = 500;
	private int bet = 0;
	private int playerValue;
	private int computerValue;
	
	/*Labels*/
	@FXML
	private Label displayMoney;
	@FXML
	private Label value;
	
	/*Images*/
	@FXML
	private ImageView cardOne, cardTwo, cardThree, cardFour;
	/*can't make array of ImageView work for some reason*/
	@FXML
	private ImageView hit1, hit2, hit3, hit4, hit5, hit6, hit7, hit8, hit9;
	
	private int hitCounter = 0;
	
	@Override
	public void initialize(URL location, ResourceBundle resources){
		
	}


	/*Buttons*/
	public void deal(ActionEvent event){
		
		//Deals the player and computer a hand... if the hands are not dealt yet and the previous hand has not ended
		if(hasDealt == false && alreadyBet == false){
			playerValue = 0;
			computerValue = 0;
			numberOfAces = 0;
			
			//shuffles the deck at the beginning of the game or when cards run out
			if(shuffled == false || deck.getCardCounter() <= 0 ){
				deck.shuffleDeck();
				shuffled = true;
			}
			
			//draws 2 cards from the shuffled deck for the player... Value of the cards add up and checks how many aces are drawn
			cardOne.setImage(deck.deal().getImage());
			playerValue += deck.getCard().getValue();
			if(deck.getCard().getValue() == 11)
				numberOfAces += 1;
			
			cardTwo.setImage(deck.deal().getImage());
			playerValue += deck.getCard().getValue();
			if(deck.getCard().getValue() == 11)
				numberOfAces += 1;
			
			//draws 2 cards from the shuffled deck for the computer, one faced down... Value of the first card is set
			cardThree.setImage(deck.deal().getImage());
			computerValue += deck.getCard().getValue();
			
			cardFour.setImage(cardBack);
			
			//resets the hit cards from previous hand
			hit1.setImage(null);
			hit2.setImage(null);
			hit3.setImage(null);
			hit4.setImage(null);
			hit5.setImage(null);
			hit6.setImage(null);
			hit7.setImage(null);
			hit8.setImage(null);
			hit9.setImage(null);
			
			//shows current value of player's hand vs potential value of computer's hand
			value.setText(playerValue + " vs +" + computerValue);
			
			//resets conditions
			hitCounter = 0;
			bust = false;
			hasDealt = true;
		}
	}
	
	
	public void betThree(ActionEvent event){
		
		//Bets three dollars. decrements from total, then allows player to hit or stand
		if(deck.getCardCounter() > 0 && hasDealt && alreadyBet == false){
			money -= 3;
			displayMoney.setText("$" + money);
			bet = 3;
			
			alreadyBet = true;
		}
	}
	
	
	public void betTen(ActionEvent event){
		
		//Bets ten dollars. decrements from total, then allows player to hit or stand
		if(deck.getCardCounter() > 0 && hasDealt && alreadyBet == false){
			money -= 10;
			displayMoney.setText("$" + money);
			bet = 10;
			
			alreadyBet = true;
		}
	}
	
	
	public void hit(ActionEvent event){
		
		//Draws a hit card for the player... If the deck has already been shuffled, has been dealt a hand, a bet has already been placed, and there is no bust
		if(shuffled && hasDealt && alreadyBet && bust == false){
			
			//Places cards in different slots according to the amount of times hit
			switch(hitCounter){
			case 0:
				hit1.setImage(deck.deal().getImage());
				break;
			case 1:
				hit2.setImage(deck.deal().getImage());
				break;
			case 2:
				hit3.setImage(deck.deal().getImage());
				break;
			case 3:
				hit4.setImage(deck.deal().getImage());
				break;
			case 4:
				hit5.setImage(deck.deal().getImage());
				break;
			case 5:
				hit6.setImage(deck.deal().getImage());
				break;
			case 6:
				hit7.setImage(deck.deal().getImage());
				break;
			case 7:
				hit8.setImage(deck.deal().getImage());
				break;
			case 8:
				hit9.setImage(deck.deal().getImage());
				break;
			}
			if(deck.getCard().getValue() == 11)
				numberOfAces += 1;
			
			hitCounter += 1;
			
			playerValue += deck.getCard().getValue();
			
			
			//After adding all points from hits... Checks if player has any aces, then changes value from 11 to 1 if resulting in bust
			if(numberOfAces >= 1 && playerValue > 21){
				playerValue -= 10;
				numberOfAces -= 1;
			}
			
			//Checks if player has busted... Resets conditions to deal a new hand
			if(playerValue > 21){
				cardFour.setImage(deck.deal().getImage());
				computerValue += deck.getCard().getValue();
				value.setText(playerValue + " BUST! vs " + computerValue);
				bust = true;
				hasDealt = false;
				alreadyBet = false;
			}else
			value.setText(playerValue + " vs +" + computerValue);
		}
	}

	
	public void stand(ActionEvent event){
		
		//Flips the computer's last card if player has been dealt a hand, placed a bet, and not busted... Then checks if player has beaten computer
		if(shuffled && hasDealt && alreadyBet && bust == false){
			
			cardFour.setImage(deck.deal().getImage());
			computerValue += deck.getCard().getValue();
			
			if(playerValue == computerValue)
				money += bet;
			else if(playerValue > computerValue)
				money += (2 * bet);
			
			displayMoney.setText("$" + money);
			value.setText(playerValue + " vs " + computerValue);
			
			//Resets conditions
			bet = 0;
			hasDealt = false;
			alreadyBet = false;
		}
	}
}
