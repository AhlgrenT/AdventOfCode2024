import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class AOC2_2 {
	
    public static void main(String[] args) {
	int safe = 0;
        try {
            File inputFile = new File("../inputs/input2.txt");
            Scanner scanner = new Scanner(inputFile);
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                // Split the line by spaces to get individual numbers as strings
                String[] words = line.split("\\s+");
                
                // Convert the string array to an integer array
                //int[] numbers = new int[words.length];
                
                LinkedList<Integer> l = new LinkedList<>();
                for (int i = 0; i < words.length; i++) {
                    l.add(Integer.parseInt(words[i]));
                }
		if(testDesc(l) || testAsc(l)) {
			System.out.println("Safe");
			safe += 1;
		} else {
			System.out.println("UNSafe");
		}
		
		//Check second.
		//is it less than prev? if no remove this or first
		
		4 5 3 2 1    Pass
		5 4 3 7 2 1  Pass
		7 10 8 4 2 1 Pass
		9 10 8 4 2 1 Pass
		16 15 10 14 12 Pass
		16 15 13 14 12 Pass
		Must look at all three and make sure they are valid
		
		
	
               	
               	
               	
               	
               	
		
            }
            
            scanner.close(); // Close the scanner	
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        System.out.println(safe);
    }
    
    private static boolean testDesc(LinkedList<Integer> list) {
    	List<Integer> l = new LinkedList<>(list);     
        boolean isSafe = true;
        boolean error = false;
                //Try make a descending pattern
	for(int i = 0; i < (l.size()-1); i++) {
		//System.out.println(i);
		int curr = l.get(i);
		int next = l.get(i)+1;
              	int nextnext = l.get(i+2);
              	int diff1 = curr - next;
              	int diff2 = next - nextnext;
              	int diff3 = curr - nextnext;
              	if(diff1 >= 1 && diff <= 3) {
              		if(diff2 >= 1 && diff2 <=3){
              			//100 90 80 OK
              		} else {
              			if(diff3 >= 1 && diff <= 3) {
              				//100 80 90 Savable. Rmv middle.	
              			} else {
              				//90 80 100 Savable.
              			} 	
              		}	
              	} else {
              		if(diff2 >= 1 && diff2 <= 3) {
              			if(diff3 >= 1 && diff <= 3) {
              				//90 100 88 Savable
              			} else {
              				//80 100 98 Savable
              			}
              		} else {
              			//90 100 88 Savable
              			//80 90 100 Not savable
              		}
              	}
               	2 3 4

               	 
               	100 90 80 //falling GOOD
               	100 80 90 //nästes iterations problem
               
               	
               	90 100 80 //HÄR ta bort andra
               	90 80 100 //sista, näste iterations problem
               	
               	80 100 90 // HÄR ta bort första
               	80 90 100 // rising BAAD
            
               	
               	int diff = curr - next;
               	
               	//if curr>next desc
               	//if diff>0 desc
               		if(diff >= 1 && diff <= 3) {
               			//System.out.println("ALL GOODD");
               		} else if (!error) {
               			error = true;
               			l.remove(i+1);
               			i -= 1;
               		} else if(error) {
               			//System.out.println("Second error:(");
               			isSafe = false;
               			break;
               		}
         }
         return isSafe;
    }
    
    private static boolean testAsc(LinkedList<Integer> list) {
    	List<Integer> l = new LinkedList<>(list);
        boolean isSafe = true; 
        boolean error = false;
                //Try make a descending pattern
	for(int i = 0; i < (l.size()-1); i++) {
		//System.out.println(i);
		int curr = l.get(i);
		
              	int next = l.get(i+1);
               	int diff = curr - next;
               	System.out.println(diff);
               	//if curr>next desc
               	//if diff>0 desc
               		if(diff >= -3 && diff <= -1) {
               			System.out.println("ALL GOODD");
               		} else if (!error) {
               			error = true;
               			l.remove(i+1);
               			i -= 1;
               		} else if(error) {
               			//System.out.println("Second error:(");
               			isSafe = false;
               			break;
               		}
         }
         return isSafe;
    }
    
}

