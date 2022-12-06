package classes;

public class TestBall {
    public static void main(String[] args) {
        Ball a = new Ball(90, "metal");
        Ball b = new Ball(100, "plastic");
        a.setMaterial("glass");
        System.out.println(a);
    }
}
