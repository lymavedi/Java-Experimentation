public class GradingArray {
    public static void main(String[] args) {
        
        double[] adamGrade = {91.5, 92.0, 95.7};
        double[] eveGrade = {94.6, 90.0, 97.8};
        
        String stud1 = "Adam";
        String stud2 = "Eve";
        String adamPassed;
        String evePassed;
        
        double subtotal1 = 0.0;
        double subtotal2 = 0.0;
        
        for (int i = 0; i < adamGrade.length; i++) {
            subtotal1 += adamGrade[i];
        }
        
        for (int i = 0; i < eveGrade.length; i++) {
            subtotal2 += eveGrade[i];
        }
        
        double adamAverage = subtotal1 / adamGrade.length;
        double eveAverage = subtotal2 / eveGrade.length;
        
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
        System.out.println("    Math    : " + adamGrade[0]);
        System.out.println("    Science : " + adamGrade[1]);
        System.out.println("    English : " + adamGrade[2]);
        System.out.println("");
        System.out.printf("    Average : %.2f%n", adamAverage);
        System.out.println("    Status  : " + adamPassed);
        System.out.println("");
        System.out.println("Student Two : " + stud2);
        System.out.println("    Math    : " + eveGrade[0]);
        System.out.println("    Science : " + eveGrade[1]);
        System.out.println("    English : " + eveGrade[2]);
        System.out.println("");
        System.out.printf("    Average : %.2f%n", eveAverage);
        System.out.println("    Status  : " + evePassed);
        System.out.println("");
    }
}