public class AcademicPerformance {
    public static void main(String[] args) {
        
        String studentName = "John S. Batumbakal";
    
        int scoreMath = 91;
        int scoreScience = 88; 
        int scoreEnglish = 79;
        int attendanceDays = 41;
        
        final int GENERAL_AVERAGE = 75;
        final int ACCEPTABLE_PRC_ATTENDANCE = 80;
        final int TTLSCHOOL_DAY = 71;
        
        int average = (scoreEnglish + scoreScience + scoreMath) / 3;
        
        int daysAttended = (attendanceDays * 100) / TTLSCHOOL_DAY;
        
        boolean attendancePlausibility = daysAttended >= ACCEPTABLE_PRC_ATTENDANCE;
        boolean gradePlausibility = average >= GENERAL_AVERAGE;
        boolean academicRetention = attendancePlausibility && gradePlausibility;
        
        System.out.println("            BATUMBAKAL HIGH SCHOOL REPORT CARD  |  TERM ONE");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Student: " + studentName);
        System.out.println("");
        System.out.println("Days Attended: " + attendanceDays + " days (" + daysAttended + "%) out of " + TTLSCHOOL_DAY + " days.");
        System.out.println("");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                            GRADES");
        System.out.println("Mathematics: " + scoreMath);
        System.out.println("Science: " + scoreScience);
        System.out.println("English: " + scoreEnglish);
        System.out.println("");
        System.out.println("Average Grade: " + average);
        System.out.println("");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("                        STATUS REPORT"); 
        System.out.println("Did the learner attend a satisfactory amount of days?: " + attendancePlausibility);
        System.out.println("Did the learner meet the expected Academic Requirements?: " + gradePlausibility);
        System.out.println("Did the learner meet both requirements?: " + academicRetention);
    } 
}