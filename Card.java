import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Card {
	
	private int number;
	private String cardSuit;
	private String faceCard;
	private String name;
	private int value;

	public Card(String cardSuit, int number) {
		this.cardSuit = cardSuit;
		this.number = number;
	}

	public Card(String cardSuit, int number, int value) {
		this.cardSuit = cardSuit;
		this.number = number;
		this.value = value;
	}

	public String getSuit() {
		return this.cardSuit;
	}

	public int getNumber() {
		return this.number;
	}

	public int getValue() {
		return this.value;
	}

	public void draw(Graphics g, String name, Rectangle r) {
		g.drawImage(Card.loadImage(name), r.x, r.y, r.width, r.height, null);
	}

	private static Image loadImage(String name) {
		String path = null;
		Image image = null;

		try {
			path = "cards" + File.separator + name + ".png";
			File file = new File(path);
			image = ImageIO.read(new File(path));
		} catch(IOException e) {
			System.out.println("Could not load image at path: " + path);
			System.exit(1);
		}

		return image;
	}

	public String toString() {
		if (this.getNumber() == 1) {
			return "A" + this.getSuit();
		} else if (this.getNumber() == 11) {
			return "J" + this.getSuit();
		} else if (this.getNumber() == 12) {
			return "Q" + this.getSuit();
		} else if (this.getNumber() == 13) {
			return "K" + this.getSuit();
		} else if (this.getNumber() > 1 && this.getNumber() < 11) {
			return this.getNumber() + this.getSuit();
		}
		return null;
	}

}