package classes;

public class Ball {
    private int radius;
    private String material;

    public Ball(int newRadius, String newMaterial){
        radius = newRadius;
        material = newMaterial;
    }

    public int getRadius() {
        return radius;
    }

    public String getMaterial() {
        return material;
    }

    public void setRadius(int newRadius){
        radius = newRadius;
    }

    public void setMaterial(String newMaterial){
        material = newMaterial;
    }

    public String toString(){
        return "Мяч создан из " + material + ". Его радиус: " + radius;
    }
}
