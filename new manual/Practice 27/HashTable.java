import java.util.HashMap;
import java.util.Map;

public class HashTable {
    public static void main(String[] args) {
        HashMap<Double, String> a = new HashMap<>();
        a.put(8.12, "Win");
        a.put(5.1, "lose");
        for (Map.Entry<Double, String> el : a.entrySet())
            System.out.println(el.getKey() + " " + el.getValue());
    }
}
