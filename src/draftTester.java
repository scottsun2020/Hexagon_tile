/* Your Name (Scott Sun)
 * Your Course Number (CS2023)
 * Your Section Numbers: 03
 * Description: This class is a draft to test the code for main Tester
 * Other Comments: no commends
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class draftTester {
	private static int solutionNumber = 0;


	public static void main(String[] args) throws FileNotFoundException {
		//create a new Hexagon instance with size 3
		//Hexagon h0 = new Hexagon(3, "A", "B", "C");
		
		//System.out.println(h0);
		//Write something to file 
		File file = new File("tileset1.txt");
        StringBuilder sb = new StringBuilder();
		
		try {
		//Read from txt file
		Scanner input = new Scanner(file);
		String name = "";
		System.out.println("The txt file: ");
		while(input.hasNextLine()) {
			name = input.nextLine();
			//String array1[]= name.split(": ");
			sb.append(name + " ");
			
		}
		System.out.println("print sb outside");
		System.out.println(sb);
		
		String textArray[] = sb.toString().split(" ");
		String tile1Array[] = textArray[2].split(",");
		String tile2Array[] = textArray[5].split(",");
		String tile3Array[] = textArray[8].split(",");
		String tile4Array[] = textArray[11].split(",");
		String tile5Array[] = textArray[14].split(",");
		String tile6Array[] = textArray[17].split(",");
		String tile7Array[] = textArray[20].split(",");

		System.out.println("print for textArray2");

		for(int i = 0; i < tile1Array.length; i++) {
			System.out.println(i + " " + tile1Array[i]);
		}
				
		Hexagon h1 = new Hexagon(tile1Array.length, 1, tile1Array);
		Hexagon h2 = new Hexagon(tile2Array.length, 2, tile2Array);
		Hexagon h3 = new Hexagon(tile3Array.length, 3, tile3Array);
		Hexagon h4 = new Hexagon(tile4Array.length, 4, tile4Array);
		Hexagon h5 = new Hexagon(tile5Array.length, 5, tile5Array);
		Hexagon h6 = new Hexagon(tile6Array.length, 6, tile6Array);
		Hexagon h7 = new Hexagon(tile7Array.length, 7, tile7Array);

//		System.out.println("Hexagon h1,h2, h3 is: ");
//		System.out.println(h1);
//		System.out.println(h2);
//		System.out.println(h3);
		
		//put Hexagon object TilesArray into array
		Hexagon tiles[] = new Hexagon[7];
		tiles[0] = h1;
		tiles[1] = h2;
		tiles[2] = h3;
		tiles[3] = h4;
		tiles[4] = h5;
		tiles[5] = h6;
		tiles[6] = h7;
		
		System.out.println("the size of tile: " + tiles.length);
		for (int i = 0; i < tiles.length; i++) {
			System.out.println(tiles[i]);
		}
		System.out.println("get the tile 2 position 4 and 5:");
		System.out.println(tiles[1].get(3) + tiles[1].get(4) );
		
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		
		Hexagon positions[] = new Hexagon[7];
		
		solve(tiles, positions);
		System.out.println("Total Solutions: " +solutionNumber);

				
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
	
	public static void solve(Hexagon tiles[], Hexagon positions[], int filledPositions) {

//		System.out.print(" size of tiles " + tiles.length +" ");
//		System.out.print(" size of positions " + positions.length);
//		System.out.println(" size of filledPositions " + filledPositions);

		
		if(filledPositions == positions.length) {
			
			System.out.println("\nSolution #" + ++solutionNumber +"----------------------------------");
			System.out.printf("%24s%4s%4s%4s%4s%4s%n","SA","SB","SC","SD","SE","SF");
			printSolution(positions);
			
			
		} else {//recursive case
			//assign each tile to each position
			for(int i = 0; i < tiles.length; i++) {
				
				//copy tile[i] without rotate to add back when backtracking
				Hexagon tileSaved = tiles[i];

				//No need to rotate the center tile which is position 0
				//if tiles length !=7 means that current position 0 is filled with one tile
					for (int j = 0; j < tiles[i].size(); j++) {					
						//check if the color is matched
						if(filledPositions == 0){
							j = 100;
						}
						
						if(tiles.length != 7 || filledPositions != 0) {
							tiles[i].rotate();
						}

						if(isMatch(positions, filledPositions, tiles[i])) {
							//add the current tile to position array

							//positions[i] = new Hexagon(positions.tiles[i]);
							positions[filledPositions] = tiles[i];
							//System.arraycopy(tiles, i, positions, i, 1);
														

							//remove the added tile from tiles array
							tiles = removeTile(i, tiles);
							//add position counter
							filledPositions++;
							
							
							//Recursive to the next position
							solve(tiles, positions, filledPositions);

							
							//backtracking if no matched color 
							//put back the tiles from positions to tiles array
							//since no tiles[i] any more in tiles array, use positions[index]
							//tiles = addTile(i, positions[filledPositions - 1], tiles);
							tiles = addTile(i, tileSaved, tiles);

							//remove the current tiles from position array
							positions[filledPositions - 1] = null;
							//remove the position counter
							filledPositions--;
							
						}
					}
							
			}
			
		}
		
	}
	//
	public static boolean isMatch(Hexagon positions[], int indexOfPos, Hexagon tile) {
		// check positions 0
		if (indexOfPos == 0) {
			
			return true;
		} 

		
		// check position 1 case
		if(indexOfPos == 1) {
			//rotate tile to see if the color match
			//position 1 only need to match one side with position 0
			if(positions[0].get(0).equals(tile.get(3)) ) {
				return true;
			}
		}
		
		// check positions 2 - 5 cases			
		//position 2 - 5 need to match two sides with position 0 and the previous tile
		if(indexOfPos >= 2 && indexOfPos <= 5) {
			if(positions[0].get(indexOfPos - 1).equals(tile.get((indexOfPos-1+3)%6)) &&
					positions[indexOfPos-1].get(indexOfPos).equals(tile.get((indexOfPos+3)%6))) {
					return true;
			}
		}
			
		
		
		// check position 6 case
		//?if(positions[6]== null) will throw exception for out of boundary 6
		if(indexOfPos == 6) {
			//position 6 needs to match three sides with position 0, 1 and 5
			if(positions[0].get(5).equals(tile.get(2)) &&
					positions[5].get(0).equals(tile.get(3)) &&
						positions[1].get(4).equals(tile.get(1))) {
					return true;
			}			
		}
		
		return false;
							
			
	}
				
	
	
	//remove tile from tile array
	public static Hexagon[] removeTile(int index, Hexagon tiles[]) {
		Hexagon newTiles[] = new Hexagon [tiles.length - 1];
		// Copy the elements from starting till index 
        // from original array to the other array 
        System.arraycopy(tiles, 0, newTiles, 0, index); 
  
        // Copy the elements from index + 1 till end 
        // from original array to the other array 
        System.arraycopy(tiles, index + 1, 
                       		newTiles, index, 
                         tiles.length - index - 1); 
		return newTiles;
	}
	
	public static Hexagon[] addTile(int index, Hexagon newTile, Hexagon tiles[]) {
		Hexagon newTiles[] = new Hexagon [tiles.length + 1];
		// Copy the elements from starting till index 
        // from original array to the other array 
        System.arraycopy(tiles, 0, newTiles, 0, index); 
  
        // Copy the elements from index till end 
        // from original array to the other array 
        System.arraycopy(tiles, index, 
                       		newTiles, index + 1, 
                         tiles.length - index); 
        //assign the value to certain index
        newTiles[index] = newTile;
        
		return newTiles;
	}
	
	//print solution for the correct positions 
	public static void printSolution(Hexagon positions[]) {
		for (int i = 0; i < positions.length; i++) {
		
			//System.out.println("Position " + (i+1) + " :" + positions[i]);
			System.out.printf("%-8s%1d%2s%13s%n","Position ",(i+1),":",positions[i]);

		}

		
	}
	

		
		
		

}


/*
 * 
 * 
 * //base case
		if(positions[0].get(0)==positions[1].get(3) && positions[0].get(1)==positions[2].get(4) && positions[0].get(2)==positions[3].get(5) &&
			positions[0].get(3)==positions[4].get(0) && positions[0].get(4)==positions[5].get(1) && positions[0].get(5)==positions[6].get(2) &&
			positions[1].get(2)==positions[2].get(5) && positions[1].get(4)==positions[6].get(1) && positions[2].get(3)==positions[3].get(0) &&
			positions[3].get(4)==positions[4].get(1) && positions[4].get(5)==positions[5].get(2) && positions[5].get(0)==positions[6].get(3)) {
			
			System.out.println("\nSolution " + ++solutionNumber);
			printSolution(positions); 
			*/
