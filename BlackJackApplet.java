import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;

public class BlackJackApplet extends Applet implements ActionListener {

	private Deck deck;
	private Deck deck2;
	private Hand hand;
	private Card initialCard;
	private Player player;
	private JLabel label;
	private JButton hit, stay, reset;
	private Card[] cards;

	 public void init() {

	 	String title = "Hit";
	 	hit = new JButton(title);
	 	hit.setActionCommand(title);
	 	hit.addActionListener(this);
	 	this.add(hit);

	 	title = "Stay";
	 	stay = new JButton(title);
	 	stay.setActionCommand(title);
	 	stay.addActionListener(this);
	 	this.add(stay);

	 	this.deck = new Deck();
	 	deck.shuffle();
	 	this.player = new Player();
	 	player.getTopCard();

	 }

	 public void paint(Graphics g) {
	 	super.paint(g);
	 	deck.deal(g);
	 	deck.valueOfHand(g);



	 	// deck.draw(g, 50);
	 	// deck2.draw(g, 375);
	 	// System.out.println(this.valueHand);
	 	// g.setFont(new Font("Times", Font.BOLD, 50));
	 	// g.drawString("" + this.valueHand, 600, 100);
	 }

	 public void actionPerformed(ActionEvent ae) {

	 	int offSetPlayer = 525;

	 	if ("Hit".equals(ae.getActionCommand())) {
	 		player.dealCard(deck, false);
	 	} else if ("Stay".equals(ae.getActionCommand())) {
	 		
	 	}
	 }
}