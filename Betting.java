import java.awt.Graphics;

public class Betting {

	private int inPot;
	private int cash = 1000;

	public Betting() {
		
	}

	public void amountOfCash(Graphics g) {
		g.drawString("Amount of cash: " + cash , 25, 25);
	}

	public void bet10() {
		inPot += 20;
		cash -= 10;
	}

	public void bet100() {
		inPot += 200;
		cash -= 100;
	}

	public void winPot() {
		cash += inPot;
		inPot = 0;
	}

	public void losePot() {
		inPot = 0;
	}

	public void tiePot() {
		cash += (inPot / 2);
		inPot = 0;
	}

	public boolean isUnder10() {
		if (cash < 10) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isUnder100() {
		if (cash < 100) {
			return true;
		} else {
			return false;
		}
	}
}