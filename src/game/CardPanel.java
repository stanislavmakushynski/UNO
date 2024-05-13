package game;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import cards.*;
import cards.Card.Colour;
import main.Log;

public class CardPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel cardTypeLabel;
	private JLabel cardColourLabel;
	private JLabel cardPropertyLabel;

	public CardPanel() {
		super();
		this.setName("CARD PANEL");
		setBackground(new Color(0, 0, 255));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		cardTypeLabel = new JLabel("NUMBER CARD");
		cardTypeLabel.setForeground(new Color(255, 255, 255));
		cardTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		cardTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(cardTypeLabel);
		
//		cardColourLabel = new JLabel("BLUE");
//		cardColourLabel.setForeground(new Color(255, 255, 255));
//		cardColourLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//		cardColourLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		cardColourLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
//		add(cardColourLabel);
		
		cardPropertyLabel = new JLabel("0");
		cardPropertyLabel.setForeground(new Color(255, 255, 255));
		cardPropertyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardPropertyLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		cardPropertyLabel.setAlignmentX(0.5f);
		add(cardPropertyLabel);
		
		setVisible(true);
	}
	
	public void SetOnClickEvent(MouseAdapter mouseEvent) {
		addMouseListener(mouseEvent);
	}
	
	public void SetCard(Card card) {
		cardTypeLabel.setText(card.getClass().getSimpleName());
		if(card instanceof NumberCard) {
			cardPropertyLabel.setText(String.valueOf(((NumberCard)card).getNumber()));
			SetCardColour(card);
		}
		else if(card instanceof ActionCard) {
			cardPropertyLabel.setText(((ActionCard)card).getAction().name());
			SetCardColour(card);
		}
		else if(card instanceof WildCard) {
			cardPropertyLabel.setText(((WildCard)card).getAction().name());
			setBackground(new Color(0, 0, 0));
		}
		setVisible(true);
	}
	
	private void SetCardColour(Card card) {
		Log.writeConsole(card.getColour().name());
		switch(card.getColour()) {
			case Colour.BLUE:
				setBackground(new Color(0, 0, 255));
				break;
			case Colour.GREEN:
				setBackground(new Color(0, 255, 0));
				break;
			case Colour.RED:
				setBackground(new Color(255, 0, 0));
				break;
			case Colour.YELLOW:
				setBackground(new Color(255, 255, 0));
				break;
		}
	}
}
