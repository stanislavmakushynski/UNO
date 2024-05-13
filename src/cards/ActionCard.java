package cards;

public class ActionCard extends Card {
	
	public static enum Action {DRAW_TWO, REVERSE, SKIP};
	private Action action;
	
	public ActionCard(Action action, Colour colour) {
		super(colour);
		this.action = action;
	}
	
	public int getCardScore() {
		return 20;
	}
	
	@Override public String cardToString() {
		return String.format("%s %s card", colour.toString(), action.toString());
	}

	public Action getAction() {
		return action;
	}
}
