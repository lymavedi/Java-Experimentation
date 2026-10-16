public class Grading {
    public static void main(String[] args) {
        
        double adamMath = 91.5;
        int adamScience = 92;
        double adamEnglish = 95.7;
        double eveMath = 94.6;
        int eveScience = 90;
        double eveEnglish = 97.8;
        
        String stud1 = "Adam";
        String stud2 = "Eve";
        String adamPassed;
        String evePassed;
        
        double subtotal1 = adamMath + adamScience + adamEnglish;
        double subtotal2 = eveMath + eveScience + eveEnglish;
        double adamAverage = subtotal1 / 3;
        double eveAverage = subtotal2 / 3;
        
        boolean adamState = adamAverage >= 75;
        boolean eveState = eveAverage >= 75;
        
        if (adamState) {
            adamPassed = "PASSED";
        } else {
            adamPassed = "FAILED";
        }
        if (eveState) {
            evePassed = "PASSED";
        } else {
            evePassed = "FAILED";
        }
        
        System.out.println("GRADING RECORD");
        System.out.println("");
        System.out.println("Student One : " + stud1);
        System.out.println("    Math    : " + adamMath);
        System.out.println("    Science : " + adamScience);
        System.out.println("    English : " + adamEnglish);
        System.out.println("");
        System.out.printf("    Average : %.2f%n", adamAverage);
        System.out.println("    Status  : " + adamPassed);
        System.out.println("");
        System.out.println("Student Two : " + stud2);
        System.out.println("    Math    : " + eveMath);
        System.out.println("    Science : " + eveScience);
        System.out.println("    English : " + eveEnglish);
        System.out.println("");
        System.out.printf("    Average : %.2f%n", eveAverage);
        System.out.println("    Status  : " + evePassed);
        System.out.println("");
    }
}