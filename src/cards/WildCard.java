package cards;

public class WildCard extends Card {

	public enum Action {ONLY_COLOUR, DRAW_FOUR}
	private Action action;
	
	public WildCard(Action action) {
		super(Colour.BLUE);
		this.action = action;
	}
	
	public int getCardScore() {
		return 50;
	}

	@Override public String cardToString() {
		return String.format("%s card", action.toString());
	}

	public Action getAction() {
		return action;
	}

}
