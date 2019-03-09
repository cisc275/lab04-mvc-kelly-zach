package mypackage;
/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/

//where does jpanel fit into this ..?

class Model{
	int X;
	int Y;
	int imgX;
	int imgY;
	
	Model(int width, int height, int imageWidth, int imageHeight){
		this.X = width;
		this.Y = height;
		this.imgX = imageWidth;
		this.imgY = imageHeight;
		//idk where these would go? are they fields
	}
	
	public Direction getDirect() {
		return Direction.NORTH;
	}
	
	public int getX() {
		return X;
	}
	
	public int getY() {
		return Y;
	}
	
	public int getImgX() {
		return imgX;
	}
	public int getImgY() {
		return imgY;
	}
	public Direction getDirection() {
		return Direction.NORTH;
	}
	
	public void updateLocationAndDirection() {
		this.X += 12;
	}
	
}