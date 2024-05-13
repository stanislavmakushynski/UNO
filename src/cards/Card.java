package cards;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import game.CardPanel;
import main.Log;
import main.Main;

public abstract class Card {
	
	public enum Colour {RED, YELLOW, GREEN, BLUE};
	protected Colour colour;
	public CardPanel cardPanel;
	private CardStack myStack;
	
	public Card(Colour colour) {
		this.colour = colour;
		this.myStack = null;
	}
	
	public Colour getColour() {
		return this.colour;
	}
	
	public void CreateCardPanel() {
		this.cardPanel = new CardPanel();
		this.cardPanel.SetCard(this);
		this.cardPanel.SetOnClickEvent(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Card.this.myStack.PlayCard(Card.this);
			}
		});
	}
	
	public CardPanel getCardPanel() {
		if(this.cardPanel == null)
			return null;
		else
			return this.cardPanel;
	}
	
	public void moveToStack(CardStack stack) {
		this.myStack = stack;
	}
	
	public abstract int getCardScore();
	
	public abstract String cardToString();
}
