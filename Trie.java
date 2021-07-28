import java.util.*;

public class Trie {
    public Node starter;

    public Trie() {
        starter = new Node(' ', 0, null);
    }

    //    public void test(String fullString, int f)
//    {
//        Node current = starter;
//        for(int i = 0; i < fullString.length(); i ++)
//        {
//            if(i == fullString.length())
//        }
//    }
    public void insertMain(String fullString, long fre) {
//        if(fullString.equals("the"))
//        {
//            System.out.println("the inserted");
//        }
        insert(fullString, 0, fre, starter);
    }

    public void insert(String fullString, int index, long fre, Node current2) {
        char x = fullString.charAt(index);
        if (index == fullString.length() - 1) {
            if (current2.pointers == null || current2.get(x) == null) {
                Node temp = new Node(x, fre, fullString);
                current2.set(x, temp);
            }
            else
            {
                Node temp = current2.get(x);
                temp.word = fullString;
                temp.wF = fre;
            }
        } else {
            if (current2.contains(x) == true) {
                insert(fullString, index + 1, fre, current2.get(x));

            } else {
                Node y = new Node(x, 0, null);
                current2.set(x, y);
                insert(fullString, index + 1, fre, current2.get(x));
                current2.set(x, y);
            }
        }
    }

    //Finds the node of the inputted string
    //Returns null if it's not in the trie
    public Node find(String fullString, int index, Node current) {
        char x = fullString.charAt(index);
        if (fullString.length() == 1) {
            if (current.contains(x) == true) {
                return current.get(x);
            } else {
                return null;
            }
        }
        if (index != fullString.length() - 1) {
            if (current.get(x) == null) {
                return null;
            } else {
                return find(fullString, index + 1, current.get(x));
            }
        } else {
            return current.get(x);
        }
    }

    //Finds the starting point then calls findAll and returns priority queue
    public PriorityQueue<Node> findStarter(String input) {
        Node current = starter;
        NodeComp comp = new NodeComp();
        PriorityQueue<Node> blank = new PriorityQueue<Node>(comp);
        for (int i = 0; i < input.length(); i++) {
            char x = input.charAt(i);
            if (current.contains(x) == true) {
                current = current.get(x);
            } else {
                return null;
            }
        }
        findAll(current, blank);
        return blank;

    }

    public void findAll(Node current, PriorityQueue<Node> pq) {


         if (current.word != null) {
            pq.add(current);
        }
        Set<Map.Entry<Character, Node>> x = current.pointers.entrySet();
        for(Map.Entry<Character, Node> t : x)
        {
                Node l = t.getValue();
                findAll(l, pq);

        }

    }
    public void sortAndPrint(PriorityQueue<Node> pq)
    {
        //Put top 5 (or less) into an ArrayList
        ArrayList<Node> list = new ArrayList<Node>();
        for(int i = 0; i < 5; i ++)
        {
            if(pq == null)
            {
                break;
            }
            else if(pq.size() == 0)
            {
                break;
            }
            else
            {
                list.add(pq.remove());
            }
        }
        //Selection Sort
        for(int i = 0; i < list.size(); i ++)
        {
            for(int j = i + 1; j < list.size(); j++)
            {
                 if(list.get(i).word.compareTo(list.get(j).word) > 0)
                 {
                     Node temp = list.get(j);
                     Node temp2 = list.get(i);
                     list.set(i, temp);
                     list.set(j, temp2);
                 }
            }

        }
        //print
        for(int i = 0; i < list.size(); i ++)
        {
            System.out.println(list.get(i).word);
        }

    }

}
