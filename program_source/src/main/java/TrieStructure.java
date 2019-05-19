import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TrieStructure {
    TrieNode _rootNode;

    public TrieStructure(){
        _rootNode = new TrieNode();
    }

    public void insertWord(String word){
        word = word.trim().toLowerCase();
        if(word.length() > 0)
            insertWord(word, 0, _rootNode);
    }

    private void insertWord(String word, int position, TrieNode node){
        try{
            if(position == word.length())
                node.incrementCount();
            else {
                TrieNode newNode = node.getChildNode(word.charAt(position));
                if(newNode == null)
                        newNode = node.setChildNode(word.charAt(position));
                insertWord(word, position + 1, newNode);
            }
        }catch(NoSuchElementException e){
            insertWord(word, position + 1, node);
        }
    }

    public void printWordsUsage(){
        _rootNode.print("");
    }

    public void printWordUsage(String word){
        word = word.trim().toLowerCase();
        if(word.length() > 0) {
            int count = printWordUsage(word, 0, _rootNode);
            if(count > 0)
                System.out.println(word + " - " + count);
            else
                throw new NoSuchElementException("This word doesn't exist!");
        }

    }

    private int printWordUsage(String word, int position, TrieNode node) {
        if (position == word.length())
            return node.getCount();
        else {
            TrieNode newNode = node.getChildNode(word.charAt(position));
            if (newNode == null)
                throw new NoSuchElementException();

            return printWordUsage(word, position + 1, newNode);
        }
    }

    public ArrayList<WordCount> getWordsCount(){
        return _rootNode.getWordsCount("");
    }
}
