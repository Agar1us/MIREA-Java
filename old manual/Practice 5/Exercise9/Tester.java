package Exercise9;

import java.util.Scanner;

public class Tester {
    public static int sequence(int a, int b){
        if (a > b + 1)
            return 0;
        if (a == 0 || b == 0)
            return 1;
        return sequence(a, b - 1) + sequence(a - 1, b - 1);
    }

    public static void main(String []args){
        int a, b;
        Scanner input = new Scanner(System.in);
        System.out.println("Введите количество нулей и единиц соответственно: ");
        a = input.nextInt();
        b = input.nextInt();;
        int ans = sequence(a, b);
        System.out.println("Ответ: " + ans);
    }
}
