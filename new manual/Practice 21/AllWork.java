import java.io.File;
import java.nio.file.Paths;
import java.util.*;

public class AllWork {
    //Задание 1
    public static <T> ArrayList<T> arrayToList(T[] arr){
        if(arr == null)
            throw new IllegalArgumentException("Пустой массив");
        ArrayList<T> newArr = new ArrayList<>(arr.length);
        Collections.addAll(newArr, arr);
        return newArr;
    }

    //Задание 3
    public static <T> T get(T[] arr, int i){
        if (i < 0 || i >= arr.length)
            throw new IndexOutOfBoundsException("Размер массива: " + arr.length + ", Позиция: " + i);
        return arr[i];
    }

    //Задание 4
    public static ArrayList<File> DirectoryRead(String path){
        File f = new File(path);
        if (!f.exists() || !f.isDirectory())
            throw new IllegalArgumentException("Некорректный путь");
        ArrayList<File> lf = new ArrayList<File>();
        Collections.addAll(lf, Objects.requireNonNull(f.listFiles()));
        try {
            for (int i = 0; i < 5; i++)
                System.out.println(lf.get(i).getName());
        } catch (Exception e) {
            System.out.println("В данном каталоге находится меньше 5 файлов");
        }
        return lf;
    }

    //Задание 5
    public static <T> HashSet<T> arrayToHashSet(T[] arr){
        if(arr == null)
            throw new IllegalArgumentException("Пустой массив");
        HashSet<T> ans = new HashSet<>(arr.length);
        Collections.addAll(ans, arr);
        return ans;
    }

    public static <K, V> HashMap<K, V> arrayToHashMap(K[] arr, V[] vArr){
        if(arr == null || vArr == null)
            throw new IllegalArgumentException("Пустой массив");
        if(vArr.length < arr.length)
            throw new IllegalArgumentException("Массив значений меньше массива ключей");
        HashMap<K, V> m = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            m.put(arr[i], vArr[i]);
        }
        return m;
    }

    public static void main(String[] args) {
        String[] a = new String[]{"Your", "name", "is", "Alex"};
        ArrayList<String> l = arrayToList(a);
        System.out.println(l + "\n");

        ArrayClass<Integer> tmp1 = new ArrayClass<>(8);
        for(int i = 0; i<20;i++)
            tmp1.add(i);
        System.out.println(tmp1);
        for(int i = 5; i < 13; i++)
            tmp1.remove(i);
        System.out.println(tmp1);
        System.out.println(tmp1.get(5) + "\n");

        ArrayClass<String> tmp2 = new ArrayClass<>();
        System.out.println(tmp2);
        for (int i = 0; i < 10; i++) {
            tmp2.add("Новое значение " + (i+1));
        }
        System.out.println(tmp2 + "\n");

        ArrayClass<String> tmp3 = new ArrayClass<>(tmp2);
        System.out.println(tmp3);
        tmp3.remove(5);
        System.out.println(tmp3.get(5));
        System.out.println(tmp2.get(5));
        tmp3.sort(String::compareTo);
        System.out.println(tmp3 + "\n");

        System.out.println(get(a, 0));
        System.out.println(get(a, 2) + "\n");

        ArrayList<File> files = DirectoryRead(Paths.get("").toAbsolutePath().toString());
        System.out.println();
        System.out.println(files + "\n");

        HashSet<String> set = arrayToHashSet(a);
        System.out.println(set);

        HashMap<String, String> map = arrayToHashMap(a, new String[]{"H", "w", "!"});
        System.out.println(map);
    }
}
