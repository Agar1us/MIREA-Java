import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetIntoTree {
    public static <T> Set<T> getInstance(Set<T> hashSet) {
        return new TreeSet<T>(hashSet);
    }

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("RED");
        hashSet.add("BLUE");
        hashSet.add("GREEN");
        Set<String> treeSet = getInstance(hashSet);
        System.out.println(treeSet);
    }
}
