import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class AOC2_1 {
	
    public static void main(String[] args) {
	int Safe = 0;
        try {
            File inputFile = new File("../inputs/input2.txt");
            Scanner scanner = new Scanner(inputFile);
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                // Split the line by spaces to get individual numbers as strings
                String[] words = line.split("\\s+");
                
                // Convert the string array to an integer array
                int[] numbers = new int[words.length];
                for (int i = 0; i < words.length; i++) {
                	System.out.println(words[i]);
                    numbers[i] = Integer.parseInt(words[i]);
                }

                // Set the loopMax based on the length of the numbers array
                int loopMax = numbers.length - 1;

                // Determine if the numbers are descending (based on the first two numbers)
                boolean descending = numbers[0] > numbers[1];

                int isSafe = 1;
               	for (int i=0; i < loopMax; i++) {
               		int curr = numbers[i];
               		int next = numbers[i+1];
               		int diff = curr - next;
               		if (descending) {
               			//DESCENDING
               			if (!((diff <= 3) && (diff >= 1))) {
               				isSafe = 0;
               				break;
               			}
               		} else {
               			//ASCENDING
               			if(!((diff >= -3) && (diff <= -1))) {
               				isSafe = 0;
               				break;
               				
               			}
               		}
               	}
               	
                Safe += isSafe;
            }
            
            scanner.close(); // Close the scanner	
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        System.out.println(Safe);
    }
}

