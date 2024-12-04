import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class AOC1_2 {
	
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
        
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int num : list2) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        // For each element in the left list, look up the frequency in the map
        for (int num : list1) {
            res += num * frequencyMap.getOrDefault(num, 0);
        }
       System.out.println(res);
    }
}

