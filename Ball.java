
/**
 * Ball object for the Polya Urn simulation
 * @author Dave Montalvo
 */
public class Ball {
	private String color;
	
	/**
	 * Create a ball and set its color
	 */
	public Ball(String color){
		this.color = color;
	}
	
	/*
	 * return a ball's color
	 */
	public String getColor(){
		return color;
	}
}