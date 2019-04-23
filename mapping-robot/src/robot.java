import java.io.*;
import java.math.*;
import java.util.Scanner;

public class robot{

	public static void main(String[] args){

      	//Coordinates: {x,y}
	    int[] destination = {0,0};
      
		//User enters robot data
	    Scanner robotInput = new Scanner(System.in);
	    System.out.println("Enter robot data:");
	    String data = robotInput.nextLine();
	    
	    //Uncomment for sample input
		//String data = "2019-04-22; Rightpoint; L3, L2, R4, R2, L2, L4, R2, L4, L1, R2, R3";
		
		//Split data into sections to be analyzed and used later
		String[] sections = data.split(";");
		String date = sections[0];
		String destName = sections[1];
		
		//Call method to find the destination coordinates using the robots directions
		destination = destinationCoords(sections[2]);
		
		String vertical = "";
		String horizontal = "";
		
		//Compile direct route based on destination coordinates
		if (destination[1] < 0) {
			vertical = " L" + Math.abs(destination[1]) + ",";
			if(destination[0] < 0) {
				horizontal = " R" + Math.abs(destination[0]);
			}
			else {
				horizontal = " L" + Math.abs(destination[0]);
			}
		}
		else {
			vertical = " R" + Math.abs(destination[1]) + ",";
			if(destination[0] < 0) {
				horizontal = " L" + Math.abs(destination[0]);
			}
			else {
				horizontal = " R" + Math.abs(destination[0]);
			}
		}
		
		
		//Print out proper output with output, destination name, and direct route directions
		System.out.print(date + ";" + destName + ";" + vertical + horizontal);

	}
	
	
	
	/* destinationCoords method is used to find the destination coordinates based on robot directions
	 * 
	 * String input - unparsed string containing robot directions
	 */
	static int[] destinationCoords(String input){
		
		//Create RobotLocation object to keep track of the current direction the robot faces and its coordinates
		int[] baseCoords = {0,0};
		RobotLocation current = new RobotLocation(0, baseCoords);
		
		//Split list of directions into individual directions
		String[] directions = input.split(",");

		//Based on current direction, call method to set next direction and coordinates 
		for (int i = 0; i < directions.length; i++){
			String[] chars = directions[i].split("");
			if (current.getDirection() == 0){
				current = west(chars, current);
			}
			else if(current.getDirection() == 1){
				current = north(chars, current);
			}
			else if(current.getDirection() == 2){
				current = east(chars, current);
			}
			else if(current.getDirection() == 3){
				current = south(chars, current);
			}
		}
      return current.getCoordinates();
	}

	
	/* west, north, east, and south methods used to correctly assign the next direction, and update the current coordinates
	 * 
	 * String[] chars - contains "L" or "R" direction, and number of blocks
	 * RobotLocation current - object containing current information
	 */
	static RobotLocation west(String[] chars, RobotLocation current){
		if (chars[1].equals("L")){
			current.setDirection(3);
			current.setY(current.getY() - Integer.parseInt(chars[2]));
		}
		else if (chars[1].equals("R")){
			current.setDirection(1);
			current.setY(current.getY() + Integer.parseInt(chars[2]));
		}
		return current;
	}

	static RobotLocation north(String[] chars, RobotLocation current){
		if (chars[1].equals("L")){
			current.setDirection(0);
			current.setX(current.getX() - Integer.parseInt(chars[2]));
		}
		else if (chars[1].equals("R")){
			current.setDirection(2);
			current.setX(current.getX() + Integer.parseInt(chars[2]));
		}
		return current;
	}

	static RobotLocation east(String[] chars, RobotLocation current){
		if (chars[1].equals("L")){
			current.setDirection(1);
			current.setY(current.getY() + Integer.parseInt(chars[2]));
		}
		else if (chars[1].equals("R")){
			current.setDirection(3);
			current.setY(current.getY() - Integer.parseInt(chars[2]));
		}
		return current;
	}

	static RobotLocation south(String[] chars, RobotLocation current){
		if (chars[1].equals("L")){
			current.setDirection(2);
			current.setX(current.getX() + Integer.parseInt(chars[2]));
		}
		else if (chars[1].equals("R")){
			current.setDirection(0);
			current.setX(current.getX() - Integer.parseInt(chars[2]));
		}
		return current;
	}
}