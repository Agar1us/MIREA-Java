import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Math.abs;

public class hashtab {

    private class Node{
        private final String key;
        private final String value;

        Node(String key, String value){
            this.key = key;
            this.value = value;
        }
    }
    int size;
    ArrayList<LinkedList<Node>> hashTable;

    public int hashtabHash(String key){
        return abs(key.hashCode() % size);
    }

    public void hashtabInit(int size){
        this.size = size;
        hashTable = new ArrayList<>(size);
    }

    public void hashtabAdd(String key, String value){
        int index = hashtabHash(key);
        Node element = new Node(key, value);
        LinkedList<Node> tmp;
        try{
            tmp = hashTable.remove(index);
            tmp.add(element);
        }
        catch (IndexOutOfBoundsException ingnored){
            tmp = new LinkedList<>();
            tmp.add(element);
        }
        hashTable.add(index, tmp);
    }

    public String hashtabLookup(String key){
        int index = hashtabHash(key);
        try{
            LinkedList<Node> tmp = hashTable.get(index);
            for (Node el: tmp)
                if (Objects.equals(el.key, key))
                    return el.value;
            return "Такого элемента не существует";
        }
        catch (IndexOutOfBoundsException ignored){
            return "Такого элемента не существует";
        }
    }

    public String hashtabDelete(String key){
        int index = hashtabHash(key);
        LinkedList<Node> tmp = hashTable.remove(index);
        String ans = "Такого элемента не существует";
        for (Node el: tmp)
            if (Objects.equals(el.key, key)){
                ans = el.value;
                tmp.remove(el);
                break;
            }
        hashTable.add(index, tmp);
        return ans;
    }

    public static void main(String[] args) {
        hashtab tab = new hashtab();
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество записей: ");
        int count = scan.nextInt();
        tab.hashtabInit(count);
        scan.nextLine();
        for (int i = 0; i < count; ++i){
            System.out.print("Введите через пробел ключ и значение: ");
            String[] line = scan.nextLine().split(" ");
            tab.hashtabAdd(line[0], line[1]);
        }
        System.out.print("Введите ключ, который хотите найти в словаре: ");
        String key = scan.next();
        String value = tab.hashtabLookup(key);
        System.out.println("Значение ключа: " + value);
        System.out.print("Введите ключ, который хотите удалить из словаря: ");
        key = scan.next();
        value = tab.hashtabLookup(key);
        System.out.println("Значение ключа: " + value);
    }
}