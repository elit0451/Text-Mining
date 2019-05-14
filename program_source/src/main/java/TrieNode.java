import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class TrieNode {
    HashMap<Character, TrieNode> _childrenNodes;
    int _count;

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
}
