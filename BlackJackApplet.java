import java.awt.*;
import java.applet.*;

public class BlackJackApplet extends Applet {

	private Deck deck;
	private Deck deck2;
	private Hand hand;
	private Card initialCard;
	private Player player;

	 public void init() {
	 	this.deck = new Deck();
	 	deck.shuffle();
	 	this.player = new Player();
	 	player.getTopCard();

	 }

	 public void paint(Graphics g) {
	 	deck.deal(g);
	 	deck.valueOfHand(g);



	 	// deck.draw(g, 50);
	 	// deck2.draw(g, 375);
	 	// System.out.println(this.valueHand);
	 	// g.setFont(new Font("Times", Font.BOLD, 50));
	 	// g.drawString("" + this.valueHand, 600, 100);
	 }
}