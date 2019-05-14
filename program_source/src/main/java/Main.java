import java.io.IOException;
import java.util.NoSuchElementException;

public class Main{
    public static void main(String[] args){
        try {
            String[] splitted = FileUtility.toStringArray("./98-0.txt", "[^A-Za-z']+");

            TrieStructure structure = new TrieStructure();

            for (String s : splitted)
                structure.insertWord(s);

            structure.printWordsUsage();

            try{
                structure.printWordUsage("That'");

            }catch(NoSuchElementException e){
                System.out.println("This word doesn't exist!");
            }

        }catch (IOException e){
            System.out.println("Something went wrong!");
        }
    }


}