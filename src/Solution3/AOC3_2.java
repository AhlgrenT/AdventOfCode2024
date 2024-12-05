import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AOC3_2 {
	
    public static void main(String[] args) {
    	int res = 0;
    	boolean valid = true;
        try {
            File inputFile = new File("../inputs/input3.txt");
            Scanner scanner = new Scanner(inputFile);
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                String regexp = "do\\(\\)|don't\\(\\)|mul\\(\\d{1,3},\\s*\\d{1,3}\\)";
                Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(line);
		
		while (matcher.find()) {
			String word = matcher.group();
			if(word.equals("do()")){
				valid = true;
			} else if (word.equals("don't()")){
				valid = false;
			} else if (valid){
				int start = word.indexOf("(") + 1; // Start after '('
				int end = word.indexOf(")");       // End at ')'
				String[] parts = word.substring(start, end).split(",");
				res += Integer.parseInt(parts[0].trim()) * Integer.parseInt(parts[1].trim());
			}
		}
            }
            
            scanner.close(); // Close the scanner	
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        System.out.println(res);
    }
}

