import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Exercise3 {
    public static String play(ArrayDeque<Integer> first, ArrayDeque<Integer> second){
        int count = 0;
        while(!first.isEmpty() && !second.isEmpty() && count < 106){
            if(first.peek() > second.peek() && first.peek() - second.peek() != 9 || second.peek()- first.peek() == 9){
                first.add(first.remove());
                first.add(second.remove());
            }
            else{
                second.add(first.remove());
                second.add(second.remove());
            }
            count++;
        }
        String res = "";
        if(second.isEmpty())
            res += "first ";
        else if (first.isEmpty())
            res += "second ";
        res += count;
        if(count >= 106)
            res += " botva";
        return res;
    }


    public static void main(String[] args) {
        ArrayDeque<Integer> first = new ArrayDeque<Integer>();
        ArrayDeque<Integer> second = new ArrayDeque<Integer>();
        for (int i = 0; i < 5; ++i){
            first.addLast(i*2 + 1);
            second.addLast((i * 2 + 2) % 10);
        }
        System.out.println(play(first, second));
    }
}
