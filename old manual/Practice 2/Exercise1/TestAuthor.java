package Exercise1;

public class TestAuthor {
    public static void main(String[] args) {
        Author b1 = new Author("Sergey", "kalinka22@gmail.com", 'M');
        System.out.println(b1);
        b1.setEmail("kalinin2003@list.ru");
        System.out.println(b1);
    }
}
