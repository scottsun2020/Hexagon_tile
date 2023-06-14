/* Your Name (Scott Sun)
 * Your Course Number (CS2023)
 * Your Section Numbers: 03
 * Description: This class is to create a Hexagon class and store all the txt data into array of String and 
 *  			also the solution
 * Other Comments: no commends
 */

public class Hexagon {
	private String[] colors;
	private int tileNum;
	
	public Hexagon(int size, int tileNum, String...value) {
		this.colors = new String[size];
		this.tileNum = tileNum;
		
		for(int i = 0; i < colors.length; i++) {
			colors[i] = value[i];
		}
	}
	

	public String get(int index) {

		return this.colors[index];

	}
	

	
	// right shift some elements and connect to the end of array.
	public void rotate() {


			// take the last item in the array
			String temp = this.colors[this.colors.length - 1];
			int i;

			// shift the rest of array by 1
			for (i = 0; i < this.colors.length - 1; i++) {

				this.colors[this.colors.length - 1 - i] = this.colors[this.colors.length - 2 - i];

			}

			// put back the last item to the top
			this.colors[0] = temp;

		
	}
	
	// get the size of Array
	public int size() {

		return this.colors.length;
	}
	
	

	
	@Override
	public String toString() {
		String output = "";
		output += " Tile #" + this.tileNum + ": ";
		for (int i = 0; i < this.colors.length; i++) {
			output += this.colors[i] + "   ";
		}
		//output = output.replaceAll(", $", "");
		return output;
	
	}

}
