import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	public static boolean debugging = true;
	//Timer related variables
	int waveTimer = 5; //each wave of enemies is 20s
	long ellapseTime = 0;
	Font timeFont = new Font("Courier", Font.BOLD, 70);
	int level = 0;
	int deaths =0; 
	
	Font myFont = new Font("Courier", Font.BOLD, 12);
	SimpleAudioPlayer backgroundMusic = new SimpleAudioPlayer("scifi.wav", true);
	
	//Declaring all my classes
//	Music soundBang = new Music("bang.wav", false);
//	Music soundHaha = new Music("haha.wav", false);
	Background Casino = new Background();
	Win win = new Win();
	//a row of car objects
	//CarScrolling[] row1 = new CarScrolling[4];
	ArrayList<CarScrolling> row1List = new ArrayList<CarScrolling>();

	CarScrolling[] row2 = new CarScrolling[5];

	//CarScrolling Car = new CarScrolling(100,200);
	
	
		public Font newfont = new Font("Courier", Font.BOLD, 30);
	PoliceScrolling[] row3 = new PoliceScrolling[5];
	PoliceScrolling[] row4 = new PoliceScrolling[4];
	
	
	
	ChipScrolling [] row5 = new ChipScrolling[5];
	ChipScrollingBack [] row6 = new ChipScrollingBack[5];
	ChipScrolling2 [] row7 = new ChipScrolling2[5];

	PoliceBaton[] row8 = new PoliceBaton[5];
	PoliceTazer[] row9 = new PoliceTazer[5];



	
	person Person = new person();

	//frame width/height
	int width = 1000;
	int height = 1038;	
	
	
	
	
	//began to paint the objects, begining with the background
	public void paint(Graphics g) {
		g.setFont(newfont);
		super.paintComponent(g);
			//pain the other objects on the screen
		Casino.paint(g);

		g.drawString("Deaths:"+deaths, 800, 980);

		for(CarScrolling obj: row1List) {
			obj.paint(g);//for every Car obj in row1List
		}
		for(CarScrolling obj: row1List) {
			//invoke the collided method for your 
			//class- pass the main character
			//as our argument
			if(obj.collided(Person)) {
						deaths++;


				Person.x = 600;
				Person.y = 900;
			}
		}
		
		//have the row objects paint on the screen
	/*	for(CarScrolling obj : row1) {
			obj.paint(g);
		}
		
		
		//collision detection
		for(CarScrolling obj: row1) {
			//invoke the collided method for your 
			//class- pass the main character
			//as our argument
			if(obj.collided(Person)) {

				Person.x = 600;
				Person.y = 900;
			}
		}*/
		//ADDED
		
		
	
	 for(CarScrolling obj : row2) {
			obj.paint(g);
		}
		
		//collision detection
		for(CarScrolling obj: row2) {
			//invoke the collided method for your 
			//class- pass the main character
			//as our argument
			if(obj.collided(Person)) {
						deaths++;

				Person.x = 600;
				Person.y = 900;
			}
		}
		
	
		
		for(PoliceScrolling obj : row3) {
			obj.paint(g);
		}
		
		//collision detection
		for(PoliceScrolling obj: row3) {
			//invoke the collided method for your 
			//class- pass the main character
			//as our argument
			if(obj.collided(Person)) {
						deaths++;

				Person.x = 600;
				Person.y = 900;
			}
		}
		
		for(PoliceScrolling obj : row4) {
			obj.paint(g);
		}
		
		//collision detection
		for(PoliceScrolling obj: row4) {
			//invoke the collided method for your 
			//class- pass the main character
			//as our argument
			if(obj.collided(Person)) {
						deaths++;

				Person.x = 600;
				Person.y = 900;
			}
		}
		
		//ADDED 2nd rows of objects

		for(PoliceBaton obj: row8) {
			obj.paint(g);
		}
		
		//collision detection
		for(PoliceBaton obj: row8) {
			//invoke the collided method for your 
			//class- pass the main character
			//as our argument
			if(obj.collided(Person)) {
				deaths++;

				Person.x = 600;
				Person.y = 900;
				System.out.println("COLLIDED");

			}
		}
		for(PoliceTazer obj: row9) {
			obj.paint(g);
		}
		for(PoliceTazer obj: row9) {
			//invoke the collided method for your 
			//class- pass the main character
			//as our argument
			if(obj.collided(Person)) {
				deaths++;

				Person.x = 600;
				Person.y = 900;
				System.out.println("COLLIDED");
			}
		}
		
		for(ChipScrolling obj: row5) {
			obj.paint(g);
		}
		for(ChipScrollingBack obj: row6) {
			obj.paint(g);
		}
		for(ChipScrolling2 obj: row7) {
			obj.paint(g);
		}
		
		Person.paint(g);


		// COLLISION DETECTION
		//for each chip object in row5-8 array
		boolean riding = false;
		
	
		for(ChipScrolling obj: row5) {
			
			//for every object, invoke the collided method
			if(obj.collided(Person)) {
			Person.setVx(obj.getVx());
			riding = true;
			break;
			}
		}
		for(ChipScrollingBack obj: row6) {
			
			//for every object, invoke the collided method
			if(obj.collided(Person)) {
			Person.setVx(obj.getVx());
			riding = true;
			break;
			}
		}
		for(ChipScrolling2 obj: row7) {
	
			//for every object, invoke the collided method
			if(obj.collided(Person)) {
				Person.setVx(obj.getVx());
				riding = true;
				break;
				}
			}
		
		//maing character stops moving if not on a rideable object
		//but also lets limit it in the Y
		if(Person.getY()>600||Person.getY()<270) {
			Person.setVx(0);
			riding = false;

		}
		if(!riding && (Person.getY()<600 && Person.getY() > 300)/*change this number*/) {
			Person.setVx(0);
			deaths++;
			Person.x = 600;//change
			Person.y = 900;//change
			//riding = false;
			//Person.setVx(0);
		}
		
		/*
		if(Person.y<600) {
			Person.hopLen = 110;
		}
		if(Person.y<=220) {
			Person.hopLen = 55;
		}*/

		if(Person.y > 600) {
			Person.hopLen = 70;
		}
		

		if(Person.y<120&&Person.y >100&&Person.x>=370&&Person.x<=440) {
			win.paint(g);
		
			

		}
		
		if(Person.x == 600 && Person.y == 900) {
			Person.hopLen = 70;
			
		}
		if(Person.y + Person.height<50) {
			Person.y = 100;
		}
	}

	
	
	public static void main(String[] arg) {
		Frame f = new Frame();
		
	}
	//where to seet the person when reset person is called(when he dies)
	public void resetPerson() {
		Person.setVx(0);
		Person.x = 600;//change
		Person.y = 900;
		/*if(lives.size()>0) {
			lives.remove(lives.size()-1);
		}*/
	}
	
	public Frame() {
		JFrame f = new JFrame("Duck Hunt");
		f.setSize(new Dimension(width, height));
		f.setBackground(Color.white);
		f.add(this);
		f.setResizable(false);
 		f.addMouseListener(this);
		f.addKeyListener(this);
	
		//backgroundMusic.play();

		
		/*
		  set up an 1d array here- create the objects that go in them
		 */
		//traverse the array
		/*for(int i = 0; i < row1.length; ++i) {
			row1[i] = new CarScrolling(i*290, 750);
		}*/
		
		//painting all the rows
		for(int i = 0; i < 4; ++i) {
			this.row1List.add(new CarScrolling(i*290, 750));
		}
		
		
		/* Start with  attemps
		  for(int i = 0; i < 6; ++i){
		 this.lives.add(new LifeImage(i*180, 100);
		}
		 
		 
		 */
		for(int i = 0; i < row2.length; ++i) {
			row2[i] = new CarScrolling(i*310, 610);
		}

		
		
		//ADDED
		for(int i = 0; i < row3.length; ++i) {
			row3[i] = new PoliceScrolling(i*290, 670);
		}
		
		for(int i = 0; i < row4.length; ++i) {
			row4[i] = new PoliceScrolling(i*350, 820);
		}
		
		for(int i = 0; i < row5.length; ++i) {
			row5[i] = new ChipScrolling(i*250, 320);
		}
		for(int i = 0; i < row6.length; ++i) {
			row6[i] = new ChipScrollingBack(i*370, 420);
		}
		for(int i = 0; i < row7.length; ++i) {
			row7[i] = new ChipScrolling2(i*350, 520);
		}
		
		
		
		
		
		
		
		
		for(int i = 0; i < row8.length; ++i) {
			row8[i] = new PoliceBaton(i*300, 160);
		}
		
		for(int i = 0; i < row9.length; ++i) {
			row9[i] = new PoliceTazer(i*200, 160);
		}
		
		
		//the cursor image must be outside of the src folder
		//you will need to import a couple of classes to make it fully 
		//functional! use eclipse quick-fixes
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("torch.png").getImage(),
				new Point(0,0),"custom cursor"));	
		
		
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent m) {
		
	
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
		//CODE to change hop lengths according to distance on the map
		// TODO Auto-generated method stub
		System.out.println(arg0.getKeyCode());
		//move main character up
		if(arg0.getKeyCode() == 38) {
			if(Person.y<600) {
				Person.hopLen = 110;
			}
			if(Person.y<=220) {
				Person.hopLen = 55;
			}
			Person.move(0);//using the key codes
			System.out.println(Person.x);
			System.out.println(Person.y);
			
		}
		//enter key resets everything
		if(arg0.getKeyCode() == 10) {
 			Person.x = 600;
			Person.y = 900;
			
		}
			
		//moving up down left right
		if(arg0.getKeyCode() == 40 && Person.y==550) {
			Person.hopLen = 70;
			Person.move(1);//using the key codes
			System.out.println(Person.x);
			System.out.println(Person.y);
			System.out.println("here");

		}
		else if(arg0.getKeyCode() == 40) {
			Person.move(1);//using the key codes
			System.out.println(Person.x);
			System.out.println(Person.y);
			if(Person.y>=220) {
				Person.hopLen = 110;
			}
		}
		
		if(arg0.getKeyCode() == 37) {
			Person.move(2);//using the key codes
			System.out.println(Person.x);
			System.out.println(Person.y);

		}
		if(arg0.getKeyCode() == 39) {
			Person.move(3);//using the key codes
			System.out.println(Person.x);
			System.out.println(Person.y);

		}
		
		//make sure that the person does not go over he boundries
		if(Person.x<0) {
			Person.x=0;
			
		}
		
		if(Person.x+Person.width >1000) {
			Person.x = 950;
		}
		
		if(Person.y + Person.height>950) {
			Person.y = 900;
		}
		
		
		if(Person.y<0) {
			Person.y = 0;
		}
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
