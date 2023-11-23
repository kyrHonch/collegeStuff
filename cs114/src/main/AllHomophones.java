import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/*
 * Read in word and print all words that are homophones.
 */

public class AllHomophones {

    public static void main(String[] args) {
        String path = "./src/cmu-dict.0.7a.txt";
        File file = new File(path);


        UALDictionary<String, Pronunciation> PDict = new UALDictionary<String,
        Pronunciation>();
        UALDictionary<String, Pronunciation> WDict = new UALDictionary<String,
        Pronunciation>();

        long startTime = System.currentTimeMillis();

        // Read in the cmu pronunciation dictionary.
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.substring(0, 3).equals(";;;"))
                    continue; // skip comment lines
                Pronunciation p = new Pronunciation(line);
                PDict.insert(p.getPhonemes(), p);
                WDict.insert(p.getWord(), p);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        long elapsed = System.currentTimeMillis() - startTime;
        //System.out.println("Elapsed time: " + elapsed);
        System.out.println("Enter word");
        Scanner inp = new Scanner(System.in);
        String wd = inp.nextLine();
        System.out.println("All homophones of "+wd+":");
        Pronunciation pp = WDict.find(wd);
        for (Pronunciation q : PDict.findAll(pp.getPhonemes()))
            System.out.println(q.getWord());

        //System.out.println("Elapsed time: " + elapsed);
    }
}
