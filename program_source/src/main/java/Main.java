import java.io.IOException;

public class Main{
    public static void main(String[] args){
        try {
            String[] atotcSplitted = FileUtility.toStringArray("resources/ATOTC.txt", "[^A-Za-z']+");
            String[] shspSplitted = FileUtility.toStringArray("resources/Shakespeare_Complete_Works.txt", "[^A-Za-z']+");
            String[] algSplitted = FileUtility.toStringArray("resources/Algorithms.txt", "[^A-Za-z']+");

            TrieStructure structureAtotc = new TrieStructure();
            TrieStructure structureShsp = new TrieStructure();
            TrieStructure structureAlg = new TrieStructure();

            for (String s : atotcSplitted)
                structureAtotc.insertWord(s);
            for (String s : shspSplitted)
                structureShsp.insertWord(s);
            for (String s : algSplitted)
                structureAlg.insertWord(s);

            //structure.printWordsUsage();
            /*for (WordCount wordCount: structure.getWordsCount()){
                System.out.println(wordCount.word + " - " + wordCount.count);
            }*/

            FileUtility.exportToCSV("resources/ATOTC.csv", structureAtotc.getWordsCount());
            FileUtility.exportToCSV("resources/Shakespeare.csv", structureShsp.getWordsCount());
            FileUtility.exportToCSV("resources/Algorithms.csv", structureAlg.getWordsCount());

            System.out.println("Done!");

            /*try{
                structureAtotc.printWordUsage("That'");

            }catch(NoSuchElementException e){
                System.out.println("This word doesn't exist!");
            }*/

        }catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println("Something went wrong!");
        }
    }
}