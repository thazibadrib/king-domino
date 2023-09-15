
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox.*;
/**
 * @aRahnama
 * this class creates a gui for the game setups
 * I was aiming to add dropdown menues to the gui but instead i added pop up question dialogues, 
 * it is better if we could add drop down menues tpo the jFrame instead of this method i used!!!!!!!!!
 *
 */
public class NewGameSetUp extends JFrame implements ActionListener{

	/**
	 * 
	 */
	JPanel topPanel;
	JPanel botPanel;
	JButton saveSettings;
	static JComboBox<String> palette;
	static JComboBox<String> difficulty;
	static JComboBox<String> setUpPlayers;
	public String paletteSelected;
	String difficultySelected;
	String playersSelected;
	TakeTurn newWindow;

	
	public NewGameSetUp(){
		super();
		this.setSize(600,600);
		this.setTitle("KingDomino-New Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		JPanel northPanel= new JPanel();
		northPanel.setSize(500, 100);
		JLabel tittle= new JLabel("Select your color and players settings");
		northPanel.add(tittle);
		this.add(northPanel, BorderLayout.NORTH);
		JPanel centerPanel= new JPanel();
		centerPanel.setSize(450,450);
		this.add(centerPanel, BorderLayout.CENTER);
		JPanel southPanel= new JPanel();
		this.add(southPanel,BorderLayout.SOUTH);
		
		
		//selecting number of players
		String[] optionsToChoose = {"Two Players", "Four Players"};
		setUpPlayers = new JComboBox<>(optionsToChoose);
		centerPanel.add(setUpPlayers);
//	    
		
//	    //selecting difficulty mode
	    String[] difficultyToChoose = {"Easy", "Hard"};
	    difficulty = new JComboBox<>(difficultyToChoose);
	    centerPanel.add(difficulty);	    

	    
//	    //color palette selection
	    String[] colorsToChoose = {"Color Palette1", "Color Palette2"};
	    palette = new JComboBox<>(colorsToChoose);
	    centerPanel.add(palette);	    

	    saveSettings= new JButton("Save Settings");
	    saveSettings.addActionListener(this);
	    southPanel.add(saveSettings);
	    
	    
		setResizable(false);
		setVisible(true);
		
	}
	
	public static String getPlayers() {
		String x= setUpPlayers.getSelectedItem().toString();
		return x;
	}
	
	public static  String getPalette() {
		String y= palette.getSelectedItem().toString();
		return y;
	}
	
	public static String getDifficulty() {
		String z= difficulty.getSelectedItem().toString();
		return z;
	}
	
	public  TakeTurn getTakeTurnInstance(){
		return newWindow;
	}
	public void actionPerformed (ActionEvent aevt)
	{
		// get the object that was selected in the gui
		Object selected = aevt.getSource();
		
		
		
		if ( selected instanceof JButton)
		{
			if(selected.equals(saveSettings)){
				System.out.println(getPlayers()+","+getPalette()+","+getDifficulty());
				TakeTurn newWindow=new TakeTurn();

				//SETTINGS FOR COLOR PALLETE 1
				// if(getPalette().equals("Color Palette1")){
				// 	if(getPlayers().equals("Two Players") && getDifficulty().equals("Easy")){
				// 		TakeTurn newWindow=new TakeTurn();
						

				// 	}
				// 	if(getPlayers().equals("Two Players") && getDifficulty().equals("Hard")){

				// 	}
				// 	if(getPlayers().equals("Four Players") && getDifficulty().equals("Easy")){

				// 	}
				// 	if(getPlayers().equals("Four Players") && getDifficulty().equals("Hard")){

				// 	}

					
				// }
				// //SETTINGS FOR COLOR PALLETE 2
				// if(getPalette().equals("Color Palette2")){
				// 	if(getPlayers().equals("Two Players") && getDifficulty().equals("Easy")){

				// 	}
				// 	if(getPlayers().equals("Two Players") && getDifficulty().equals("Hard")){

				// 	}
				// 	if(getPlayers().equals("Four Players") && getDifficulty().equals("Easy")){

				// 	}
				// 	if(getPlayers().equals("Four Players") && getDifficulty().equals("Hard")){

				// 	}
				// }
				
			}
			//TakeTurn takingTurnWindow= new TakeTurn();
			
			
		}
	}



}
