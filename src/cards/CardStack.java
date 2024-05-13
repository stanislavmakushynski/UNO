package cards;

import java.util.LinkedList;

import main.Log;
import main.Main;

public class CardStack {
	
	protected LinkedList<Card> cards;
	
	public CardStack() {
		cards = new LinkedList<Card>();
	}
	
	public void AddCard(Card card) {
		cards.push(card);
	}
	
	public Card PlayCard(Card card) {
		//cards.remove(cards.indexOf(card));
		Log.writeConsole(String.valueOf(cards.remove(card)));
		Main.Instance.RemovePlayerCard(card);
		return card;
	}
	
	public void displayCards() {
		System.out.println(cards);
	}
	
	public int getSize() {
		return this.cards.size();
	}
}
