import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class person{
	private Image forward, backward, left, right; 	
	private AffineTransform tx;
	//attributes of this class
	int hopLen = 70;
	int dir = 0; 					//0-forward, 1-backward, 2-left, 3-right
	int width, height;
	int x, y;						//position of the object
	int vx, vy;						//movement variables
	double scaleWidth = .06;		//change to scale image
	double scaleHeight = .06; 		//change to scale image

	public person() {
		//load the main image(front or forward view)
		forward 	= getImage("/imgs/"+"Person2.png"); //load the image for Tree
		//backward 	= getImage("/imgs/"+"backward.png"); //load the image for Tree
		//left 		= getImage("/imgs/"+"left.png"); //load the image for Tree
		//right 		= getImage("/imgs/"+"right.png"); //load the image for Tree

		//alter these
		width = 50;
		height = 50;
		
		x = 600;
		y = 900;
		vx = 0;
		vy = 0;
		
		tx = AffineTransform.getTranslateInstance(0, 0);
		
		init(x, y); 				//initialize the location of the image
									//use your variables
		
	}
	
	public person(int x, int y) {
		//call the degault contructor for all the normal stuff
		this();
		//do the specific task for THIS constructor
		this.x = x;
		this.y = y;
	}

	
	public void move(int dir) {
		
		switch(dir) {
		case 0://hop up
			y-= hopLen;//move up a body length
			
			
			break;
		case 1://hop down
			y+=hopLen; //move down a body length
			
			
			break;
		case 2:
			//hop left
			x-=50;
			break;
			
			
		case 3:
			//hop right
			x+=50;
			break;
			
			
		}
	}
	
	public int getX() {
		return x;
		
	}
	
	public int getY() {
		return y;
	}
	public int getVx() {
		return vx;
	}
	public int getVy() {
		return vy;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public void setVx(int newvx) {
		vx = newvx;
	}
	public void setVy(int newvy) {
		vy = newvy;
	}
	
	
	
	//2nd constructor- allow seting cx and y during contruction
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		x+=vx;
		y+=vy;	
		
		init(x,y);
		//for infinite scrolling- teleport to the other side
		//once it leaves the other side
		
		
		g2.drawImage(forward, tx, null);
		if(Frame.debugging) {
			//g.setColor(Color.green);
			//g.drawRect(x, y, width, height);
		}
		
		/*switch(dir) {
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
*/
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(scaleWidth, scaleHeight);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = person.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
