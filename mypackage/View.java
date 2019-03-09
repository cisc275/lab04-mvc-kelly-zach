package mypackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.imageio.ImageIO;

/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/
class View{ //extends jpanel ?????

    BufferedImage[] picsWest;
    BufferedImage[] picsEast;
    BufferedImage[] picsNorth;
    BufferedImage[] picsSouth;
    BufferedImage[] picsSWest;
    BufferedImage[] picsSEast;
    BufferedImage[] picsNWest;
    BufferedImage[] picsNEast;
    final int frameCount = 10;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
    final static int frameWidth = 500;
    final static int frameHeight = 300;
    int picNum = 0;
	
	public View() {
    	BufferedImage img = createImage("west"); //for west direction
    	picsWest = new BufferedImage[10];
    	for(int i = 0; i < frameCount; i++)
    		picsWest[i] = img.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	
    	BufferedImage img2 = createImage("east"); //for east direction
    	picsEast = new BufferedImage[10];
    	for(int i = 0; i < frameCount; i++)
    		picsEast[i] = img2.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	
    	BufferedImage img3 = createImage("north"); //for north direction
    	picsNorth = new BufferedImage[10];
    	for(int i = 0; i < frameCount; i++)
    		picsNorth[i] = img3.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	
    	BufferedImage img4 = createImage("south"); //for south direction
    	picsSouth = new BufferedImage[10];
    	for(int i = 0; i < frameCount; i++)
    		picsSouth[i] = img4.getSubimage(imgWidth*i, 0, imgWidth, imgHeight); 
    	
    	BufferedImage img5 = createImage("southwest"); //for south-west direction
    	picsSWest = new BufferedImage[10];
    	for(int i = 0; i < frameCount; i++)
    		picsSWest[i] = img5.getSubimage(imgWidth*i, 0, imgWidth, imgHeight); 
    	
    	BufferedImage img6 = createImage("southeast"); //for south-east direction
    	picsSEast = new BufferedImage[10];
    	for(int i = 0; i < frameCount; i++)
    		picsSEast[i] = img6.getSubimage(imgWidth*i, 0, imgWidth, imgHeight); 
    	
    	BufferedImage img7 = createImage("northwest"); //for north-west direction
    	picsNWest = new BufferedImage[10];
    	for(int i = 0; i < frameCount; i++)
    		picsNWest[i] = img7.getSubimage(imgWidth*i, 0, imgWidth, imgHeight); 
    	
    	BufferedImage img8 = createImage("northeast"); // for north-east direction
    	picsNEast = new BufferedImage[10];
    	for(int i = 0; i < frameCount; i++)
    		picsNEast[i] = img8.getSubimage(imgWidth*i, 0, imgWidth, imgHeight); 
	}
	
    private BufferedImage createImage(String dir){
    	String orcFileString = "images/orc/orc_forward_" + dir + ".png";
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File(orcFileString));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    	
    	// TODO: Change this method so you can load other orc animation bitmaps
    }
    
    public void update(int x, int y, Direction dir) {
    	
    }
    
    public void paint(Graphics g) {
        picNum = (picNum + 1) % frameCount;
        g.drawImage(findDirection(goNorth,goEast)[picNum], getX()+=xIncr*xDir, yloc+=yIncr*yDir, Color.gray, this);
    }
	
	public int getWidth(){
		return frameWidth;
	}
	public int getHeight() {
		return frameHeight;
	}
	public int getImageWidth() {
		return imgWidth;
	}
	public int getImageHeight() {
		return imgHeight;
	}
}