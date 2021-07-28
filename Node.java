import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;


public class Node {
    public Character value;
    public HashMap<Character, Node> pointers;
    public long wF;
    public String word;
    public Node(Character value, long num, String word)
    {
        this.word = word;
        this.value = value;
        wF = num;
        pointers = new HashMap<Character, Node>();
    }
    public void changeWF(int newFreq)
    {
        wF = newFreq;
    }
    public void addPointer(Node newPointer)
    {
        pointers.put(newPointer.value, newPointer);
    }
    public boolean contains(char x)
    {
        return pointers.containsKey(x);
    }
    public Node get(char x)
    {
        return pointers.get(x);
    }
    public void set(char key, Node value)
    {
        pointers.put(key, value);
    }

}
