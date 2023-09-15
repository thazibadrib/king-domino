import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.*;

/**
 * 
 */

/**
 * this class extends jFrame and should create the gui of KINGDOMINO-Take A Turn
 * sketched in the prototype sketch
 * 
 * @author aRahnama
 *
 */
public class TakeTurn extends JFrame implements ActionListener {
	private int a;
	private JButton newGam;
	private JButton saveGame;
	private RectangleTile tile;
	private ArrayList<RectangleTile> tiles;
	private ArrayList<RectangleTile> toBeDisplayedTiles;
	private static ArrayList<RectangleTile> selectedRectangleTiles;
	private static int gridSelectedTimes;

	private JPanel midPanel;
	private JButton newDominos;
	static JLabel playerlabel;
	private int count;

	Icon kingMeeple;
	

	/**
	 * constructor
	 */
	public TakeTurn() {

		// initilaize a jframe and its size

		this.setTitle("KingDomino-Take Turn");
		this.setSize(900, 900);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());

		gridSelectedTimes=0;


		// divide the gui to 3 panels
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		newGam = new JButton("NEW GAME");
		newGam.addActionListener(this);
		saveGame = new JButton("SAVE GAME");
		saveGame.addActionListener(this);
		JButton takeTurn = new JButton("TAKE TURN");
		takeTurn.addActionListener(this);
		JButton newDominos = new JButton("Display New Dominos");
		newDominos.addActionListener(this);
		playerlabel = new JLabel("Player1's Turn");
		topPanel.add(newGam);
		topPanel.add(saveGame);
		topPanel.add(takeTurn);
		topPanel.add(newDominos);
		topPanel.add(playerlabel);
		this.add(topPanel, BorderLayout.NORTH);
		JPanel midPanel = new JPanel();
		midPanel.setLayout(new GridLayout(4, 2, 25, 25));
		// generates all the rectangle buttons in Domino tiles
		tiles = new ArrayList<>();
		for (int i = 1; i < 49; i++) {
			// i is starting from 1 to correctly create the tiles with accurate ids
			RectangleTile tile = new RectangleTile(i);
			// adding the tiles to the array
			tiles.add(tile);
		}
		toBeDisplayedTiles = new ArrayList<>();
		a = 48;
		for (int j = 0; j < 8; j++) {
			Random rand = new Random();
			int randomInteger = rand.nextInt(a);
			toBeDisplayedTiles.add(tiles.get(randomInteger));
			tiles.remove(randomInteger);
			a = a - 1;
		}

		// this part will sort the displayed tiles based on their Id/numbers from top to
		// bottom
		// allowing us to meet the requirements of the game
		Collections.sort(toBeDisplayedTiles, Comparator.comparingLong(RectangleTile::getNumber));

		for (RectangleTile tilee : toBeDisplayedTiles) {
			midPanel.add(tilee);
			tilee.addActionListener(this);

		}

		selectedRectangleTiles= new ArrayList<>();

		// this.add(midPanel, BorderLayout.CENTER);
		this.add(midPanel, BorderLayout.SOUTH);

