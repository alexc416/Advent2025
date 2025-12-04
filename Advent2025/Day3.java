import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // **** DO NOT EDIT ANYTHING HERE ****
        ArrayList<String> fileData = getFileData("src/data");
        int partOneAnswer = 0;
        for (String batteries : fileData) {
            int voltage = getLargestCombination(batteries);
            partOneAnswer += voltage;
        }

        System.out.println("Part one answer: " + partOneAnswer);
    }

    // COMPLETE THIS METHOD!
    public static int getLargestCombination(String batteries) {
        ArrayList<Integer> comb = new ArrayList<Integer>();
        for (int i = 0; i < batteries.length(); i++) {
            for (int k = 0; k < batteries.length(); k++) {
                if (i < k) {
                    comb.add(Integer.parseInt(batteries.substring(i, i+1) + batteries.substring(k, k+1)));
                }
            }
        }
        //could simplify to have max int, then if the parsed is greater than max, replace
        int max = comb.get(0);
        for (int e : comb) {
            if (e > max) {
                max = e;
            }
        }
        return max;
    }

    public static int partTwo(String batt) {
        int pastHigh;
        String build = batt.substring(batt.length()-11);
        for (int i = 0; i < batt.length(); i++) {
            
        }
        //idk
        return 0;
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
