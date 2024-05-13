package cards;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import cards.Card.Colour;
import game.CardPanel;
import game.Player;
import main.Log;
import main.Main;

public class DrawPile extends CardStack {
	
	private CardPanel topCard;
	
	public DrawPile(CardPanel topCard) {
		super();
		
		for(Colour colour : Colour.values()) {
			Log.writeConsole(colour.name());
			for(int num = 1; num <= 9; ++num) {
				cards.add(new NumberCard(num, colour));
				cards.add(new NumberCard(num, colour));
			}
			cards.add(new NumberCard(0, colour));
			cards.add(new ActionCard(ActionCard.Action.DRAW_TWO, colour));
			cards.add(new ActionCard(ActionCard.Action.DRAW_TWO, colour));
			cards.add(new ActionCard(ActionCard.Action.REVERSE, colour));
			cards.add(new ActionCard(ActionCard.Action.REVERSE, colour));
			cards.add(new ActionCard(ActionCard.Action.SKIP, colour));
			cards.add(new ActionCard(ActionCard.Action.SKIP, colour));
			cards.add(new WildCard(WildCard.Action.DRAW_FOUR));
			cards.add(new WildCard(WildCard.Action.ONLY_COLOUR));
		}
		
		Collections.shuffle(cards);
		
		this.topCard = topCard;
	}
	
	public Card DrawCard(Player targetPlayer) {
		try {
			Card drawnCard = cards.pop();
			targetPlayer.DrawCard(drawnCard);
			return drawnCard;
		}
		catch(NoSuchElementException e) {
			Log.write("Draw Pile is empty");
			return null;
		}
	}
	
	public void DealCards(Player targetPlayer, int number) {
		for(int i = 0; i < number; ++i) {
			Log.writeConsole(DrawCard(targetPlayer).toString() + " dealt to " + targetPlayer.getName());
		}
	}
}
