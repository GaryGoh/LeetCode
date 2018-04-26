package google.LRUCache;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

public class LRUhelper {
    public String readTestData(String path) {
        StringBuilder res = new StringBuilder("[");

        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            String[] input = new String[2];
            Iterator it = stream.iterator();
            int i = 0;
            while (it.hasNext()) {
                input[i] = it.next().toString();
                i ++;
            }

            String[] op = input[0].split(",");
            String[] val = input[1].split(";");
            LRUCache cache = new LRUCache(Integer.valueOf(val[0]));

            for (int l = 0; l < op.length; l ++) {
                if (op[l].equals("put")) {
                    int val1 = Integer.valueOf(val[l].split(",")[0]);
                    int val2 = Integer.valueOf(val[l].split(",")[1]);
                    cache.put(val1, val2);
                    res.append("null,");
                }

                if (op[l].equals("get")) {
                    int val1 = Integer.valueOf(val[l]);
                    res.append(cache.get(val1) + "," );
                }
            }
            res.delete(res.length() - 1, res.length());
            res.append("]");
            return res.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res.toString();
    }
}
