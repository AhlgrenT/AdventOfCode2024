import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class AOC1_1 {
	
    public static void main(String[] args) {
    	LinkedList<Integer> list1 = new LinkedList<>();
	LinkedList<Integer> list2 = new LinkedList<>();
	
        try {
            File inputFile = new File("../inputs/input1.txt");
            Scanner scanner = new Scanner(inputFile);
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Split the line by blank spaces
                String[] words = line.split("\\s+");
                list1.add(Integer.parseInt(words[0]));
                list2.add(Integer.parseInt(words[1]));
            }
            
            scanner.close(); // Close the scanner	
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        
        Collections.sort(list1);
        Collections.sort(list2);
        
        int res = 0;
        for (int i = 0; i < list1.size(); i++) {
        	res += Math.abs(list1.get(i) - list2.get(i));
        }
       System.out.println(res);
    }
}

