import java.awt.*;
import java.applet.*;

public class BlackJackApplet extends Applet {

	private Deck deck;
	private Deck deck2;

	 public void init() {
	 	this.deck = new Deck();
	 	this.deck2 = new Deck();

	 	deck2.shuffle();
	 }

	 public void paint(Graphics g) {
	 	deck.draw(g, 50);
	 	deck2.draw(g, 375);
	 }
}