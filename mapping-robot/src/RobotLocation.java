/* RobotLocation class creates an object that keeps track of the robots direction and current coordinates
 * 
 * get and set methods used to alter x,y coordinates and the current direction
 */

public class RobotLocation extends robot{
	private int direction;
	private int[] coordinates;
	
	public RobotLocation(int direction, int[] coordinates) {
		this.direction = direction;
		this.coordinates = coordinates;
	}
	
	public int getDirection() {
		return this.direction;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public int getX() {
		return this.coordinates[0];
	}
	
	public void setX(int x) {
		this.coordinates[0] = x;
	}
	
	public int getY() {
		return this.coordinates[1];
	}
	
	public void setY(int y) {
		this.coordinates[1] = y;
	}
	
	public int[] getCoordinates() {
		return this.coordinates;
	}
	
	public void setCoordinates(int[] coordinates) {
		this.coordinates = coordinates;
	}
	
}
