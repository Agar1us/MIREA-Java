package Exercise1_2_3;

public class Animal {
    private String name, kind;
    Animal(){
        name = "Agar";
        kind = "delphin";
    }

    @Override
    public String toString() {
        return "Это животное является: " + kind + ". Его имя: " + name;
    }
}
