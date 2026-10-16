import java.util.Scanner;

public class PrototypeJavaCodeVerOne {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("THE PROGRAM IS LOADING. PLEASE WAIT.");
        System.out.println("");
        
        try {
                Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print("Loading");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        System.out.println("");
        System.out.println("");
        System.out.println("                Scanner Prototype Project Test-001              ");
        System.out.println("");
        
        try {
                Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
            
        System.out.println("This project is a General Average Calculator which takes values from a Written Task, Performance Task, and Exam, which is computed into the subject grade, then divided with other subject grades to get the general average of the student.");
        
        try {
                Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("");
        System.out.println("Additonally, this program is composed of four phases: Subject Average Calculator, General Average Calculator, Grade Checks,  Final Score Display");
        System.out.println("");
        
        try {
                Thread.sleep(15000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        System.out.println("                Scanner Prototype Project Test-001              ");
        System.out.println("                  SCPTECH 11A GRADE CALCULATOR                  ");
        System.out.println("");
        System.out.println("");
        
        try {
                Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Phase 1A: input of student details
        System.out.println("Input Student's Full Name: ");
        String learner = input.nextLine();
        System.out.println("");
        
        System.out.println("Input Student's Full Student ID Number: ");
        String studID = input.nextLine();
        System.out.println("");
        
        System.out.println("Input Student's Days Attended out of 70 School Days: ");
        int attendanceDays = input.nextInt();
        System.out.println("");
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        try {
                Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.print("Processing");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        // Phase 1B: input of subject scores
        System.out.println("----------------------------------------------------------------");
        System.out.println("                           MATHEMATICS                          ");
        System.out.println("");
        System.out.println("Input first written task score: ");
        double mathWritten1 = input.nextDouble();
        System.out.println("Input second written task score: ");
        double mathWritten2 = input.nextDouble();
        System.out.println("");
        System.out.println("Input performance task score: ");
        double mathPerformance = input.nextDouble();
        System.out.println("");
        System.out.println("Input quarterly exam score: ");
        double mathExam = input.nextDouble();
        System.out.println("");
        System.out.println("");
        double mathAverage = (mathWritten1 + mathWritten2 + mathPerformance + mathExam) / 4.0;
        System.out.print("Calculating ");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        System.out.println("");
        System.out.println("The subject average is: " + mathAverage);
        System.out.println("");
        System.out.println("");

        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        System.out.println("----------------------------------------------------------------");
        System.out.println("                            SCIENCE                             ");
        System.out.println("");
        System.out.println("");
        System.out.println("Input first written task score: ");
        double scienceWritten1 = input.nextDouble();
        System.out.println("Input second written task score: ");
        double scienceWritten2 = input.nextDouble();
        System.out.println("");
        System.out.println("Input performance task score: ");
        double sciencePerformance = input.nextDouble();
        System.out.println("");
        System.out.println("Input quarterly exam score: ");
        double scienceExam = input.nextDouble();
        System.out.println("");
        System.out.println("");
        double scienceAverage = (scienceWritten1 + scienceWritten2 + sciencePerformance + scienceExam) / 4.0;
        System.out.print("Calculating ");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        System.out.println("");
        System.out.println("The subject average is: " + scienceAverage);
        System.out.println("");
        System.out.println("");

        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        System.out.println("----------------------------------------------------------------");
        System.out.println("                            ENGLISH                             ");
        System.out.println("");
        System.out.println("Input first written task score: ");
        double englishWritten1 = input.nextDouble();
        System.out.println("Input second written task score: ");
        double englishWritten2 = input.nextDouble();
        System.out.println("");
        System.out.println("Input performance task score: ");
        double englishPerformance = input.nextDouble();
        System.out.println("");
        System.out.println("Input quarterly exam score: ");
        double englishExam = input.nextDouble();
        System.out.println("");
        System.out.println("");
        double englishAverage = (englishWritten1 + englishWritten2 + englishPerformance + englishExam) / 4.0;
        System.out.print("Calculating ");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        System.out.println("");
        System.out.println("The subject average is: " + englishAverage);
        System.out.println("");
        System.out.println("");

        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        System.out.println("----------------------------------------------------------------");
        System.out.println("                            FILIPINO                            ");
        System.out.println("");
        System.out.println("Input first written task score: ");
        double filipinoWritten1 = input.nextDouble();
        System.out.println("Input second written task score: ");
        double filipinoWritten2 = input.nextDouble();
        System.out.println("");
        System.out.println("Input performance task score: ");
        double filipinoPerformance = input.nextDouble();
        System.out.println("");
        System.out.println("Input quarterly exam score: ");
        double filipinoExam = input.nextDouble();
        System.out.println("");
        System.out.println("");
        double filipinoAverage = (filipinoWritten1 + filipinoWritten2 + filipinoPerformance + filipinoExam) / 4.0;
        System.out.print("Calculating ");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        System.out.println("");
        System.out.println("The subject average is: " + filipinoAverage);
        System.out.println("");
        System.out.println("");

        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        System.out.println("----------------------------------------------------------------");
        System.out.println("                            PAGKALIPI                           ");
        System.out.println("");
        System.out.println("Input first written task score: ");
        double pagkalipiWritten1 = input.nextDouble();
        System.out.println("Input second written task score: ");
        double pagkalipiWritten2 = input.nextDouble();
        System.out.println("");
        System.out.println("Input performance task score: ");
        double pagkalipiPerformance = input.nextDouble();
        System.out.println("");
        System.out.println("Input quarterly exam score: ");
        double pagkalipiExam = input.nextDouble();
        System.out.println("");
        System.out.println("");
        double pagkalipiAverage = (pagkalipiWritten1 + pagkalipiWritten2 + pagkalipiPerformance + pagkalipiExam) / 4.0;
        System.out.print("Calculating ");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        System.out.println("");
        System.out.println("The subject average is: " + pagkalipiAverage);
        System.out.println("");
        System.out.println("");

        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        System.out.println("----------------------------------------------------------------");
        System.out.println("                            COMPROG                             ");
        System.out.println("");
        System.out.println("Input first written task score: ");
        double comprogWritten1 = input.nextDouble();
        System.out.println("Input second written task score: ");
        double comprogWritten2 = input.nextDouble();
        System.out.println("");
        System.out.println("Input performance task score: ");
        double comprogPerformance = input.nextDouble();
        System.out.println("");
        System.out.println("Input quarterly exam score: ");
        double comprogExam = input.nextDouble();
        System.out.println("");
        System.out.println("");
        double comprogAverage = (comprogWritten1 + comprogWritten2 + comprogPerformance + comprogExam) / 4.0;
        System.out.print("Calculating ");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        System.out.println("");
        System.out.println("The subject average is: " + comprogAverage);
        System.out.println("");
        System.out.println("");

        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        
        
        // Phase 2A: General Average Calculator
        System.out.print("Loading");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        System.out.println("");
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Retrieving Subject Averages");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        System.out.println("");
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Learner             : " + learner);
        System.out.println("");
        System.out.println("Mathematics Average : " + mathAverage);
        System.out.println("Science Average     : " + scienceAverage);
        System.out.println("English Average     : " + englishAverage);
        System.out.println("Filipino Average    : " + filipinoAverage);
        System.out.println("PagKaLiPi Average   : " + pagkalipiAverage);
        System.out.println("ComProg Average     : " + comprogAverage);
        System.out.println("");
        System.out.print("Beginning General Average calculations");
        
        double generalAverage = (mathAverage + scienceAverage + englishAverage + filipinoAverage + pagkalipiAverage + comprogAverage) / 6.0;
        
        for (int i = 0; i < 4; i++) {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        
        System.out.println("");
        System.out.println(learner + " has a General Average of " + generalAverage);
        System.out.println("");
        
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Phase 3: Status Evaluation for PASS, FAILED, HONOR, SCHOLARSHIP, QUARTERLY PAYMENT, and DISCOUNT APPLICABILITY
        System.out.print("Beginning evaluation process");
        for (int i = 0; i < 4; i++) {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        
        boolean studentPassed = generalAverage >= 75.0;
        boolean isHonor = generalAverage >= 90.0;
        boolean passableAttendance = attendanceDays >= 56.0;
        
        System.out.println("Does the student have an active scholarship? (true/false): ");
        boolean hasScholarship = input.nextBoolean();
        
        final double BASE_FEE = 16000.0;
        final double REMEDIATION = 4000.0;
        
        
        
        // Phase 4: Report Card
        System.out.print("Loading Report Card");
        for (int i = 0; i < 4; i++) {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("----------------------------------------------------------------");
        System.out.println("                        FINAL REPORT CARD                       ");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Learner Name: " + learner);
        System.out.println("Student Number: " + studID);
        System.out.println("");
        System.out.println("");
        System.out.println("Mathematics Average : " + mathAverage);
        System.out.println("Science Average     : " + scienceAverage);
        System.out.println("English Average     : " + englishAverage);
        System.out.println("Filipino Average    : " + filipinoAverage);
        System.out.println("PagKaLiPi Average   : " + pagkalipiAverage);
        System.out.println("ComProg Average     : " + comprogAverage);
        System.out.println("");
        System.out.println("General Average: " + generalAverage);
        System.out.println("");
        
        if (studentPassed) { 
            System.out.println("Status: PASSED");
            
            if (passableAttendance) { 
                System.out.println("The Learner has attended a good amount of academic days.");
            
                if (isHonor) {
                    System.out.println("Standing: Honor Student");
                    
                    if (hasScholarship) {
                        double finalFee = BASE_FEE - (BASE_FEE * 0.20);
                        System.out.println("The Learner is a Honor Student and has an active Scholarship Discount. Discount is applied.");
                        System.out.println("Original Fee: ₱" + BASE_FEE);
                        System.out.println("Discounted Total Fee: ₱" + finalFee);
                    } else {
                        System.out.println("Term Fee: ₱" + BASE_FEE);
                    }
                        
                } else {
                    System.out.println("Standing: Regular Student");
                    System.out.println("Term Fee: ₱16,000.00");
                }
                
            } else {
                System.out.println("Warning: Attendance is below requirements, though grades passed.");
            }
            
        } else {
            double remediationFee = BASE_FEE + REMEDIATION;
            System.out.println(learner + " has FAILED the term. Remediation required.");
            System.out.println("Term Fee: ₱" + BASE_FEE);
            System.out.println("Term Fee w/ Remediation Fee: ₱" + remediationFee);
        }
    }
}