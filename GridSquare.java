import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;


/*
 *  A simple extension of JButton which primarily sets the grids of the kingdom, and will copy an instance of 
 * GridButton background to the kingdom when a Grid squre is selected by player to place their tiles
 *
 *  @author aRahnama
 */
public class GridSquare extends JButton implements ActionListener
{
	private int xcoord, ycoord;     // location of this square
	private String name;
	private boolean accessibleToPlayer;
	private Icon terrainImg;
	
	//private boolean accessibleToP2;

	// constructor takes the x and y coordinates of this square
	public GridSquare( int xcoord, int ycoord)
	{
		super();
		this.name=name;
		this.setPreferredSize(new Dimension(20, 20));
		this.xcoord = xcoord;
		this.ycoord = ycoord;
		this.accessibleToPlayer=false;
		// this.addActionListener(this);
		setWhiteColor();// sets the button's background color white	
		// setVisible(true);
		this.addActionListener(this);
	}
	
	// sets the color of each swuare button to white
	public void setWhiteColor( )
	{
		
		this.setBackground(Color.white);
	}
	
	public void setBackgroundimage(int id){


	}

	

	public int getXCoord(){
		return this.xcoord;
	}

	public int getYCoord(){
		return this.ycoord;

	}


	//this will set the name of the square tiles selected on the kingdom 
	//according to the double id's given to this function matching the rectangle tiles(eg 1.0, the leftsquare of the rectangle tile, 
	//and 1.1, the right square of the 1st rectangle tile)
	public void setName(double id)
    {
        // put your code here
        if(id==1.0||id==1.1||id==2.0||id==2.1||id==13.0||id==14.0||id==15.0||
        id==16.0||id==19.0||id==20.0||id==21.0||id==22.0||id==23.0||id==24.1||
        id==25.1||id==26.1||id==27.1||id==30.1||id==31.1||id==36.0||id==40.1||
        id==43.0||id==38.0||id==41.0||id==45.1||id==48.0){
        	this.name= "wheatFields";
    	}
    
    	if(id==3.0||id==3.1||id==4.0||id==4.1||id==5.0||id==5.1||id==5.1||id==6.0||
        id==6.1||id==13.1||id==17.0||id==18.0||id==19.1||id==24.0||id==25.0||
        id==26.0||id==27.0||id==28.0||id==29.0||id==32.1||id==33.1||id==34.1||
        id==35.1){
            this.name="forests";
    	}
    
    	if(id==10.0||id==10.1||id==11.0||id==11.1||id==15.1||id==18.1||id==21.1||
        id==29.1||id==36.1||id==39.0||id==37.1||id==41.1||id==42.1||id==44.0
        ){
            this.name="grassLands";
    	}
    
    	if(id==8.0||id==8.1||id==7.0||id==7.1||id==9.0||id==9.1||id==14.1||
        id==17.1||id==20.1||id==28.1||id==30.0||id==31.0||id==32.0||id==33.0||
        id==34.0||id==35.0||id==37.0||id==42.0){
            this.name="lakes";
		}
    
    	if(id==23.1||id==40.0||
        id==45.0||id==46.1||
        id==47.1||id==48.1){
            this.name="mines";
    	}

    	if(id==44.1||id==12.0||id==12.1||id==16.1||id==22.1||id==39.1||
        id==43.1||id==38.1||id==46.0||id==47.0){
            this.name="swamps";
    	}
    }
    

	
	//this will set the background as imageicon for palette1 settings, and solid backgroundcolor for palette2 settings
    public void setColor() {
		if(NewGameSetUp.getPalette().equals("Color Palette1")){
			if(this.getName().equals("wheatFields")) {
				terrainImg=new ImageIcon("wheatfeilds.png");
				this.setIcon(terrainImg); 
			}
			if(this.getName().equals("forests")) {
				terrainImg=new ImageIcon("forest.png");
				this.setIcon(terrainImg);   
			}
			if(this.getName().equals("grassLands")) {
				terrainImg=new ImageIcon("grassLands.png");
				this.setIcon(terrainImg);  
			}
			if(this.getName().equals("lakes")) {
				terrainImg=new ImageIcon("lakes.png");
				this.setIcon(terrainImg);  
			}
			if(this.getName().equals("mines")) {
				terrainImg=new ImageIcon("mines.png");
				this.setIcon(terrainImg);  
			}
			if(this.getName().equals("swamps")) {
				terrainImg=new ImageIcon("swamps.png");
				this.setIcon(terrainImg);  
			}
		}
		if(NewGameSetUp.getPalette().equals("Color Palette2")){
			if(this.name.equals("wheatFields")) {
				this.setBackground(Color.YELLOW);  
			}
			if(this.name.equals("forests")) {
				this.setBackground(Color.GREEN);  
			}
			if(this.name.equals("grassLands")) {
				this.setBackground(Color.MAGENTA);  
			}
			if(this.name.equals("lakes")) {
				this.setBackground(Color.BLUE);  
			}
			if(this.name.equals("mines")) {
				this.setBackground(Color.GRAY);  
			}
			if(this.name.equals("swamps")) {
				this.setBackground(Color.ORANGE);  
			}

		}
    }




