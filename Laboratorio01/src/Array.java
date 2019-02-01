import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Array {
    public  void loadCoordinates() {
        String findLocation = "Arcos.";
        final String fileName = "medellin_colombia-grande.txt";
        BufferedReader bufferedReader = null;
        Scanner sc = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            sc = new Scanner(bufferedReader);
        } catch ( FileNotFoundException e ) {
            System.out.println("Error reading file.");
        }
        sc.nextLine();
        while (sc.hasNextLine()){

            }
        }
    }
}
