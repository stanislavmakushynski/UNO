package game;

public class BotPlayer extends Player {

	private static int botCount = 0;
	
	public BotPlayer() {
		super("Bot " + String.valueOf(botCount));
		botCount++;
	}
}
