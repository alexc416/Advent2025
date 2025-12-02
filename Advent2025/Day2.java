import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2 {
   public static void main(String[] args) {


       // Day 2 data parsing set up
       // ------ DO NOT EDIT THE CODE HERE
       ArrayList<String> fileData = getFileData("src/data");
       ArrayList<Long> productIDs = new ArrayList<Long>();
       for (String line : fileData)  {
           for (String s : line.split(",")) {
               long first = Long.parseLong(s.split("-")[0]);
               long second = Long.parseLong(s.split("-")[1]);
               for (long i = first; i <= second; i++) {
                   productIDs.add(i);
               }
           }
       }
       // Day 2 data parsing set up complete
       // "productIDs" is a list of "long" variables that make up each product ID from the file


       long partOneAnswer = 0;
       long partTwoAnswer = 0;


       for (Long p : productIDs) {
           if (isInvalidProductID(p)) {
               partOneAnswer += p;
           }
           if (isInvalidProductIDTWO(p)) {
               partTwoAnswer += p;
           }
       }


       System.out.println("Part one answer: " + partOneAnswer);
       System.out.println("Part two answer: " + partTwoAnswer);


   }


   // COMPLETE THIS METHOD. This method should return "true"
   // if the product ID is INVALID. "false" otherwise.
   public static boolean isInvalidProductID(long productID) {
       String pID = productID + "";
       for (int i = 1; i < pID.length(); i++) {
           String subCheck = pID.substring(0, i);
           String temp = pID;
           if (temp.contains(subCheck)) {
               temp = temp.substring(0, temp.indexOf(subCheck)) + temp.substring(temp.indexOf(subCheck)+subCheck.length());
           }
           if (temp.contains(subCheck)) {
               temp = temp.substring(0, temp.indexOf(subCheck)) + temp.substring(temp.indexOf(subCheck)+subCheck.length());
           }
           if (temp.equals("")) {
               return true;
           }
       }
       return false;
   }


   public static boolean isInvalidProductIDTWO(long productID) {
       String pID = productID + "";
       for (int i = 1; i < pID.length(); i++) {
           String subCheck = pID.substring(0, i);
           String temp = pID;
           while (temp.contains(subCheck)) {
               temp = temp.substring(0, temp.indexOf(subCheck)) + temp.substring(temp.indexOf(subCheck)+subCheck.length());
           }
           if (temp.equals("")) {
               System.out.println("part2: " + productID);
               return true;
           }
       }
       return false;
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