	// if the decider is false it sets the button's color to red, and if it's true it sets the color to blue
	public void switchColor(boolean decider)
	{
		Color colour = decider != true ? Color.red : Color.blue;
		this.setBackground( colour);
	}

	//this will avoid switching color once a button is selected.
	public void saveColor()
	{
		this.setBackground(this.getBackground());
	}
    
        // simple setters(mutators) and getters(accessor)
        public void setXcoord(int value)    { xcoord = value; }
        public void setYcoord(int value)    { ycoord = value; }
        public int getXcoord()              { return xcoord; }
        public int getYcoord()              { return ycoord; }
		public String getName()             {return this.name;}

	//label the gridSquare buttons with a name based on the color of the button

	//makes the GridSquare unaccessible basd on the variable given(player1 or player 2)
	public void setOffAccess(){
	    this.accessibleToPlayer=false;
	   }
	//set the grid square accessible again when needed to both players
	public void setAccessible(){
		this.accessibleToPlayer=true;
	}
	//returns true if accessible to player1
	public boolean isaccessibleToPlayer(){
		return(this.accessibleToPlayer==true ? true: false);

	}

	public void actionPerformed(ActionEvent e) 	{
		// get the object that was selected in the gui
		Object selected = e.getSource();
        //increment the number of times each tile is selected
		TakeTurn.increaseGridSelectedTimes();	
		System.out.println(TakeTurn.getGridselectedTimes());
		if(selected instanceof GridSquare){
			if(((GridSquare) selected).isaccessibleToPlayer()){
				System.out.println("True");
				System.out.println("the selected tile id is:"+ TakeTurn.getSelectedRectangleTiles().get((TakeTurn.getSelectedRectangleTiles().size())-1).getNumber());
				if (TakeTurn.getSelectedRectangleTiles().get((TakeTurn.getSelectedRectangleTiles().size())-1).getSelectedTimes() == 2) {
					if (NewGameSetUp.getPlayers().equals("Two Players")) {

						//this line will generate two GridButton Objects equivalent to the selected RectangleTile
						//ArrayList<GridButton> p1quivalGridButtons= new ArrayList<>();
						//generates the left square of the tile
						double leftSquareId=(double) TakeTurn.getSelectedRectangleTiles().get((TakeTurn.getSelectedRectangleTiles().size())-1).getNumber();
						
						//GridButton gBLeft=new GridButton(leftSquareId);
						//generates the right square of the tile
						double rightSquareId=(double)TakeTurn.getSelectedRectangleTiles().get((TakeTurn.getSelectedRectangleTiles().size())-1).getNumber()+0.1;
						//GridButton gBRight=new GridButton(rightSquareId);
						// p1quivalGridButtons.add(gBLeft);
						// p1quivalGridButtons.add(gBRight);
						System.out.println("leftSquareId is"+leftSquareId);
						System.out.println("leftSquareId is"+rightSquareId);
						
						// if(TakeTurn.playerlabel.getText().equals(TakeTurn.getSelectedRectangleTiles().get(TakeTurn.getSelectedRectangleTiles().size()-1)+ " move your tile to the kingdom.")){
							// set the selected gridsquares neighbour accessible to player
							GridSquare[][] KingdomGS= kingdom.getKingdomGridSquares();
							int Xcoordinate= ((GridSquare) selected).getXCoord();
							int ycoordinate= ((GridSquare) selected).getYCoord();
							KingdomGS[Xcoordinate+1][ycoordinate].setAccessible();
							KingdomGS[Xcoordinate-1][ycoordinate].setAccessible();
							KingdomGS[Xcoordinate][ycoordinate+1].setAccessible();
							KingdomGS[Xcoordinate][ycoordinate-1].setAccessible();
							System.out.println("grid square with Xcoordinate is just seletcted:" + Xcoordinate);
							System.out.println("grid square with Ycoordinate is just seletcted:" + ycoordinate);
							System.out.println("neighbour with"+Xcoordinate+"and "+ (ycoordinate-1)+"is accessible?"+KingdomGS[Xcoordinate][ycoordinate-1].isaccessibleToPlayer());
						// }

						
						if(TakeTurn.getGridselectedTimes()%2 != 0){
							(((GridSquare) selected)).setName(leftSquareId);
							(((GridSquare) selected)).setColor();

						}
						if(TakeTurn.getGridselectedTimes()%2 ==0){
							(((GridSquare) selected)).setName(rightSquareId);
							(((GridSquare) selected)).setColor();
						}
							
				

					}
				
				}
				((GridSquare) selected).setOffAccess();
			}
			

		}	

    }
	
	  
}
