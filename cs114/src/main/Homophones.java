import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class Homophones {
    public static void main(String [] args){
        String path = "./src/cmu-dict.0.7a.txt";
        File file = new File(path);
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        UALDictionary<String, Pronunciation> PDict = new UALDictionary<String,
                Pronunciation>();
        UALDictionary<String, Pronunciation> WDict = new UALDictionary<String,
                Pronunciation>();
        UALDictionary<String, Pronunciation> P5Dict = new UALDictionary<String,
                Pronunciation>();
        UALDictionary<String, Pronunciation> W5Dict = new UALDictionary<String,
                Pronunciation>();

        // Read in the cmu pronunciation dictionary.
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine() && n!=0) {
                String line = scanner.nextLine();
                if (line.substring(0, 3).equals(";;;"))
                    continue; // skip comment lines
                Pronunciation p = new  Pronunciation(line);
                if(p.getWord().length()==5){
                    P5Dict.insert(p.getPhonemes(), p);
                    W5Dict.insert(p.getWord(), p);
                }else{
                    PDict.insert(p.getPhonemes(), p);
                    WDict.insert(p.getWord(), p);
                }

                n--;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int m= 0;
        for(Pronunciation f : W5Dict.values()){

            //The code needs to compare the pronunciation of the newly created word with the old one
            boolean state1 = false;
            boolean state2 = false;
            String wd1l = f.getWord().substring(1);
            String wd2l = f.getWord().charAt(0) + f.getWord().substring(2);
            for (Pronunciation q : WDict.findAll(wd1l))
                if(q.getPhonemes().equals(f.getPhonemes())){
                    state1 = true;
                }
            for (Pronunciation q : WDict.findAll(wd2l))
                if(q.getPhonemes().equals(f.getPhonemes())){
                    state2 = true;
                }
            if(state1 && state2){
                m++;
            }
        }

//print out m and print out all the words
        //System.out.println("Elapsed time: " + elapsed);
    }
}

