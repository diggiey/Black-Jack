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
	private JButton hit, stay, reset, bet10, bet100;
	private Card[] cards;
	private int cardsInHand;
	private int stayTest;
	private Betting betting;

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

	 	title = "Reset";
	 	reset = new JButton(title);
	 	reset.setActionCommand(title);
	 	reset.addActionListener(this);
	 	this.add(reset);

	 	title = "Bet 10";
	 	bet10 = new JButton(title);
	 	bet10.setActionCommand(title);
	 	bet10.addActionListener(this);
	 	this.add(bet10);

	 	title = "Bet 100";
	 	bet100 = new JButton(title);
	 	bet100.setActionCommand(title);
	 	bet100.addActionListener(this);
	 	this.add(bet100);

	 	this.deck = new Deck();
	 	deck.shuffle();
	 	this.player = new Player();
	 	this.betting = new Betting();

	 }

	 public void paint(Graphics g) {
	 	super.paint(g);
	 	deck.deal();
	 	deck.paintHand(g);
	 	betting.amountOfCash(g);
	 	deck.valueOfHand(g);
	 	deck.dealDealer(g);
	 	deck.paintHandDealer(g);

		if (betting.isUnder10() == true) {
	 			bet10.setEnabled(false);
	 			bet100.setEnabled(false);
	 		}

	 	if (betting.isUnder100() == true) {
	 		bet100.setEnabled(false);
	 	}

	 	if (stayTest == 1) {
	 		deck.whoWon(g);
	 		if (deck.whoWon() == 0) {
	 			betting.winPot();
	 			repaint();
	 		} else if (deck.whoWon() == 1) {
	 			betting.losePot();
	 			repaint();
	 		} else if (deck.whoWon() == 2) {
	 			betting.tiePot();
	 			repaint();
	 		}
	 	}
	 }

	 public void actionPerformed(ActionEvent ae) {
	 	if ("Hit".equals(ae.getActionCommand())) {
	 		cardsInHand++;
	 		deck.hitCard(cardsInHand);
	 		if (deck.valueOfHand() > 21) {
	 			hit.setEnabled(false);
	 			stay.setEnabled(false);
	 			bet10.setEnabled(false);
	 			bet100.setEnabled(false);
	 			stayTest++;
	 		}
	 		repaint();
	 	} else if ("Stay".equals(ae.getActionCommand())) {
	 		deck.finishDealer();
	 		deck.whoWon();
	 		hit.setEnabled(false);
	 		stay.setEnabled(false);
	 		bet10.setEnabled(false);
	 		bet100.setEnabled(false);
	 		stayTest++;
	 		repaint();
	 	} else if ("Reset".equals(ae.getActionCommand())) {
	 		deck.deal();
	 		stayTest = 0;
	 		reset();
	 		repaint();
	 		hit.setEnabled(true);
	 		stay.setEnabled(true);
	 		bet10.setEnabled(true);
	 		bet100.setEnabled(true);
	 	} else if ("Bet 10".equals(ae.getActionCommand())) {
	 		betting.bet10();
	 		repaint();
	 	} else if ("Bet 100".equals(ae.getActionCommand())) {
	 		betting.bet100();
	 		repaint();
	 	}
	 }

	 public void reset() {
	 	deck = new Deck();
	 	this.cardsInHand = 0;
	 	deck.shuffle();
	 }
}