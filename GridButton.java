import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * GridButton class creates a square button which will be copied on the kingdom GriSquare instances when player
 * selects a GridSquare if allowed by the rules of the game.
 * 
 * @aRahnama 
 *  
 */
public class GridButton extends JButton
{
    // instance variables
    private double id;
    private String name;
    private JButton grid;
    private ImageIcon img;
    private int xcoord;
    private int ycoord;

    /**
     * Constructor for objects of class SquareButton
     */
    public GridButton(double id)
    {
        // initialise instance variables
        super();
        this.id=id;
        this.xcoord = xcoord;
		this.ycoord = ycoord;
        setName();
        if(NewGameSetUp.getPalette().equals("Color Palette1")){
            if(NewGameSetUp.getDifficulty().equals("Easy")){
                switch(this.getName()) {
                    case("wheatFields"):
                        img=new ImageIcon(Class.class.getResource("wheatfeilds.png"));
                        grid= new JButton("",img);
                        setRolloverIcon(img);
                    case("forests"):
                        img=new ImageIcon(Class.class.getResource("forest.png"));
                        grid= new JButton("",img);
                        setRolloverIcon(img);
                    case("grassLands"):
                        img=new ImageIcon(Class.class.getResource("grassLands.png"));
                        grid= new JButton("",img);
                        setRolloverIcon(img);
                    case("lakes"):
                        img=new ImageIcon(Class.class.getResource("lakes.png"));
                        grid= new JButton("",img);
                        setRolloverIcon(img);
                    case("mines"):
                        img=new ImageIcon(Class.class.getResource("mines.png"));grid= new JButton("",img);
                        setRolloverIcon(img);
                    case("swamps"):
                        img=new ImageIcon(Class.class.getResource("swamps.png"));
                        grid= new JButton("",img);
                        setRolloverIcon(img);
                }
                this.setSize(20,20);
            }
            if(NewGameSetUp.getDifficulty().equals("Hard")){
                switch(this.getName()) {
                    case("wheatFields"):
                        img=new ImageIcon(Class.class.getResource("wheatfeilds.png"));
                        grid= new JButton("",img);
                        setRolloverIcon(img);
                    case("forests"):
                        img=new ImageIcon(Class.class.getResource("forest.png"));
                        grid= new JButton("",img);
                        setRolloverIcon(img);
                    case("grassLands"):
                        img=new ImageIcon(Class.class.getResource("grassLands.png"));
                        grid= new JButton("",img);
                        setRolloverIcon(img);
                    case("lakes"):
                        img=new ImageIcon(Class.class.getResource("lakes.png"));
                        grid= new JButton("",img);
                        setRolloverIcon(img);
                    case("mines"):
                        img=new ImageIcon(Class.class.getResource("mines.png"));grid= new JButton("",img);
                        setRolloverIcon(img);
                    case("swamps"):
                        img=new ImageIcon(Class.class.getResource("swamps.png"));
                        grid= new JButton("",img);
                        setRolloverIcon(img);

                }
                this.setSize(20,20);
            }
        
        }

        //color palette2 setting 
        if(NewGameSetUp.getPalette().equals("Color Palette2")){
            if(NewGameSetUp.getDifficulty().equals("Easy")){
                setColor();
                this.setSize(20,20);
            }
            if(NewGameSetUp.getDifficulty().equals("Hard")){
                setColor();
                this.setSize(10,10);
            }
        
        }
             
        
    }

  
    public double getId()
    {
        // put your code here
        return this.id;
    }
    // double[] wheatFields={1.0,1.1,2.0,2.1,13.0,14.0,15.0,16.0,19.0,20.0,21.0,22.0,23.0,24.1,25.1,26.1,27.1,30.1,31.1,36.0,40.1,43.0,38.0,41.0,45.1,48.0};
    // public void setBackground(){
    //     for(double i: wheatFields){
    //         if(getId()==i){
    //         }
    //     }
    // }

    public void setName()
    {
        // put your code here
        if(this.id==1.0||this.id==1.1||this.id==2.0||this.id==2.1||this.id==13.0||this.id==14.0||this.id==15.0||
        this.id==16.0||this.id==19.0||this.id==20.0||this.id==21.0||this.id==22.0||this.id==23.0||this.id==24.1||
        this.id==25.1||this.id==26.1||this.id==27.1||this.id==30.1||this.id==31.1||this.id==36.0||this.id==40.1||
        this.id==43.0||this.id==38.0||this.id==41.0||this.id==45.1||this.id==48.0){
        	this.name= "wheatFields";
    }
    
    if(this.id==3.0||this.id==3.1||this.id==4.0||this.id==4.1||this.id==4.0||this.id==5.1||this.id==6.0||
        this.id==6.1||this.id==13.1||this.id==17.0||this.id==18.0||this.id==19.1||this.id==24.0||this.id==25.0||
        this.id==26.0||this.id==27.0||this.id==28.0||this.id==29.0||this.id==32.1||this.id==33.1||this.id==34.1||
        this.id==35.1){
            this.name="forests";
    }
    
    if(this.id==10.0||this.id==10.1||this.id==11.0||this.id==11.1||this.id==15.1||this.id==18.1||this.id==21.1||
        this.id==29.1||this.id==36.1||this.id==39.0||this.id==37.1||this.id==41.1||this.id==42.1||this.id==44.0
        ){
            this.name="grassLands";
    }
    
    if(this.id==8.0||this.id==8.1||this.id==7.0||this.id==7.1||this.id==9.0||this.id==9.1||this.id==14.1||
        this.id==17.1||this.id==20.1||this.id==28.1||this.id==30.0||this.id==31.0||this.id==32.0||this.id==33.0||
        this.id==34.0||this.id==35.0||this.id==37.0||this.id==42.0){
            this.name="lakes";
    }
    
    if(this.id==23.1||this.id==40.0||
        this.id==44.1||this.id==45.0||this.id==46.1||
        this.id==47.1||this.id==48.1){
            this.name="mines";
    }

    if(this.id==12.0||this.id==12.1||this.id==16.1||this.id==22.1||this.id==39.1||
        this.id==43.1||this.id==38.1||this.id==46.0||this.id==47.0){
            this.name="swamps";
    }
    }
    public String getName(){
        return this.name;
    }
    public void setColor() {
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

