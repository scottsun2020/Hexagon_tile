import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/* Your Name (Scott Sun)
 * Your Course Number (CS2023)
 * Your Section Numbers: 03
 * Description: This class is to read txt file and make array to Hexagon to store and find solution
 * Other Comments: I have hard time for shared reference and at given tim
 */

public class Tester {
	private static int solutionNumber = 0;

	public static void main(String[] args) throws FileNotFoundException {

		// Create file object for txt file
		File file = new File("tileset3.txt");
		// use stringbuilder to read the txt into it
		StringBuilder sb = new StringBuilder();

		try {
			// Use Scanner to read file
			Scanner input = new Scanner(file);
			String name = "";
			// read from txt file
			while (input.hasNextLine()) {
				name = input.nextLine();
				// read line and add "space" between each tiles
				sb.append(name + " ");

			}

			// String split method by " "
			String textArray[] = sb.toString().split(" ");
			// String split method by ","
			String tile1Array[] = textArray[2].split(",");
			String tile2Array[] = textArray[5].split(",");
			String tile3Array[] = textArray[8].split(",");
			String tile4Array[] = textArray[11].split(",");
			String tile5Array[] = textArray[14].split(",");
			String tile6Array[] = textArray[17].split(",");
			String tile7Array[] = textArray[20].split(",");

			// create the instance of Hexagon for each tile
			Hexagon h1 = new Hexagon(tile1Array.length, 1, tile1Array);
			Hexagon h2 = new Hexagon(tile2Array.length, 2, tile2Array);
			Hexagon h3 = new Hexagon(tile3Array.length, 3, tile3Array);
			Hexagon h4 = new Hexagon(tile4Array.length, 4, tile4Array);
			Hexagon h5 = new Hexagon(tile5Array.length, 5, tile5Array);
			Hexagon h6 = new Hexagon(tile6Array.length, 6, tile6Array);
			Hexagon h7 = new Hexagon(tile7Array.length, 7, tile7Array);
			
			// put Hexagon instances TilesArray into array
			Hexagon tiles[] = new Hexagon[7];
			tiles[0] = h1;
			tiles[1] = h2;
			tiles[2] = h3;
			tiles[3] = h4;
			tiles[4] = h5;
			tiles[5] = h6;
			tiles[6] = h7;

			// create new Hexagon instances to store the solution posistions
			Hexagon positions[] = new Hexagon[7];
			// call the solve method for solution
			solve(tiles, positions);
			System.out.println();
			System.out.println("Total Solutions: " + solutionNumber);

		} catch (FileNotFoundException ex) {
			System.out.printf("ERROR: %s\n", ex);
		}
	}

	public static void solve(Hexagon tiles[], Hexagon positions[]) {
		
		solve(tiles, positions, 0);
		if (solutionNumber == 0) {
			System.out.println("No solution");
		}
	}
	
	//Recursive Helper Method
	public static void solve(Hexagon tiles[], Hexagon positions[], int filledPositions) {

		if (filledPositions == positions.length) {
				System.out.println("\nSolution #" + ++solutionNumber +"----------------------------------");
				System.out.printf("%24s%4s%4s%4s%4s%4s%n","SA","SB","SC","SD","SE","SF");		
			
				printSolution(positions);
				
				//for solution > 100
				//++solutionNumber;
			

		} else {// recursive case
			// assign each tile to each position
			for (int i = 0; i < tiles.length; i++) {

				// copy tile[i] without rotate to add back when backtracking
				Hexagon tileSaved = tiles[i];

				// No need to rotate the center tile which is position 0
				// if tiles length !=7 means that current position 0 is filled with one tile
				for (int j = 0; j < tiles[i].size(); j++) {
					// check if the color is matched
					//positions[0] does not need to rotate
					if (filledPositions == 0) {
						j = 100;
					}
					//other positions need to rotate for 6 times
					if (tiles.length != 7 || filledPositions != 0) {
						tiles[i].rotate();
					}

					if (isMatch(positions, filledPositions, tiles[i])) {
						// add the current tile to position array
						positions[filledPositions] = tiles[i];

						// remove the added tile from tiles array
						tiles = removeTile(i, tiles);
						// add position counter
						filledPositions++;

						// Recursive to the next position
						solve(tiles, positions, filledPositions);

						// backtracking if no matched color
						// put back the tiles from positions to tiles array
						// since no tiles[i] any more in tiles array, use tileSaved
						tiles = addTile(i, tileSaved, tiles);

						// remove the current tiles from position array
						positions[filledPositions - 1] = null;
						// remove the position counter
						filledPositions--;

					}
				}

			}

		}

	}

	public static boolean isMatch(Hexagon positions[], int indexOfPos, Hexagon tile) {
		// check positions 0
		if (indexOfPos == 0) {

			return true;
		}

		// check position 1 case
		if (indexOfPos == 1) {
			// rotate tile to see if the color match
			// position 1 only need to match one side with position 0
			if (positions[0].get(0).equals(tile.get(3))) {
				return true;
			}
		}

		// check positions 2 - 5 cases
		// position 2 - 5 need to match two sides with position 0 and the previous tile
		if (indexOfPos >= 2 && indexOfPos <= 5) {
			if (positions[0].get(indexOfPos - 1).equals(tile.get((indexOfPos - 1 + 3) % 6))
					&& positions[indexOfPos - 1].get(indexOfPos).equals(tile.get((indexOfPos + 3) % 6))) {
				return true;
			}
		}

		// check position 6 case
		// ?if(positions[6]== null) will throw exception for out of boundary 6
		if (indexOfPos == 6) {
			// position 6 needs to match three sides with position 0, 1 and 5
			if (positions[0].get(5).equals(tile.get(2)) && positions[5].get(0).equals(tile.get(3))
					&& positions[1].get(4).equals(tile.get(1))) {
				return true;
			}
		}

		return false;

	}

	// remove tile from tile array
	public static Hexagon[] removeTile(int index, Hexagon tiles[]) {
		Hexagon newTiles[] = new Hexagon[tiles.length - 1];
		// Copy the elements from starting till index
		// from original array to the other array
		System.arraycopy(tiles, 0, newTiles, 0, index);

		// Copy the elements from index + 1 till end
		// from original array to the other array
		System.arraycopy(tiles, index + 1, newTiles, index, tiles.length - index - 1);
		return newTiles;
	}

	public static Hexagon[] addTile(int index, Hexagon newTile, Hexagon tiles[]) {
		Hexagon newTiles[] = new Hexagon[tiles.length + 1];
		// Copy the elements from starting till index
		// from original array to the other array
		System.arraycopy(tiles, 0, newTiles, 0, index);

		// Copy the elements from index till end
		// from original array to the other array
		System.arraycopy(tiles, index, newTiles, index + 1, tiles.length - index);
		// assign the value to certain index
		newTiles[index] = newTile;

		return newTiles;
	}

	// print solution for the correct positions
	public static void printSolution(Hexagon positions[]) {
		for (int i = 0; i < positions.length; i++) {
			System.out.printf("%-8s%1d%2s%13s%n","Position ",(i+1),":",positions[i]);
		}

	}

}
