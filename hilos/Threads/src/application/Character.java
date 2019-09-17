package application;

import java.net.URL;

public class Character implements Runnable{

	
	public static double LIMIT = 800;
	public static double MOVE = 15;
	
	
	private URL image;
	private double posx;
	private double posy;
	
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	
	public Character(int posx, int posy) {
		this.posx = posx;
		this.posy = posy;
		this.left = false;
		this.right = false;
		this.up = false;
		this.down = false;
		
	}


	@Override
	public void run() {
		while(true)
			try {
				if(left == true) {
					moveLeft();
				}if(right == true) {
					moveRigth();
				}if(up = true) {
					moveUp();
				}if(down == true) {
					moveDown();
				}
				
				
				
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	
	
	
	
	
	public boolean isLeft() {
		return left;
	}


	public void setLeft(boolean left) {
		this.left = left;
	}


	public boolean isRight() {
		return right;
	}


	public void setRight(boolean right) {
		this.right = right;
	}


	public boolean isUp() {
		return up;
	}


	public void setUp(boolean up) {
		this.up = up;
	}


	public boolean isDown() {
		return down;
	}


	public void setDown(boolean down) {
		this.down = down;
	}


	public void moveLeft() {
		posx -= MOVE;
		if(posx<=0) posx = 0;
	}
		
	public void moveRigth() {
		posx += MOVE;
		if(posx>=LIMIT) posx= LIMIT;
	}
	
	
	public void moveUp() {
		posy -= MOVE;
		if(posy<=0) posy = 0;
	}
	
	
	public void moveDown() {
		posy += MOVE;
		if(posy>=400) posy=400;
	}
	
	

	public URL getImage() {
		return image;
	}


	public void setImage(URL image) {
		this.image = image;
	}


	public double getPosx() {
		return posx;
	}


	public void setPosx(double posx) {
		this.posx = posx;
	}


	public double getPosy() {
		return posy;
	}


	public void setPosy(double posy) {
		this.posy = posy;
	}
	
	
	
	
	
}
