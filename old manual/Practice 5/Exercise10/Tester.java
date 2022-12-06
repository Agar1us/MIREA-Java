package Exercise10;

import java.util.Scanner;

public class Tester {

    public static int reverse(int mainValue, int value){
        if (mainValue == 0)
            return value;
        return reverse(mainValue/10, value*10 + mainValue%10);
    }

    public static void main(String []args){
        int n;
        Scanner input = new Scanner(System.in);
        System.out.println("Введите число: ");
        n = input.nextInt();
        int ans = reverse(n, 0);
        System.out.println("Ответ: " + ans);
    }
}
