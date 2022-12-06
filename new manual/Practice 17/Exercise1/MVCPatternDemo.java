package Exercise1;

public class MVCPatternDemo {
    public static void main(String [] args){
        Student model = retriveStudentFromDatabase();
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        controller.updateView();
        controller.setStudentName("Sasha");
        System.out.println("\nAfter updating, Student Details are as follows");
        controller.updateView();
    }
    private static Student retriveStudentFromDatabase(){
        Student Student = new Student();
        Student.setName("Alex");
        Student.setRollNo("abcd");
        return Student;
    }
}
