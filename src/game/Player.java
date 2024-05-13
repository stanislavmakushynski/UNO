package game;

import cards.Card;
import cards.CardStack;
import main.Main;

public abstract class Player {
	
	private String name;
	private CardStack cards;
	
	public Player(String name) {
		this.name = name;
		this.cards = new CardStack();
	}
	
	public void DrawCard(Card card) {
		cards.AddCard(card);
		card.moveToStack(cards);
	}
	
	public void PlayCard(Card card) {
		Main.Instance.setDiscardPileTop(cards.PlayCard(card));
	}
	
	public int getCardCount() {
		return cards.getSize();
	}
	
	public String getName() {
		return this.name;
	}
}
