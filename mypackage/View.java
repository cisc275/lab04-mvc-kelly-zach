package mypackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

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
class View extends JPanel{

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
    Direction dir;
	int X;
	int Y;
	JFrame frame;
	
	public View() {
		BufferedImage[] images = {
                createImage(new File("images/orc/orc_forward_east.png")),
                createImage(new File("images/orc/orc_forward_north.png")),
                createImage(new File("images/orc/orc_forward_northeast.png")),
                createImage(new File("images/orc/orc_forward_northwest.png")),
                createImage(new File("images/orc/orc_forward_south.png")),
                createImage(new File("images/orc/orc_forward_southeast.png")),
                createImage(new File("images/orc/orc_forward_southwest.png")),
                createImage(new File("images/orc/orc_forward_west.png"))
        };
       
        //split the images into their individual frames
        picsEast = splitImage(images[0]);
        picsNorth = splitImage(images[1]);
        picsNEast = splitImage(images[2]);
        picsNWest = splitImage(images[3]);
        picsSouth = splitImage(images[4]);
        picsSEast = splitImage(images[5]);
        picsSWest = splitImage(images[6]);
        picsWest = splitImage(images[7]);
        // TODO: Change this constructor so that at least eight orc animation pngs are loaded
        frame = new JFrame();
		frame.getContentPane().add(this);
    	frame.setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(frameWidth, frameHeight);
    	frame.setVisible(true); 
    } 
   
    //Helper function - splits the given image into 10 parts and returns an array of them
    private BufferedImage[] splitImage(BufferedImage image) {
        BufferedImage[] splitImage = new BufferedImage[10];
        for(int i = 0; i < frameCount; i++)
            splitImage[i] = image.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
        return splitImage;
    }
	
    private BufferedImage createImage(File file){
        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(file);
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
        }
   	System.out.println(new File("orcFileString").exists());
   	System.out.println(new File("images/orc/orc_forward_west.png").exists());
   	//System.out.println(orcFileString);
   	System.out.println("images/orc/orc_forward_west.png");
    	return null;
    	
    	// TODO: Change this method so you can load other orc animation bitmaps
    }
    
    public void update(int x, int y, Direction newDir) {
    	this.X = x;
    	this.Y = y;
    	this.dir = newDir;
    	this.frame.repaint();
    	try {
    		Thread.sleep(100);
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
    	
    }
    
    public void paint(Graphics g) {
        picNum = (picNum + 1) % frameCount;
        g.drawImage(findDirection()[picNum], X, Y, Color.gray, this);
    }
	
    private BufferedImage[] findDirection() {
    	if (this.dir == Direction.EAST) {
    		return this.picsEast;
    	} else if (this.dir == Direction.SOUTHEAST) {
    		return this.picsSEast;
    	} else if (this.dir == Direction.SOUTH) {
    		return this.picsSouth;
    	} else if (this.dir == Direction.SOUTHWEST) {
    		return this.picsSWest;
    	} else if (this.dir == Direction.WEST) {
    		return this.picsWest;
    	} else if (this.dir == Direction.NORTH) {
    		return this.picsNorth;
    	} else if (this.dir == Direction.NORTHEAST) {
    		return this.picsNEast;
    	} else if (this.dir == Direction.NORTHWEST) {
    		return this.picsNWest;
    }
    return this.picsEast;
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