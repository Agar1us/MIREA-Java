import java.util.Scanner;
import java.util.regex.Pattern;

public class IPv4 {
    public static void main(String[] args) {
        //192.168.50.1
        String reg = "^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}$";
        System.out.print("Введите адрес в формате IPv4: ");
        Scanner scan = new Scanner(System.in);
        String address = scan.next();
        if (Pattern.matches(reg, address))
            System.out.println("Все хорошо");
        else System.out.println("Все плохо");
    }
}
