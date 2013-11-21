import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Player {

	private Card[] cards;
	

	public Player() {
		this.cards = new Card[11];
	}

	public Card dealCard(Deck deck, boolean faceDown) {
		Card c = deck.dealCard();

		return c;
	}

	public int cardsDealt() {
		return 2;
	}

	public void getTopCard() {
		cardsDealt();
	}
}