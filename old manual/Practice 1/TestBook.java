package classes;

public class TestBook {
    public static void main(String[] args) {
        Book a = new Book();
        Book b = new Book("Misha", "20/04/1983");
        Book c = new Book("Vlad", "23/12/2002");
        c.setAuthor("Kola");
        System.out.println(c);
    }
}