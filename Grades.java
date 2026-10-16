package SCPTECHA;

public class Grades {
    public static void main(String[] arg) {

        String studentOne = "Alex";
        String studentTwo = "Brian";
        String studentThree = "Carlo";

        int gradeAlex = 10;
        int gradeBrian = 12;
        int gradeCarlo = 15;
        int finalizedGrade = gradeAlex + gradeBrian + gradeCarlo;

        System.out.println("Grades of SCPTech 11 A Students: ");
        System.out.println("------------------------------------------");
        System.out.println("     Student     ||     Grade     ");
        System.out.println(studentOne + " has the grade of " + gradeAlex + "/20");
        System.out.println(studentTwo + " has the grade of " + gradeBrian + "/20");
        System.out.println(studentThree + " has the grade of " + gradeCarlo + "/20");
        System.out.println("------------------------------------------");
        System.out.println("With the sum total of all students being " + finalizedGrade + " out of 60 points.");
    }
}