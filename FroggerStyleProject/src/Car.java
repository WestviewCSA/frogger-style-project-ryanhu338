/*import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Car{
	private Image forward, backward, left, right; 	
	private AffineTransform tx;
	//attributes of this class
	int dir = 0; 					//0-forward, 1-backward, 2-left, 3-right
	int width, height;
	int x, y;						//position of the object
	int vx, vy;						//movement variables
	double scaleWidth = .25;		//change to scale image
	double scaleHeight = .25; 		//change to scale image

	public Car() {
		//load the main image(front or forward view)
		forward 	= getImage("/imgs/"+"snowman.png"); //load the image for Tree
		//backward 	= getImage("/imgs/"+"backward.png"); //load the image for Tree
		//left 		= getImage("/imgs/"+"left.png"); //load the image for Tree
		//right 		= getImage("/imgs/"+"right.png"); //load the image for Tree

		//alter these
		width = 100;
		height = 100;
		
		x = 600/2-width/2;
		y = 600;
		vx = 0;
		vy = 0;
		
		tx = AffineTransform.getTranslateInstance(0, 0);
		
		init(x, y); 				//initialize the location of the image
									//use your variables
		
	}
	
	public void move(int dir) {
		
		switch(dir) {
		case 0://hop up
			y-= height;//move up a body length
			
			
			break;
		case 1://hop down
			y+=height; //move down a body length
			
			
			break;
		case 2:
			break;//hop left
			x-=width;
			
			
		case 3:
			break;//hop right
			x+=width;
			
			
		}
	}
	
	public int getX() {
		return x;
		
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	
	
	//Collision detection with main character class
	public boolean collided(person character) {
		//represent each object as a reactagle
		//then check if they are intersecting
		
		Rectangle main = new Rectangle();
		
		character.getX();
		character.getY();
		character.getWidth();
		character.getHeight();
		
		Rectangle thisObject = new Rectangle(x,y,width,height);
		//use bult in method to check intersecion(collision)
		return main.intersects(thisObject);
	}
	
	
	
	
	//2nd constructor- allow seting cx and y during contruction
	public Car(int x, int y) {
		//call the degault contructor for all the normal stuff
		this();
		//do the specific task for THIS constructor
		this.x = x;
		this.y = y;
	}

	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		x+=vx;
		y+=vy;	
		
		
		//for infinite scrolling- teleport to the other side
		//once it leaves the other side
		
		
		g2.drawImage(forward, tx, null);
		if(Frame.debugging) {
			g.setColor(Color.green);
			g.drawRect(x, y, width, height);
		}
		
		switch(dir) {
		case 0:
			g2.drawImage(forward, tx, null);
			break;
		case 1:
			g2.drawImage(backward, tx, null);

			break;
		case 2:
			g2.drawImage(left, tx, null);

			break;
		case 3:
			g2.drawImage(right, tx, null);
			break;
		}

	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(scaleWidth, scaleHeight);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Car.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}

*/
