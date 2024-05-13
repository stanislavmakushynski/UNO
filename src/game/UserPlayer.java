package game;

import cards.Card;
import main.Main;

public class UserPlayer extends Player {

	public UserPlayer(String name) {
		super(name);
	}

	@Override
	public void DrawCard(Card card) {
		super.DrawCard(card);
		Main.Instance.AddPlayerCard(card);
	}
}
