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
	int X =50; 
	int Y = 50;
    int xIncr = 8;
    int yIncr = 2;
    int imgX;
	int imgY;
    int frameWidth = 500;
    int frameHeight = 300;
	Direction dir = Direction.NORTHEAST;
	
	Model(int width, int height, int imageWidth, int imageHeight){
		this.frameWidth = width;
		this.frameHeight = height;
		this.imgX = imageWidth;
		this.imgY = imageHeight;
		//idk where these would go? are they fields
	}
	
	public Direction getDirect() {
		return dir;
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
	
	public void updateLocationAndDirection() {
		int frameXSize = frameWidth - imgX; //adjust for image size 
    	int frameYSize = frameHeight - imgY;
		
    	//update direction
    	
    	if (this.X >= frameXSize) {//touch the right-side frame
    		if (this.dir == Direction.EAST) { //straight east
    			this.dir = Direction.WEST;    //bounce to west
    		}
    		if (this.dir == Direction.SOUTHEAST) {//from south-east
    			this.dir = Direction.SOUTHWEST;   //bounce to south-west
    		}
    		if (this.dir == Direction.NORTHEAST) {//from north-east
    			this.dir = Direction.NORTHWEST;   //bounce to north-west
    		}
    	} 
    	else if (this.X <= 0){ //touch the left-side frame
    		if (this.dir == Direction.WEST) { //straight west
    			this.dir = Direction.EAST;    //bounce to east
    		}
    		if (this.dir == Direction.SOUTHWEST) { //from south-west
    			this.dir = Direction.SOUTHEAST;    //bounce to south-east
    		}
    		if (this.dir == Direction.NORTHWEST) { //from north-west
    			this.dir = Direction.NORTHEAST;    //bounce to north-east
    		}
    	}
    	if (this.Y >= frameYSize) {//touch the down-side frame
    		if (this.dir == Direction.SOUTH) { //straight south
    			this.dir = Direction.NORTH;    //bounce to north
    		}
    		if (this.dir == Direction.SOUTHWEST) {// from south-west
    			this.dir = Direction.NORTHWEST;   //bounce to north-west
    		}
    		if (this.dir == Direction.SOUTHEAST) {//from south-east
    			this.dir = Direction.NORTHEAST;   //bounce to north-east
    		}
    	} 
    	else if (this.Y <= 0){//touch the up-side frame
    		if (this.dir == Direction.NORTH) {//straight north
    			this.dir = Direction.SOUTH;   //bounce to south
    		}
    		if (this.dir == Direction.NORTHEAST) { //from the north-east
    			this.dir = Direction.SOUTHEAST;    //bounce to north-west
    		}
    		if (this.dir == Direction.NORTHWEST) { //from the north-west
    			this.dir = Direction.SOUTHWEST;    //bounce to south-west
    		}
    	}
    	
    	//update location
    	switch (dir) {
    	case NORTH:
    		Y -= yIncr;
    		break;
    	case NORTHEAST:
    		Y -= yIncr;
    		X += xIncr;
    		break;
    	case EAST:
    		X += xIncr;
    		break;
    	case SOUTHEAST:
    		X += xIncr;
    		Y += yIncr;
    		break;
    	case SOUTH:
    		Y += yIncr;
    		break;
    	case SOUTHWEST:
    		X -= xIncr;
    		Y -= yIncr;
    		break;
    	case WEST:
    		X -= xIncr;
    		break;
    	case NORTHWEST:
    		X -= xIncr;
    		Y -= yIncr;
    		break;
    	}
	}
	
}