import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Tests {
    @Test
    public void testInsert()
    {
        Trie x = new Trie();
        x.insertMain("hi", 5);
        System.out.println(x.starter.value);
        System.out.println(x.starter.get('h').value);
        System.out.println(x.starter.get('h').get('i').value);
        System.out.println(x.starter.get('h').get('i').wF);
        System.out.println(x.starter.get('h').get('i').word);

    }

    @Test
    public void test2()
    {
        Trie x = new Trie();
        x.insertMain("hello", 10);
        x.insertMain("hell", 10);
        x.insertMain("hey", 15);
        x.insertMain("hi", 5);
        x.findStarter("hi");
        x.findStarter("he");

    }@Test
    public void testGetWords()
    {
        Trie x = new Trie();
        x.insertMain("hello", 10);
        x.insertMain("hey", 12);
        x.insertMain("hi", 5);
        x.insertMain("hat", 20);
        x.insertMain("heap", 15);
        x.insertMain("all", 5);
//        System.out.println(x.starter.get('h').get('e').get('l').get('l').get('o').word);
        PriorityQueue<Node> temp = x.findStarter("h");
        for(int i = 0; i < temp.size(); i ++)
        {
            System.out.println(temp.remove().word);
        }
        Assert.assertEquals(null, x.findStarter("lo"));
        Assert.assertEquals("heap", x.findStarter("he").remove().word);
        Assert.assertEquals("hat", x.findStarter("h").remove().word);


    }
    @Test
    public void testSort() {
        Trie x = new Trie();
        x.insertMain("ha", 1);
        x.insertMain("he", 2);
        x.insertMain("hi", 3);
        x.insertMain("hl", 4);
        x.insertMain("hz", 5);
        x.insertMain("hq", 6);
        x.insertMain("hw", 7);
        x.insertMain("hy", 8);
        x.insertMain("hd", 9);
        x.insertMain("hs", 10);
        x.insertMain("hsl", 20);
        x.insertMain("all", 11);
        PriorityQueue<Node> temp = x.findStarter("h");
        x.sortAndPrint(temp);
//        Should Print
//
//        hd
//        hw
//        hq
//        hw
//        hy

    }
    @Test
    public void testLarge() throws IOException {
        Trie x = new Trie();
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\cassi\\ATDP\\Porject-2\\count_1w.txt"));
        String line;
        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] values = line.split("\t");
            long fre = Long.parseLong(values[1]);
            x.insertMain(values[0], fre);
            i++;
            if(i > 10000)
            {
                break;
            }
        }
        PriorityQueue<Node> temp = x.findStarter("t");
//        System.out.println(temp.remove().wF);
        System.out.println(x.starter.get('t').get('h').get('e').word);

    }

}
