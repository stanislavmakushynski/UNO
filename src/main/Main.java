package main;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cards.Card;
import game.*;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.Box;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private GameManager gameManager;
	
	public CardPanel drawPilePanel, discardPilePanel;
	private JLayeredPane playerHand;
	private JLabel directionLabel;
	
	public static Main Instance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Log.write("APPLICATION LAUNCHED");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					Log.write("Frame created");
				} catch (Exception e) {
					e.printStackTrace();
					Log.write(e.getMessage());
					Log.close();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		Instance = this;
		

		try {
			BufferedImage backgroundImage = javax.imageio.ImageIO.read(new File("background.jpg"));
			setContentPane(new JPanel() {
				@Override public void paintComponent(Graphics g) {
					g.drawImage(backgroundImage, 0, 0, null);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//getContentPane().setBackground(new Color(128, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 478);
		getContentPane().setLayout(new MigLayout("", "[436px,grow]", "[grow][109.00px,grow][grow]"));
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, "cell 0 0,growx,aligny center");
		
		CardPanel cardPanel = new CardPanel();
		panel_2.add(cardPanel);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, "flowx,cell 0 1,alignx center,aligny center");
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		discardPilePanel = new CardPanel();
		discardPilePanel.setVisible(false);
		panel.add(discardPilePanel);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(150);
		panel.add(horizontalStrut_1);
		
		directionLabel = new JLabel("Direction: CW");
		directionLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(directionLabel);
		
		Component horizontalStrut = Box.createHorizontalStrut(150);
		panel.add(horizontalStrut);
		
		drawPilePanel = new CardPanel();
		drawPilePanel.setBackground(Color.PINK);
		panel.add(drawPilePanel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, "cell 0 2,growx,aligny center");
		panel_1.setLayout(new BorderLayout(0, 0));
		
		playerHand = new JLayeredPane();
		playerHand.setBackground(new Color(0, 206, 209));
		panel_1.add(playerHand, BorderLayout.CENTER);
		FlowLayout fl_playerHand = new FlowLayout(FlowLayout.CENTER, -15, 5);
		playerHand.setLayout(fl_playerHand);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Log.close();
				dispose();
			}
		});
		
		gameManager = new GameManager(drawPilePanel);
	}
	
	public void AddPlayerCard(Card card) {
		card.CreateCardPanel();
		playerHand.add(card.cardPanel, -1);
		((FlowLayout)playerHand.getLayout()).setHgap(-3 * playerHand.getComponentCount());
		validate();
		repaint();
	}
	
	public void RemovePlayerCard(Card card) {
		playerHand.remove(card.cardPanel);
		validate();
		repaint();
	}
	
	public void setDirectionDisplay(String direction) {
		directionLabel.setText("Direction: ".concat(direction));
	}
	
	public void setDiscardPileTop(Card card) {
		if(!discardPilePanel.isVisible())
			discardPilePanel.setVisible(true);
		discardPilePanel.SetCard(card);
	}
}
