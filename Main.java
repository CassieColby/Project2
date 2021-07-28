import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Trie x = new Trie();
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\cassi\\ATDP\\Porject-2\\count_1w.txt"));
        String line;
        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] values = line.split("\t");
            long fre = Long.parseLong(values[1]);
            x.insertMain(values[0], fre);
            i++;
            if(i > 100000)
            {
                break;
            }
        }

        Scanner y = new Scanner(System.in);
        while (true) {
            System.out.println("Put in a word: ");
            String temp = y.next();
            if (temp.equals("stop")) {
                break;
            } else {
                PriorityQueue<Node> z = x.findStarter(temp);
                if(z == null)
                {
                    System.out.println("No words");
                }
                else {
                    x.sortAndPrint(z);


                }
            }
        }
    }
}
