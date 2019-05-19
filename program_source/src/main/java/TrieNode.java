import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

final class WordCount {
    public String word;
    public int count;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }
}

public class TrieNode {

    int _count;
    HashMap<Character, TrieNode> _childrenNodes;

    public TrieNode(){
        _childrenNodes = new HashMap<Character, TrieNode>();
        _count = 0;

        for(int i = 97; i <= 122; i++)
            _childrenNodes.put((char)i, null);

        _childrenNodes.put('\'', null);
    }

    public int getCount() {
        return _count;
    }

    public void incrementCount(){
        _count++;
    }

    public TrieNode getChildNode(Character key){
         if(!_childrenNodes.containsKey(key))
             throw new NoSuchElementException();

         return _childrenNodes.get(key);
    }

    public TrieNode setChildNode(Character key){
        if(!_childrenNodes.containsKey(key))
            throw new NoSuchElementException();

        _childrenNodes.put(key, new TrieNode());

        return getChildNode(key);
    }

    public void print(String currentWord){

        if(_count > 0)
            System.out.println(currentWord + " - " + _count);

        for (Map.Entry<Character, TrieNode> nextNode: _childrenNodes.entrySet()) {
            if(nextNode.getValue() != null)
                nextNode.getValue().print(currentWord + nextNode.getKey());
        }
    }

    public ArrayList<WordCount> getWordsCount(String currentWord){
        ArrayList<WordCount> wordOccurences = new ArrayList<WordCount>();

        if(_count > 0)
            wordOccurences.add(new WordCount(currentWord, _count));

        for (Map.Entry<Character, TrieNode> nextNode: _childrenNodes.entrySet()) {
            if(nextNode.getValue() != null)
                wordOccurences.addAll(nextNode.getValue().getWordsCount(currentWord + nextNode.getKey()));
        }

        return wordOccurences;
    }
}
