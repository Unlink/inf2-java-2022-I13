import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Michal
 * Date: 22. 2. 2022
 * Time: 13:23
 */
public class Main {

    public static void main(String[] args) {
        //TODO Write your code
        System.out.println("Ahoj Informatika");
        System.out.print("Zadaj meno: ");
        Scanner scanner = new Scanner(System.in);
        String meno = scanner.nextLine();
        System.out.println("Ahoj " + meno);


        Cislo hahaha = new Cislo(3.14);
        hahaha.vypisNasobilku(5, 10);

        Student student1 = new Student("12345", "Janko", "Hrasko");
        Student student2 = new Student("12342", "Ferko", "Hrasko");
        Skupina s = new Skupina("5A");
        s.pridajStudenta(student1);
        s.vypisStudentov();

    }
}
