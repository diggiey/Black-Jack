public class Hand {

	private Card[] cards;

	public Hand(Card card) {
		this.cards = new Card[11];
	}

	public int handValue() {
		int valueHand = 0;
		for (int i=0; i<2; i++) {
			valueHand += this.cards[i].getValue();
		}
		return valueHand;
	}
}