import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AOC3_1 {
	
    public static void main(String[] args) {
    	int res = 0;
        try {
            File inputFile = new File("../inputs/input3.txt");
            Scanner scanner = new Scanner(inputFile);
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                String regexp = "mul\\(\\d{1,3},\\s*\\d{1,3}\\)";
               
                Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(line);
		
		// Find and print all matches
		while (matcher.find()) {
			String j = matcher.group();
		   	int start = j.indexOf("(") + 1; // Start after '('
			int end = j.indexOf(")");       // End at ')'
			
			// Split the numbers by comma
			String[] parts = j.substring(start, end).split(",");
			res += Integer.parseInt(parts[0].trim()) * Integer.parseInt(parts[1].trim());
		}
            }
            
            scanner.close(); // Close the scanner	
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        System.out.println(res);
    }
}

