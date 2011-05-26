import java.util.*;

/**
 * A simulation of the Polya Urn Scheme
 * @author Dave Montalvo
 *
 */
public class Polya {
	private Vector<Ball> urn = new Vector<Ball>();
	// initial and setup conditions
	private int redBalls;
	private int greenBalls;
	private int cBalls;
	private int steps;
	
	// count of red/green balls in urn updated at each step
	private int redCount;
	private int greenCount;
	
	/**
	 * Constructor for Polya simulation. 
	 * Sets initial conditions.
	 */
	public Polya(int red, int green, int c, int steps){
		this.redBalls = red;
		this.redCount = red;
		this.greenBalls = green;
		this.greenCount = green;
		this.cBalls = c;
		this.steps = steps;
	}
	
	/*
	 * add initial contents to urn
	 */
	public void initializeUrn(){
		int counter;
		for (counter = 0; counter < redBalls; counter++){
			urn.add(new Ball("red"));
		}
		for (counter = 0; counter < greenBalls; counter++){
			urn.add(new Ball("green"));
		}				
	}
	
	/*
	 * Adds c balls to urn of specified color
	 * at each step during the simulation
	 */
	public void addBalls(String color){
		int counter;
		for (counter = 0; counter < cBalls; counter++){
			urn.add(new Ball(color));
		}
	}
	
	/*
	 * At every 100th step, beginning with step 0,
	 * output the state of the urn
	 */
	public void peek(int step){		
		step += 1; // convert 0-999 to 1-1000
		if (step % 100 == 0) {
		print(step + " RED: r = " + redCount +
				" g = " + greenCount + 
				" total = " + urn.size());
		}	
	}
	
	/*
	 * Runs simulation on initialzed urn. 
	 * Uses a random number generated between
	 * 0 and the (size of urn)-1 to chose a ball.
	 * Outputs contents of urn at each step
	 */
	public void runSimulation(){
		Random random = new Random();
		int counter;
		int pick;
		String chosenColor;
		// output initial conditions before we start picking
		// balls from the urn
		print("Initial conditions\n\t r = " + redCount + 
				"\n\t g = " + greenCount + 
				"\n\t c = " + cBalls +
				"\n\t total = " + urn.size() +
				"\n\t steps = " + steps);		
		for (counter = 0; counter < steps; counter++){
			this.peek(counter); // output the state of the urn
			pick = random.nextInt(urn.size()); // choose a ball
			chosenColor = urn.elementAt(pick).getColor(); // note its color
			if (chosenColor == "red") {
				addBalls("red"); // add c red balls to urn
				redCount += cBalls; // increment count of red balls
			}
			if (chosenColor == "green") {
				addBalls("green"); // add c green balls to urn
				greenCount += cBalls; // increment count of green balls
			}			
		} // end for
	}	
	
	/*
	 * Shortcut helper for output
	 */
	public void print(Object o){
		System.out.println(o);
	}
	
	public static void main(String[] args){
		int steps = 1000;
		
		// Trial 1
		int r_1 = 5;
		int g_1 = 16;
		int c_1 = 3;
		Polya trial_1 = new Polya(r_1, g_1, c_1, steps);		
		trial_1.initializeUrn();
		trial_1.runSimulation();
	}
}