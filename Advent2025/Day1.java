import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Day1 {
   public static void main(String[] args) {
       ArrayList<String> fileData = getFileData("src/data");

       int position = 50;
       int partOneAnswer = 0;
       int partTwoAnswer = 0;
       for (String line : fileData) {

           String direction = line.substring(0,1);
           int amount = Integer.parseInt(line.substring(1));
           System.out.println("Rotate " + direction + " " + amount + " times");
           int[] afterRotation = doRotation(direction, amount, position);
           position = afterRotation[0];
           partTwoAnswer += afterRotation[1];
           if (position == 0) {
               partOneAnswer += 1;
           }
       }

       System.out.println("Part one answer: " + partOneAnswer);
       System.out.println("Part two answer: " + partTwoAnswer);
   }


   public static int[] doRotation(String direction, int amount, int startPosition) {
        int zeroPasses = 0;

        if (direction.equals("L")) {
            amount = -amount;
        }

        int newPosition = startPosition;

        for (int i = 0; i < Math.abs(amount); i++) {
            if (amount > 0) {
                newPosition += 1;  
            } else {
                newPosition -= 1;  
            }
            if (newPosition > 99) { 
                newPosition = 0; 
            }
            if (newPosition < 0) { 
                newPosition = 99;
            }
            if (newPosition == 0) { 
                zeroPasses++;
            }
        }

        return new int[]{newPosition, zeroPasses};
    }



   public static ArrayList<String> getFileData(String fileName) {
       ArrayList<String> fileData = new ArrayList<String>();
       try {
           File f = new File(fileName);
           Scanner s = new Scanner(f);
           while (s.hasNextLine()) {
               String line = s.nextLine();
               if (!line.equals(""))
                   fileData.add(line);
           }
           return fileData;
       }
       catch (FileNotFoundException e) {
           return fileData;
       }
   }
}

