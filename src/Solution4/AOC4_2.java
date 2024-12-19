import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;



public class AOC4_2 {

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
        
        for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < cols; j++) {
			char c = charMatrix[i][j];
        		if (c == 'A') {
        			System.out.println("A - Row: " + i + " Col:" + j);
        			
        			List<Pair<Integer, Integer>> result = check(i, j);
        			System.out.println(result.size());
        			if(result.size() == 2) {
        				int firstX = result.get(0).getFirst();
        				int firstY = result.get(0).getSecond();
        				int secondX = result.get(1).getFirst();
        				int secondY = result.get(1).getSecond();
        				
        				//Check that they are not adjecent
        				if(firstX == secondX || firstY == secondY) { //Not necessary?
        					//Check if the char adjecent to the M's are S's
						if(checkAdj(firstX, firstY, i, j) && checkAdj(secondX, secondY, i, j)) {
							System.out.println("We have a match!");
							matches += 1;
						}				
        				} else {
        					System.out.println("Adjecent!");
        				}
        			}
        		}
        	}
        }
        System.out.println("Matches are: " + matches);
    }
    
    private static List<Pair<Integer, Integer>> check(int x, int y) {
    
    	List<Pair<Integer, Integer>> pairs = new ArrayList<>();
    	
        int xsteps = -1;
    	for (int i = x-1; i <= (x+1); i = i+2) {
    		int ysteps = -1;
    		for (int j = y-1; j <= (y+1); j = j+2) { //OUT OF BOUNDS!
    			try {
    				if(charMatrix[i][j] == 'M') {
    						
    					pairs.add(new Pair<>(xsteps, ysteps));
    				}
    			} catch (ArrayIndexOutOfBoundsException e) {
    				System.out.println("OUT OF BOUNDS FOUND WHEN FINDING M");
    			}
    			ysteps += 2;
    		}
    		xsteps += 2;
    	}
    	return pairs;
    }
    
    private static boolean checkAdj(int x, int y, int i, int j) {
    	int adjX = -x;
    	int adjY = -y;
    	
    	int Xpos = i + adjX; 
    	int Ypos = j + adjY;
    	
    	boolean res = false;
    	
    	try {
    		if(charMatrix[Xpos][Ypos] == 'S') {
    			res = true;
    		}
    	} catch (ArrayIndexOutOfBoundsException e) {
    		System.out.println("OUT OF BOUNDS FOUND WHEN FINDING S");
    	}
    	
    	return res;
    }

}




