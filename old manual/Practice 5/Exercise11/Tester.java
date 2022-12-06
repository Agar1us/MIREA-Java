package Exercise11;

import java.util.Objects;
import java.util.Scanner;

public class Tester {
    public static int counter(){
        System.out.println("Введите следующий символ последовательности:");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        if (Objects.equals(str, "00"))
            return 0;
        if (Objects.equals(str, "1"))
            return counter() + 1;
        else
            return counter();
    }
    public static void main(String []args){
        int ans = counter();
        System.out.println("Ответ: " + ans);
    }
}
