import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        TreeMap<Integer, TreeSet<String>> map = new TreeMap<Integer, TreeSet<String>>();
        for (int i = 0; i < n; i++) {
            String name = scan.next();
            Integer score = scan.nextInt( );
            if (!map.containsKey(score)) {
                map.put(score, new TreeSet<String>());
                map.get(score).add(name);
            } else {
                map.get(score).add(name);
            }
        }
        int pos = 1;
        for (Integer score : map.descendingKeySet()) {
            if (map.get(score).size() == 1) {
                for (String name : map.get(score)) {
                    System.out.println(pos + " " + name);
                }
                pos++;
            } else {
                for (String name : map.get(score)) {
                    System.out.println(pos + "-" + (pos + map.get(score).size() - 1) + " " + name);
                }
                pos += map.get(score).size();
            }
        }
    }
}