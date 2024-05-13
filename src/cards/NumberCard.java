package cards;

public class NumberCard extends Card {
	
	private int number;
	
	public NumberCard(int number, Colour colour) {
		super(colour);
		this.number = number;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public int getCardScore() {
		return number;
	}
	
	@Override public String cardToString() {
		return String.format("%s %d card", colour.toString(), number);
	}
}
