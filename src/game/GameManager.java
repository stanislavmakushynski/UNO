package game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import cards.*;
import main.Log;
import main.Main;

public class GameManager {
	
	public DrawPile drawPile;
	public DiscardPile discardPile;
	public CardPanel drawPilePanel;
	
	public Player[] players;
	
	private int currentPlayer;
	private boolean directionCW;
	
	public GameManager(CardPanel drawPilePanel) {
		drawPile = new DrawPile(drawPilePanel);
		this.drawPilePanel = drawPilePanel;
		discardPile = new DiscardPile();
		players = new Player[3];
		players[0] = new UserPlayer("User");
		players[1] = new BotPlayer();
		players[2] = new BotPlayer();
		
		for(Player player : players) {
			drawPile.DealCards(player, 7);
		}
		
		currentPlayer = 0;
		directionCW = true;
		Main.Instance.setDirectionDisplay("CW");
		
		drawPilePanel.SetOnClickEvent(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Log.writeConsole("draw card");
				drawPile.DrawCard(players[0]);
				currentPlayer = nextPlayer();
				switchDirection();
			}
		});
	}
	
	private int nextPlayer() {
		if(directionCW)
			return (currentPlayer + 1) % players.length;
		else {
			int temp = (currentPlayer - 1) % players.length;
			return temp + (temp >= 0 ? 0 : players.length);
		}
	}
	
	public void switchDirection() {
		directionCW = !directionCW;
		Main.Instance.setDirectionDisplay(directionCW ? "CW" : "CCW");
	}
}
