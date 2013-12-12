import java.util.Random;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Deck {

	private Card[] cards;
	private int cardsDealt;
	private Card[] cardPaint;
	private int timesPlayerHit;
	private Card[] cardPaintDealer;
	private int finishDealerNumber;

	public Deck() {

		int index = 0;
		int value = 0;

		this.cardPaint = new Card[11];
		this.cardPaintDealer = new Card[11];

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
				if (cardNumber > 10) {
					value = 10;
				} else if (cardNumber > 1 && cardNumber < 11) {
					value = cardNumber;
				} else if (cardNumber == 1) {
					value = 11;
				}

				Card cardType = new Card(suitType, cardNumber, value);
				this.cards[index] = cardType;	
				index++;
			}
		}
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

	public void deal() {
		int offSetPlayer = 25;

		for (int i=0; i<2; i++) {
			if (i<2) {
				dealCard(i);
				offSetPlayer += 250;	
			}
		}
	}

	public void dealDealer(Graphics g) {
		int offSetDealer = 25;

		for (int i=0; i<2; i++) {
			if (i<2) {
				dealCardDealer(i);
				offSetDealer += 250;
			}
		}
	}

	public int valueOfHand() {
		int valueTest = 0;

		for (int test=0; test<cardPaint.length; test++) {
			if (cardPaint[test] == cards[test]) {
				valueTest += this.cards[test].getValue();
				if (valueTest > 21) {
					if (cardPaint[test].getValue() == 11) {
						valueTest -= 10;
					}
				}
			}
		}

		return valueTest;
	}

	public int valueOfDealer() {
		int valueTest = 0;

		for (int test=0; test<cardPaintDealer.length; test++) {
			if (cardPaintDealer[test] == cards[test + 12]) {
				valueTest += this.cards[test + 12].getValue();
				if (valueTest > 21) {
					if (cardPaintDealer[test].getValue() == 11) {
						valueTest -= 10;
					}
				}
			}
		}

		return valueTest;
	}

	public void valueOfHand(Graphics g) {
		int valueTest = 0;

		for (int test=0; test<cardPaint.length; test++) {
			if (cardPaint[test] == cards[test]) {
				valueTest += this.cards[test].getValue();
				if (valueTest > 21) {
					if (cardPaint[test].getValue() == 11) {
						valueTest -= 10;
					}
				}
			}
		}

		if (valueTest>21) {
			g.drawString("Value of hand:" + valueTest + " You busted!", 25, 400);
		} else {
			g.drawString("Value of hand:" + valueTest, 25, 400);
		}
	}

	public int whoWon() {
		if (valueOfDealer() <= 21) {
			if (valueOfHand() <= 21) {
				if (valueOfHand() > valueOfDealer()) {
					return 0;
				} else if (valueOfHand() < valueOfDealer()) {
					return 1;
				} else if (valueOfHand() == valueOfDealer()) {
					return 2;
				}
			} else {
				return 1;
			}
		} else {
			return 0;
		}
		return 0;
	}

	public void whoWon(Graphics g) {
		if (whoWon() == 0) {
				g.drawString("You won!", 300, 400);
			} else if (whoWon() == 1) {
				g.drawString("You lost!", 300, 400);
			} else if (whoWon() == 2) {
				g.drawString("You tied!", 300, 400);
			}
	}

	public void draw(Graphics g, int y) {
		int offSet = 50;
		for (int i=0; i<this.cards.length; i++) {
			this.cards[i].draw(g, this.cards[i].toString(), new Rectangle(offSet, y, 200, 300));
			offSet += 25;
		}
	}

	public void hitCard(int cardsInHand) {
		int offSetPlayer = 525;
		timesPlayerHit++;
		this.cardPaint[cardsInHand+1] = this.cards[cardsInHand+1];
	}

	public Card dealCard(int i) {
		cardPaint[i] = cards[i];
		return cardPaint[i];
	}

	public Card dealCardDealer(int i) {
		cardPaintDealer[i] = cards[i + 12];
		return cardPaintDealer[i];
	}

	public void paintHand(Graphics g) {

		int offSetPlayer = 25;

		for (int i=0; i<cardPaint.length; i++) {
			if (cardPaint[i] == cards[i]) {
				cardPaint[i].draw(g, cardPaint[i].toString(), new Rectangle(offSetPlayer, 50, 200, 300));
				offSetPlayer += 250;
			}
		}
	}

	public void paintHandDealer(Graphics g) {
		int offSetDealer = 25;

		for (int i=0; i<cardPaintDealer.length; i++) {
			if (cardPaintDealer[i] == cards[i+12]) {
				if (i >= 1) {
					cardPaintDealer[i].draw(g, cardPaintDealer[i].toString(), new Rectangle(offSetDealer, 450, 200, 300));
					offSetDealer += 250;
				} else {
					if (finishDealerNumber < 1) {
						cardPaintDealer[i].draw(g, "back-red", new Rectangle(offSetDealer, 450, 200, 300));
						offSetDealer += 250;
					} else {
						cardPaintDealer[i].draw(g, cardPaintDealer[i].toString(), new Rectangle(offSetDealer, 450, 200, 300));
						offSetDealer += 250;
					}
				}
			}
		}
	}

	public void finishDealer() {
		if (valueOfDealer() > 16) {
			
		} else {
			for (int i=0; valueOfDealer() < 17; i++) {
				dealCardDealer(i + 1);	
			}
		}
		finishDealerNumber++;
	}
}