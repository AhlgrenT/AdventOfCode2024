import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;



public class AOC4_1 {

	public static class Pair<F, S> {
		private final F first;
		private final S second;

		public Pair(F first, S second) {
		    this.first = first;
		    this.second = second;
		}

		public F getFirst() {
		    return first;
		}

		public S getSecond() {
		    return second;
		}
        }




	
    static char[][] charMatrix = null;
    static int rows = 0;
    static int cols = 0;
    static int matches = 0;
    
    public static void main(String[] args) {
    	
    	String input = "../inputs/input4.txt";
    	
        
        //Find matrix size
        try {
            Scanner scanner = new Scanner(new File(input));
            
            while (scanner.hasNextLine()) {               
		String line = scanner.nextLine();
                rows++;
                if (cols == 0) {
                    cols = line.length(); // Assume all lines have the same length
                }
            }
            
            scanner.close(); // Close the scanner	
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        
        charMatrix = new char[rows][cols];
        
        //Populate matrix
        try {
            Scanner scanner = new Scanner(new File(input));
            
	    int currentRow = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                charMatrix[currentRow] = line.toCharArray(); // Convert line to char array
                currentRow++;
            }
            
            scanner.close(); // Close the scanner	
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        
        //Solve
        /*
        * For each box, is it it an x? 
        *	Yes -> do stuff
        *		check all directions
        		using a function for each?
        *	No -> Move on
        *
        */
        for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < cols; j++) {
			char c = charMatrix[i][j];
        		if (c == 'X') {
        			System.out.println("X - Row: " + i + " Col:" + j);
        			List<Pair<Integer, Integer>> pairs = findM(i, j);
        			for (Pair<Integer, Integer> pair : pairs) {
            				int dx = i + 2 * pair.getFirst();
            				int dy = j + 2 * pair.getSecond();
            				System.out.println("Pair first: " + pair.getFirst());
            				System.out.println("Pair second: " + pair.getSecond());
            				int d2x = i + 3 * pair.getFirst();
            				int d2y = j + 3 * pair.getSecond();
            				
            				System.out.println("dx: " + dx);
          				System.out.println("dy: " + dy);
            				
          				System.out.println("d2x: " + d2x);
          				System.out.println("d2y: " + d2y);
          				
            				System.out.println("DEBUG!");
            				
            				if (d2x < 0 || d2x > rows-1 || d2y < 0 || d2y > cols-1) {
            					//Out of bound
            					System.out.println("Out of bounds");
            				} else {
            					System.out.println("Rows max is: " + rows);
            					System.out.println("Col max is: " + cols);
            					System.out.println("d2x = " + d2x);
            					System.out.println("d2y = " + d2y);
		    				if (charMatrix[dx][dy] == 'A') { //CHECK OUT OF BOUNDS
		    					System.out.println("A FOUND!");
		    					if(charMatrix[d2x][d2y] == 'S') {
		    						System.out.println("FOUND A MATCH! \n");
		    						matches += 1;
		    					}
		    				}
            				}
        			}
        		}
        	}
        }
        System.out.println(matches);
    }
    
    //find all Ms surrounding X
    //If an M is found, check the "direction" and call a function to find A-S in that direction.
    private static List<Pair<Integer, Integer>> findM(int x, int y) {
    	int lowerX = x-1;
    	int upperX = x+1;
    	int lowerY = y-1;
    	int upperY = y+1;
    	
    	List<Pair<Integer, Integer>> pairs = new ArrayList<>();
    	int xsteps = -1;
    	for (int i = x-1; i <= (x+1); i++) {
    		int ysteps = -1;
    		for (int j = y-1; j <= (y+1); j++) { //OUT OF BOUNDS!
    			
    			
    			if (i >= rows || i < 0 || j < 0 || j >= cols) {
    				System.out.println("OUT OF BOUNDS FOUND");
    			} else if (charMatrix[i][j] == 'M') {
    				pairs.add(new Pair<>(xsteps, ysteps));
    				System.out.println("M - Row: " + i + " Col:" + j);
    			}
    			ysteps += 1;
    		}
    		xsteps += 1;
    	}
    	return pairs;
    }
    
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) { // Loop through rows
            for (int j = 0; j < matrix[i].length; j++) { // Loop through columns
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // New line after each row
        }
    }
}