		// this will include 2 or 4 kingdoms where the players select to place their
		// tiles
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));

		if (NewGameSetUp.getPlayers().equals("Two Players")) {
			kingdom player1Kingdom = new kingdom(9, 9);
			bottomPanel.add(player1Kingdom);

			kingdom player2Kingdom = new kingdom(9, 9);
			bottomPanel.add(player2Kingdom);

		}
		if (NewGameSetUp.getPlayers().equals("Four Players")) {
			kingdom player1Kingdom = new kingdom(9, 9);
			bottomPanel.add(player1Kingdom);

			kingdom player2Kingdom = new kingdom(9, 9);
			bottomPanel.add(player2Kingdom);

			kingdom player3Kingdom = new kingdom(9, 9);
			bottomPanel.add(player3Kingdom);

			kingdom player4Kingdom = new kingdom(9, 9);
			bottomPanel.add(player4Kingdom);

		}
		ImageIcon icon = new ImageIcon("instruction.png"); 
		String myString= "Instructions:\n"+
		"After the players place their domino\n"+
		"they must select their tile again to\n"+
		"allow other players move their tiles.";
		JLabel instructionLabel = new JLabel(myString);
		instructionLabel.setText("<html>" + myString.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");

		instructionLabel.setBackground(Color.CYAN);
		instructionLabel.setOpaque(true);
		// bottomPanel.add(instructionLabel);
		JPanel westPanel=new JPanel();
		westPanel.setSize(80,50);
		westPanel.add(instructionLabel);

		this.add(westPanel,BorderLayout.WEST);



		

		// if(NewGameSetUp.getPlayers().equals("Four Players")){
		// kingdom player1Kingdom= new kingdom(10,10);
		// bottomPanel.add(player1Kingdom);
		// kingdom player2Kingdom= new kingdom(10,10);
		// bottomPanel.add(player2Kingdom);
		// kingdom player3Kingdom= new kingdom(10,10);
		// bottomPanel.add(player3Kingdom);
		// kingdom player4Kingdom= new kingdom(10,10);
		// bottomPanel.add(player4Kingdom);

		// }

		this.add(bottomPanel, BorderLayout.CENTER);
		setVisible(true);

	}

	public static void increaseGridSelectedTimes(){
        gridSelectedTimes++;
    }
	public static int getGridselectedTimes(){
		return gridSelectedTimes;
	}

	public static ArrayList<RectangleTile> getSelectedRectangleTiles(){
		return selectedRectangleTiles;}

	public static void addSelectedRectangleTiles(RectangleTile rT){
			selectedRectangleTiles.add(rT);
		}

	@Override
	// action listener
	public void actionPerformed(ActionEvent e) {
		// get the object that was selected in the gui
		Object selected = e.getSource();
		

		if (selected instanceof JButton) {
			if ((selected).equals(newGam)) {
				NewGameSetUp newGameSet = new NewGameSetUp();
			}

			if ((selected).equals(newDominos)) {
				toBeDisplayedTiles = new ArrayList<>();
				for (int j = 0; j < 8; j++) {
					Random rand = new Random();
					int randomInteger = rand.nextInt(a);
					toBeDisplayedTiles.add(tiles.get(randomInteger));
					tiles.remove(randomInteger);
					a = a - 1;
				}

				for (RectangleTile tilee : toBeDisplayedTiles) {
					midPanel.add(tilee);
					tilee.addActionListener(this);

				}
				this.add(midPanel, BorderLayout.SOUTH);
				setVisible(true);

			}

		}

		if (selected instanceof GridSquare) {
			// increaseGridSelectedTimes();
			
			// if(((GridSquare) selected).isaccessibleToPlayer()){
			// 	System.out.println("True");
			// 	if (selectedRectangleTiles.get((selectedRectangleTiles.size())-1).getSelectedTimes() == 1) {
			// 		if (NewGameSetUp.getPlayers().equals("Two Players")) {

			// 			//this line will generate two GridButton Objects equivalent to the selected RectangleTile
			// 			//ArrayList<GridButton> p1quivalGridButtons= new ArrayList<>();
			// 			//generates the left square of the tile
			// 			double leftSquareId=(double) selectedRectangleTiles.get((selectedRectangleTiles.size())-1).getNumber();
						
			// 			//GridButton gBLeft=new GridButton(leftSquareId);
			// 			//generates the right square of the tile
			// 			//double rightSquareId=(double)selectedRectangleTiles.get((selectedRectangleTiles.size())-1).getNumber()+0.1;
			// 			//GridButton gBRight=new GridButton(rightSquareId);
			// 			//p1quivalGridButtons.add(gBLeft);
			// 			//p1quivalGridButtons.add(gBRight);
			// 			//System.out.println(leftSquareId);
						


						
			// 			// if(getGridselectedTimes()%2==0){
			// 			// 	(((GridSquare) selected)).setName(leftSquareId);
			// 			// 	(((GridSquare) selected)).setColor();
	
			// 			// }
			// 			// if(getGridselectedTimes()%2 !=0){
			// 			// 	(((GridSquare) selected)).setName(rightSquareId);
			// 			// 	(((GridSquare) selected)).setColor();
			// 			// }
							
				
							
				
						


	
	
			// 		}
			// 	}

			// }
			System.out.println("the sum of all gridsquares are selected:"+getGridselectedTimes());
			


		}
		
		if (selected instanceof RectangleTile) {
			Icon kingMeeple = new ImageIcon("Crown2.png");
			if (NewGameSetUp.getPlayers().equals("Two Players")) {
				
				if (((RectangleTile) selected).getSelectedTimes() == 0) {
					if (playerlabel.getText().equals("Player1's Turn")){
						((RectangleTile) selected).setText("player 1");
						playerlabel.setText("Player2's Turn");
					}
					else if (playerlabel.getText().equals("Player2's Turn")) {
						count += 1;
						if (count == 1){
							((RectangleTile) selected).setText("player 2");
							playerlabel.setText("Player1's Turn");
						}
						else if(count == 2){
							((RectangleTile) selected).setText("player 2");
							playerlabel.setText("" + toBeDisplayedTiles.get(0).getText() + " move your tile to the kingdom.");
						}
					}
					
				}
				
				if (((RectangleTile) selected).getSelectedTimes() == 1) {
					if (playerlabel.getText()
							.equals(((RectangleTile) selected).getText() + " move your tile to the kingdom.")) {
						
						if (((RectangleTile) selected).getText().equals("player 1")){
							((RectangleTile) selected).setBackground(Color.yellow);
							((RectangleTile) selected).setRolloverIcon(kingMeeple);
						}
						if (((RectangleTile) selected).getText().equals("player 2")){
							((RectangleTile) selected).setBackground(Color.blue);
							((RectangleTile) selected).setRolloverIcon(kingMeeple);
						}
					}
					
				}
				
				if (((RectangleTile) selected).getSelectedTimes() == 2) {
					if (playerlabel.getText()
							.equals(((RectangleTile) selected).getText() + " move your tile to the kingdom.")) {
								
						if((selected).equals(toBeDisplayedTiles.get(0))){
							playerlabel.setText("" + toBeDisplayedTiles.get(2).getText() + " move your tile to the kingdom.");
						}
						if((selected).equals(toBeDisplayedTiles.get(2))){
							playerlabel.setText("" + toBeDisplayedTiles.get(4).getText() + " move your tile to the kingdom."); 
						}
						if((selected).equals(toBeDisplayedTiles.get(4))){
							playerlabel.setText("" + toBeDisplayedTiles.get(6).getText() + " move your tile to the kingdom.");
						}
						if((selected).equals(toBeDisplayedTiles.get(6))){
							playerlabel.setText("stop");
						}
						
					}	
				}
			}
	
			if (NewGameSetUp.getPlayers().equals("Four Players")) {
				
				if (((RectangleTile) selected).getSelectedTimes() == 0) {
					if (playerlabel.getText().equals("Player1's Turn")) {

						((RectangleTile) selected).setText("player 1");
						playerlabel.setText("Player2's Turn");
					}
					else if (playerlabel.getText().equals("Player2's Turn")) {

						((RectangleTile) selected).setText("player 2");
						playerlabel.setText("Player3's Turn");
					}
					else if (playerlabel.getText().equals("Player3's Turn")) {

						((RectangleTile) selected).setText("player 3");
						playerlabel.setText("Player4's Turn");
					}
					else if (playerlabel.getText().equals("Player4's Turn")) {

						((RectangleTile) selected).setText("player 4");

						playerlabel.setText("" + toBeDisplayedTiles.get(0).getText() + " move your tile to the kingdom.");
					}
				}

				if (((RectangleTile) selected).getSelectedTimes() == 1) {
					if (playerlabel.getText()
							.equals(((RectangleTile) selected).getText() + " move your tile to the kingdom.")) {
						//if statement makes it so we can change the colours later if we want
						if (((RectangleTile) selected).getText().equals("player 1")){
							((RectangleTile) selected).setBackground(Color.yellow);
							((RectangleTile) selected).setRolloverIcon(kingMeeple);
						}
						if (((RectangleTile) selected).getText().equals("player 2")){
							((RectangleTile) selected).setBackground(Color.red);
							((RectangleTile) selected).setRolloverIcon(kingMeeple);
						}
						if (((RectangleTile) selected).getText().equals("player 3")){
							((RectangleTile) selected).setBackground(Color.blue);
							((RectangleTile) selected).setRolloverIcon(kingMeeple);
						}
						if (((RectangleTile) selected).getText().equals("player 4")){
							((RectangleTile) selected).setBackground(Color.green);
							((RectangleTile) selected).setRolloverIcon(kingMeeple);
						}
						
					}
					
				}

				if (((RectangleTile) selected).getSelectedTimes() == 2) {
					if (playerlabel.getText()
							.equals(((RectangleTile) selected).getText() + " move your tile to the kingdom.")) {
								
						if((selected).equals(toBeDisplayedTiles.get(0))){
							playerlabel.setText("" + toBeDisplayedTiles.get(2).getText() + " move your tile to the kingdom.");
						}
						if((selected).equals(toBeDisplayedTiles.get(2))){
							playerlabel.setText("" + toBeDisplayedTiles.get(4).getText() + " move your tile to the kingdom."); 
						}
						if((selected).equals(toBeDisplayedTiles.get(4))){
							playerlabel.setText("" + toBeDisplayedTiles.get(6).getText() + " move your tile to the kingdom.");
						}
						if((selected).equals(toBeDisplayedTiles.get(6))){
							playerlabel.setText("stop (change later)");
						}
						
					}
				}
			}
			

			// else if (((RectangleTile) selected).getSelectedTimes() == 1) {
			// 	selectedRectangleTiles.add(((RectangleTile) selected));
			// 	System.out.println(selectedRectangleTiles.get(0).getNumber());
			// }
			

			// String playerTurn=toBeDisplayedTiles.get(0).getText();
			// Icon kingMeeple=new ImageIcon("Crown2.png");

			// if(playerlabel.getText().equals(""+playerTurn+" move your tile to the
			// kingdom.")){
			// if(((RectangleTile)selected).getText().equals(playerTurn)){
			// ((RectangleTile)selected).setBackground(Color.yellow);
			// ((RectangleTile)selected).setRolloverIcon(kingMeeple);

			// //GENERATE TWO INSTANCES OF GridButtons and add them to an arrayList called
			// aList1
			// //create a new arraylist of Gridsquares called selectedGridssquares and add
			// anytime a grid square is selected
			// //if(selected instanceof GridSquare){if(gridsquareselectedTimes!=0 and
			// gridsquareselectedTimes%2==0){
			// // for(GridButton gb:aList1){for(gridSquare
			// Gs:selectedGridssquares){gs.setBackground(gb.getBackground());alist1.remove(gb);
			// //selectedGridssquares.remove(gs)}
			// //}}}
			// }

			// }

			// if the gridsquare(1.0) and gridsquare(1.1) neighboring
			// gridsquare.getname().equals(gridsquare(1.0).getName()){
			// ths.setName()
			// }
			// } or if gridsquare(1.1)or null)
			// if it's instance of rectangleTILE---->Create two instances of gridButons and
			// add them to an arraylist1
			// then if instanceof gridSquare-------->for(gridButton gb:arrayList1){for all
			// neighbours if neighbouringGridsquares.getname().equals(gb.getname())}
			// this.setNAme(gb.getId())
			// this.setColor()

		}
		//System.out.println("the numbers each recctangles tiles is selected:"+((RectangleTile) selected).getSelectedTimes());
		

	}

}
