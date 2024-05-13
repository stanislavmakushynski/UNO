package cards;

public class DiscardPile extends CardStack {
	
	public DiscardPile() {
		super();
	}
	
	public void Discard(Card card) {
		cards.push(card);
	}
}
