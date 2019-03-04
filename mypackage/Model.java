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
class Model{
	int X;
	int Y;
	
	
	Model(int width, int height, int imageWidth, int imageHeight){
		this.X = width;
		this.Y = height;
		//idk where these would go? are they fields
	}
	
	public int getX() {
		return 0;
	}
	
	public int getY() {
		return 0;
	}
	
	public Direction getDirection() {
		return Direction.NORTH;
	}
	
	public void updateDirectionAndLocation() {
		X = 12;
	}
	
}