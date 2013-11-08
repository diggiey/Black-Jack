import java.util.Random;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Deck {

	private Card[] cards;

	public Deck() {

		int index = 0;

		this.cards = new Card[52];
		String suitType = "Hearts";
		String faceCard = "Jack";

		for (int suit=1; suit<=4; suit++) {
			if (suit == 1) {
				suitType = "Hearts";
			} else if (suit == 2) {
				suitType = "Spades";
			} else if (suit == 3) {
				suitType = "Diamonds";
			} else if (suit == 4) {
				suitType = "Clubs";
			}
			for (int cardNumber=1; cardNumber<=13; cardNumber++) {
				Card cardType = new Card(suitType, cardNumber);
				this.cards[index] = cardType;	
				index++;
			}
		}
	}

	public static void main(String[] args) {
		Deck d = new Deck();
		// d.shuffle();
		// d.printDeck();
	}

	public void shuffle() {
		Random generator = new Random();
		for (int c=51; c >= 0; c--) {
			int random = generator.nextInt(c + 1);
			Card cardTemp = this.cards[c];
			this.cards[c] = this.cards[random];
			this.cards[random] = cardTemp;
		}
	}

	public void printDeck() {
		for (int i=0; i<this.cards.length; i++) {
			if (this.cards[i].getNumber() < 11 && this.cards[i].getNumber() > 1) {
				System.out.println(this.cards[i].getNumber() + " of " + this.cards[i].getSuit());	
			} else if (this.cards[i].getNumber() == 11) {
				System.out.println("Jack of " + this.cards[i].getSuit());
			} else if (this.cards[i].getNumber() == 12) {
				System.out.println("Queen of " + this.cards[i].getSuit());
			} else if (this.cards[i].getNumber() == 13) {
				System.out.println("King of " + this.cards[i].getSuit());
			} else if (this.cards[i].getNumber() == 1) {
				System.out.println("Ace of " + this.cards[i].getSuit());
			}
		}
	}

	public void draw(Graphics g, int y) {
		int offSet = 50;
		for (int i=0; i<this.cards.length; i++) {
			this.cards[i].draw(g, this.cards[i].toString(), new Rectangle(offSet, y, 200, 300));
			offSet += 25;
		}
	}

}