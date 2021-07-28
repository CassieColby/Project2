import java.util.Comparator;

public class NodeComp implements Comparator<Node> {

    @Override
    public int compare(Node node1, Node node2) {
        long x = node1.wF - node2.wF;
        int answer = (int) x;
        answer = answer * -1;
       return answer;
    }
}
