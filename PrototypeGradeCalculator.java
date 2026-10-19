import java.util.Scanner;

/*
A changelog: 
Version Prot.0.1.1-Alpha | October 16, 2026
- Base code. 
- initially nota grade calculator but a Scanner test, taking in String inputs. 
- multiple Scanner objects have been made

Version Prot.0.1.2-Alpha | October 16, 2026
- code made into a grade calculator
- code prioritized over pseudocode / flowcharting [big mistake]
- multiple scanner objects have been observed to cause the program to significantly load slower. researched more and reduced scanner object to a single one to decrease loading and processing time
- grade calculator process has been assumed without proper research, primarily only focusing on the input of final grades to get quarterly general average
- added the input areas for individual grades for Written, Performance, and Quarterly Assessment 
- mistake discovered regarding the calculation of Raw Score, Percentage Score, and Weighted Score, planning to continue it next coding session
- researched Java equivalents of C++ Sleep function (sleep(5);) and Clear Screen function (clearScreen();) and implemented it in the code for clean output to not have a wall of text to scroll and look through when accidentally scrolling up to see values for the subject only
- added report card area
- general averages calculation areas for final grade

Version Prot.0.1.3-Alpha | October 19, 2026
- inclusion of weighted score, raw score, score constants, and proper grade calculation following DepEd score calculation per DepEd Order No. 8, s. 2015
- added a bunch of constants following DepEd weighted scores values for core and electives 
- included numerical limitations for the first values, e.g., number of days to not have numbers go out of bounds and test run of loops in math area + implementation of the weighted, percentage, and final score display system
- included decimal limiter to not have a lot of decimal places displayed on the screen
- math section completed with loops, decimal limiter, processing screen, display screen, valid input areas and rejection screen if numbers go out of bounds, made a centralized calculation section and constants section for subject individuality for scores
- science section completed with the same changed as math, improving it out of the "written scores + performance score + exam score / 4" approach which was completely wrong and only applied when getting quarterly average from all subjects
- english and filipino section have been improved too with the same modifications as above
- completed all subjects
- made decimal limiters for the averages section and report card display section
*/

public class PrototypeGradeCalculator {
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
        System.out.println("Additonally, this program is composed of four phases: Subject Average Calculator, General Average Calculator, Grade Checks,  Final Score Display. Note: I do not know how to incorporate the transmutation table yet, so it will not be included. Everything will follow the new possible order that final grades as calculated will never be transmutated on the next school year.");
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
        
        final double QUARTERLY_SCHOOL_DAYS = 70.0;
        final double QUARTERLY_MIN_ATTENDANCE = 0.0;
        
        System.out.println("Input Student's Full Name: ");
        String learner = input.nextLine();
        System.out.println("");
        
        System.out.println("Input Student's Full Student ID Number: ");
        String studID = input.nextLine();
        System.out.println("");
        
        System.out.println("Input Student's Days Attended out of 70 School Days: ");
        double attendanceDays = input.nextDouble();
        System.out.println("");
        while (attendanceDays < QUARTERLY_MIN_ATTENDANCE || attendanceDays > QUARTERLY_SCHOOL_DAYS) {
            System.out.println("The amount of days are out of bounds.");
            System.out.print("Recheck the days attended by the learner and input it again: ");
            attendanceDays = input.nextDouble();
            System.out.println("");
        }
        
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
        
        // All Subject Constants
        final double CORE_WRITTEN_WEIGHT = 0.25;
        final double CORE_PERFORMANCE_WEIGHT = 0.45; 
        final double CORE_QUARTERLY_ASSESSMENT_WEIGHT = 0.30;
        final double ELECTIVE_WRITTEN_WEIGHT = 0.20;
        final double ELECTIVE_PERFORMANCE_WEIGHT = 0.60;
        final double ELECTIVE_QUARTERLY_ASSESSMENT_WEIGHT = 0.20;
        final double MIN_SCORE = 0.0;
        
        // Math Section
        final double MATH_WRITTEN_ONE_LIMIT = 35.0;
        final double MATH_WRITTEN_TWO_LIMIT = 45.0;
        final double MATH_PERFORMANCE_LIMIT = 75.0;
        final double MATH_QUARTERLY_ASSESSMENT_LIMIT = 90.0;
        
        final double MATH_WRITTEN_HIGHEST_POSSIBLE_SCORE = MATH_WRITTEN_ONE_LIMIT + MATH_WRITTEN_TWO_LIMIT;
        final double MATH_PERFORMANCE_HIGHEST_POSSIBLE_SCORE = MATH_PERFORMANCE_LIMIT;
        final double MATH_QUARTERLY_HIGHEST_POSSIBLE_SCORE = MATH_QUARTERLY_ASSESSMENT_LIMIT;
        
        System.out.println("----------------------------------------------------------------");
        System.out.println("                           MATHEMATICS                          ");
        System.out.println("");
        System.out.println("Input first written task score (_/" + MATH_WRITTEN_ONE_LIMIT + "): ");
        double mathWritten1 = input.nextDouble();
        while (mathWritten1 < MIN_SCORE || mathWritten1 > MATH_WRITTEN_ONE_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + MATH_WRITTEN_ONE_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            mathWritten1 = input.nextDouble();
            System.out.println("");
        }
        System.out.println("Input second written task score (_/" + MATH_WRITTEN_TWO_LIMIT + "): ");
        double mathWritten2 = input.nextDouble();
        while (mathWritten2 < MIN_SCORE || mathWritten2 > MATH_WRITTEN_TWO_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + MATH_WRITTEN_TWO_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            mathWritten2 = input.nextDouble();
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Input performance task score (_/" + MATH_PERFORMANCE_LIMIT + "): ");
        double mathPerformance = input.nextDouble();
        while (mathPerformance < MIN_SCORE || mathPerformance > MATH_PERFORMANCE_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + MATH_PERFORMANCE_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            mathPerformance = input.nextDouble();
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Input quarterly exam score (_/" + MATH_QUARTERLY_ASSESSMENT_LIMIT + "): ");
        double mathExam = input.nextDouble();
        while (mathExam < MIN_SCORE || mathExam > MATH_QUARTERLY_ASSESSMENT_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + MATH_QUARTERLY_ASSESSMENT_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            mathExam = input.nextDouble();
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
        
        double mathWrittenPercentageScore = ((mathWritten1 + mathWritten2) / MATH_WRITTEN_HIGHEST_POSSIBLE_SCORE) * 100.0;
        double mathPerformancePercentageScore = (mathPerformance / MATH_PERFORMANCE_HIGHEST_POSSIBLE_SCORE) * 100.0;
        double mathQuarterlyPercentageScore = (mathExam / MATH_QUARTERLY_HIGHEST_POSSIBLE_SCORE) * 100.0;
        
        double mathWrittenWeightedScore = mathWrittenPercentageScore * CORE_WRITTEN_WEIGHT;
        double mathPerformanceWeightedScore = mathPerformancePercentageScore * CORE_PERFORMANCE_WEIGHT;
        double mathQuarterlyWeightedScore = mathQuarterlyPercentageScore * CORE_QUARTERLY_ASSESSMENT_WEIGHT;
        
        double mathAverage = mathWrittenWeightedScore + mathPerformanceWeightedScore + mathQuarterlyWeightedScore;
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
        System.out.println("The subject average is: " + String.format("%.2f", mathAverage));
        System.out.println("");
        System.out.println("");

        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        // Science Section
        final double SCIENCE_WRITTEN_ONE_LIMIT = 30.0;
        final double SCIENCE_WRITTEN_TWO_LIMIT = 25.0;
        final double SCIENCE_PERFORMANCE_LIMIT = 80.0;
        final double SCIENCE_QUARTERLY_ASSESSMENT_LIMIT = 60.0;
        
        final double SCIENCE_WRITTEN_HIGHEST_POSSIBLE_SCORE = SCIENCE_WRITTEN_ONE_LIMIT + SCIENCE_WRITTEN_TWO_LIMIT;
        final double SCIENCE_PERFORMANCE_HIGHEST_POSSIBLE_SCORE = SCIENCE_PERFORMANCE_LIMIT;
        final double SCIENCE_QUARTERLY_HIGHEST_POSSIBLE_SCORE = SCIENCE_QUARTERLY_ASSESSMENT_LIMIT;
        
        System.out.println("----------------------------------------------------------------");
        System.out.println("                            SCIENCE                             ");
        System.out.println("");
        System.out.println("Input first written task score (_/" + SCIENCE_WRITTEN_ONE_LIMIT + "): ");
        double scienceWritten1 = input.nextDouble();
        while (scienceWritten1 < MIN_SCORE || scienceWritten1 > SCIENCE_WRITTEN_ONE_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + SCIENCE_WRITTEN_ONE_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            scienceWritten1 = input.nextDouble();
            System.out.println("");
        }
        System.out.println("Input second written task score (_/" + SCIENCE_WRITTEN_TWO_LIMIT + "): ");
        double scienceWritten2 = input.nextDouble();
        while (scienceWritten2 < MIN_SCORE || scienceWritten2 > SCIENCE_WRITTEN_TWO_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + SCIENCE_WRITTEN_TWO_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            scienceWritten2 = input.nextDouble();
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Input performance task score (_/" + SCIENCE_PERFORMANCE_LIMIT + "): ");
        double sciencePerformance = input.nextDouble();
        while (sciencePerformance < MIN_SCORE || sciencePerformance > SCIENCE_PERFORMANCE_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + SCIENCE_PERFORMANCE_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            sciencePerformance = input.nextDouble();
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Input quarterly exam score (_/" + SCIENCE_QUARTERLY_ASSESSMENT_LIMIT + "): ");
        double scienceExam = input.nextDouble();
        while (scienceExam < MIN_SCORE || scienceExam > SCIENCE_QUARTERLY_ASSESSMENT_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + SCIENCE_QUARTERLY_ASSESSMENT_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            scienceExam = input.nextDouble();
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
        
        double scienceWrittenPercentageScore = ((scienceWritten1 + scienceWritten2) / SCIENCE_WRITTEN_HIGHEST_POSSIBLE_SCORE) * 100.0;
        double sciencePerformancePercentageScore = (sciencePerformance / SCIENCE_PERFORMANCE_HIGHEST_POSSIBLE_SCORE) * 100.0;
        double scienceQuarterlyPercentageScore = (scienceExam / SCIENCE_QUARTERLY_HIGHEST_POSSIBLE_SCORE) * 100.0;
        
        double scienceWrittenWeightedScore = scienceWrittenPercentageScore * CORE_WRITTEN_WEIGHT;
        double sciencePerformanceWeightedScore = sciencePerformancePercentageScore * CORE_PERFORMANCE_WEIGHT;
        double scienceQuarterlyWeightedScore = scienceQuarterlyPercentageScore * CORE_QUARTERLY_ASSESSMENT_WEIGHT;
        
        double scienceAverage = scienceWrittenWeightedScore + sciencePerformanceWeightedScore + scienceQuarterlyWeightedScore;
        
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
        System.out.println("The subject average is: " + String.format("%.2f", scienceAverage));
        System.out.println("");
        System.out.println("");

        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        // English section
        final double ENGLISH_WRITTEN_ONE_LIMIT = 40.0;
        final double ENGLISH_WRITTEN_TWO_LIMIT = 28.0;
        final double ENGLISH_PERFORMANCE_LIMIT = 50.0;
        final double ENGLISH_QUARTERLY_ASSESSMENT_LIMIT = 75.0;
        
        final double ENGLISH_WRITTEN_HIGHEST_POSSIBLE_SCORE = ENGLISH_WRITTEN_ONE_LIMIT + ENGLISH_WRITTEN_TWO_LIMIT;
        final double ENGLISH_PERFORMANCE_HIGHEST_POSSIBLE_SCORE = ENGLISH_PERFORMANCE_LIMIT;
        final double ENGLISH_QUARTERLY_HIGHEST_POSSIBLE_SCORE = ENGLISH_QUARTERLY_ASSESSMENT_LIMIT;
        
        System.out.println("----------------------------------------------------------------");
        System.out.println("                            ENGLISH                             ");
        System.out.println("");
        System.out.println("Input first written task score (_/" + ENGLISH_WRITTEN_ONE_LIMIT + "): ");
        double englishWritten1 = input.nextDouble();
        while (englishWritten1 < MIN_SCORE || englishWritten1 > ENGLISH_WRITTEN_ONE_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + ENGLISH_WRITTEN_ONE_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            englishWritten1 = input.nextDouble();
            System.out.println("");
        }
        System.out.println("Input second written task score (_/" + ENGLISH_WRITTEN_TWO_LIMIT + "): ");
        double englishWritten2 = input.nextDouble();
        while (englishWritten2 < MIN_SCORE || englishWritten2 > ENGLISH_WRITTEN_TWO_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + ENGLISH_WRITTEN_TWO_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            englishWritten2 = input.nextDouble();
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Input performance task score (_/" + ENGLISH_PERFORMANCE_LIMIT + "): ");
        double englishPerformance = input.nextDouble();
        while (englishPerformance < MIN_SCORE || englishPerformance > ENGLISH_PERFORMANCE_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + ENGLISH_PERFORMANCE_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            englishPerformance = input.nextDouble();
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Input quarterly exam score (_/" + ENGLISH_QUARTERLY_ASSESSMENT_LIMIT + "): ");
        double englishExam = input.nextDouble();
        while (englishExam < MIN_SCORE || englishExam > ENGLISH_QUARTERLY_ASSESSMENT_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + ENGLISH_QUARTERLY_ASSESSMENT_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            englishExam = input.nextDouble();
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
        
        double englishWrittenPercentageScore = ((englishWritten1 + englishWritten2) / ENGLISH_WRITTEN_HIGHEST_POSSIBLE_SCORE) * 100.0;
        double englishPerformancePercentageScore = (englishPerformance / ENGLISH_PERFORMANCE_HIGHEST_POSSIBLE_SCORE) * 100.0;
        double englishQuarterlyPercentageScore = (englishExam / ENGLISH_QUARTERLY_HIGHEST_POSSIBLE_SCORE) * 100.0;
        
        double englishWrittenWeightedScore = englishWrittenPercentageScore * CORE_WRITTEN_WEIGHT;
        double englishPerformanceWeightedScore = englishPerformancePercentageScore * CORE_PERFORMANCE_WEIGHT;
        double englishQuarterlyWeightedScore = englishQuarterlyPercentageScore * CORE_QUARTERLY_ASSESSMENT_WEIGHT;
        
        double englishAverage = englishWrittenWeightedScore + englishPerformanceWeightedScore + englishQuarterlyWeightedScore;
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
        System.out.println("The subject average is: " + String.format("%.2f", englishAverage));
        System.out.println("");
        System.out.println("");

        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        // Filipino Section
        final double FILIPINO_WRITTEN_ONE_LIMIT = 37.0;
        final double FILIPINO_WRITTEN_TWO_LIMIT = 15.0;
        final double FILIPINO_PERFORMANCE_LIMIT = 43.0;
        final double FILIPINO_QUARTERLY_ASSESSMENT_LIMIT = 50.0;
        
        final double FILIPINO_WRITTEN_HIGHEST_POSSIBLE_SCORE = FILIPINO_WRITTEN_ONE_LIMIT + FILIPINO_WRITTEN_TWO_LIMIT;
        final double FILIPINO_PERFORMANCE_HIGHEST_POSSIBLE_SCORE = FILIPINO_PERFORMANCE_LIMIT;
        final double FILIPINO_QUARTERLY_HIGHEST_POSSIBLE_SCORE = FILIPINO_QUARTERLY_ASSESSMENT_LIMIT;
        
        System.out.println("----------------------------------------------------------------");
        System.out.println("                            FILIPINO                            ");
        System.out.println("");
        System.out.println("Input first written task score (_/" + FILIPINO_WRITTEN_ONE_LIMIT + "): ");
        double filipinoWritten1 = input.nextDouble();
        while (filipinoWritten1 < MIN_SCORE || filipinoWritten1 > FILIPINO_WRITTEN_ONE_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + FILIPINO_WRITTEN_ONE_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            filipinoWritten1 = input.nextDouble();
            System.out.println("");
        }
        System.out.println("Input second written task score (_/" + FILIPINO_WRITTEN_TWO_LIMIT + "): ");
        double filipinoWritten2 = input.nextDouble();
        while (filipinoWritten2 < MIN_SCORE || filipinoWritten2 > FILIPINO_WRITTEN_TWO_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + FILIPINO_WRITTEN_TWO_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            filipinoWritten2 = input.nextDouble();
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Input performance task score (_/" + FILIPINO_PERFORMANCE_LIMIT + "): ");
        double filipinoPerformance = input.nextDouble();
        while (filipinoPerformance < MIN_SCORE || filipinoPerformance > FILIPINO_PERFORMANCE_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + FILIPINO_PERFORMANCE_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            filipinoPerformance = input.nextDouble();
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Input quarterly exam score (_/" + FILIPINO_QUARTERLY_ASSESSMENT_LIMIT + "): ");
        double filipinoExam = input.nextDouble();
        while (filipinoExam < MIN_SCORE || filipinoExam > FILIPINO_QUARTERLY_ASSESSMENT_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + FILIPINO_QUARTERLY_ASSESSMENT_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            filipinoExam = input.nextDouble();
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
        
        double filipinoWrittenPercentageScore = ((filipinoWritten1 + filipinoWritten2) / FILIPINO_WRITTEN_HIGHEST_POSSIBLE_SCORE) * 100.0;
        double filipinoPerformancePercentageScore = (filipinoPerformance / FILIPINO_PERFORMANCE_HIGHEST_POSSIBLE_SCORE) * 100.0;
        double filipinoQuarterlyPercentageScore = (filipinoExam / FILIPINO_QUARTERLY_HIGHEST_POSSIBLE_SCORE) * 100.0;
        
        double filipinoWrittenWeightedScore = filipinoWrittenPercentageScore * CORE_WRITTEN_WEIGHT;
        double filipinoPerformanceWeightedScore = filipinoPerformancePercentageScore * CORE_PERFORMANCE_WEIGHT;
        double filipinoQuarterlyWeightedScore = filipinoQuarterlyPercentageScore * CORE_QUARTERLY_ASSESSMENT_WEIGHT;
        
        double filipinoAverage = filipinoWrittenWeightedScore + filipinoPerformanceWeightedScore + filipinoQuarterlyWeightedScore;
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
        System.out.println("The subject average is: " + String.format("%.2f", filipinoAverage));
        System.out.println("");
        System.out.println("");

        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        // PAGKALIPI section
        final double PAGKALIPI_WRITTEN_ONE_LIMIT = 30.0;
        final double PAGKALIPI_WRITTEN_TWO_LIMIT = 20.0;
        final double PAGKALIPI_PERFORMANCE_LIMIT = 50.0;
        final double PAGKALIPI_QUARTERLY_ASSESSMENT_LIMIT = 50.0;
        
        final double PAGKALIPI_WRITTEN_HIGHEST_POSSIBLE_SCORE = PAGKALIPI_WRITTEN_ONE_LIMIT + PAGKALIPI_WRITTEN_TWO_LIMIT;
        final double PAGKALIPI_PERFORMANCE_HIGHEST_POSSIBLE_SCORE = PAGKALIPI_PERFORMANCE_LIMIT;
        final double PAGKALIPI_QUARTERLY_HIGHEST_POSSIBLE_SCORE = PAGKALIPI_QUARTERLY_ASSESSMENT_LIMIT;
        
        System.out.println("----------------------------------------------------------------");
        System.out.println("                            PAGKALIPI                           ");
        System.out.println("");
        System.out.println("Input first written task score (_/" + PAGKALIPI_WRITTEN_ONE_LIMIT + "): ");
        double pagkalipiWritten1 = input.nextDouble();
        while (pagkalipiWritten1 < MIN_SCORE || pagkalipiWritten1 > PAGKALIPI_WRITTEN_ONE_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + PAGKALIPI_WRITTEN_ONE_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            pagkalipiWritten1 = input.nextDouble();
            System.out.println("");
        }
        System.out.println("Input second written task score (_/" + PAGKALIPI_WRITTEN_TWO_LIMIT + "): ");
        double pagkalipiWritten2 = input.nextDouble();
        while (pagkalipiWritten2 < MIN_SCORE || pagkalipiWritten2 > PAGKALIPI_WRITTEN_TWO_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + PAGKALIPI_WRITTEN_TWO_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            pagkalipiWritten2 = input.nextDouble();
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Input performance task score (_/" + PAGKALIPI_PERFORMANCE_LIMIT + "): ");
        double pagkalipiPerformance = input.nextDouble();
        while (pagkalipiPerformance < MIN_SCORE || pagkalipiPerformance > PAGKALIPI_PERFORMANCE_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + PAGKALIPI_PERFORMANCE_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            pagkalipiPerformance = input.nextDouble();
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Input quarterly exam score (_/" + PAGKALIPI_QUARTERLY_ASSESSMENT_LIMIT + "): ");
        double pagkalipiExam = input.nextDouble();
        while (pagkalipiExam < MIN_SCORE || pagkalipiExam > PAGKALIPI_QUARTERLY_ASSESSMENT_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + PAGKALIPI_QUARTERLY_ASSESSMENT_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            pagkalipiExam = input.nextDouble();
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
        
        double pagkalipiWrittenPercentageScore = ((pagkalipiWritten1 + pagkalipiWritten2) / PAGKALIPI_WRITTEN_HIGHEST_POSSIBLE_SCORE) * 100.0;
        double pagkalipiPerformancePercentageScore = (pagkalipiPerformance / PAGKALIPI_PERFORMANCE_HIGHEST_POSSIBLE_SCORE) * 100.0;
        double pagkalipiQuarterlyPercentageScore = (pagkalipiExam / PAGKALIPI_QUARTERLY_HIGHEST_POSSIBLE_SCORE) * 100.0;
        
        double pagkalipiWrittenWeightedScore = pagkalipiWrittenPercentageScore * CORE_WRITTEN_WEIGHT;
        double pagkalipiPerformanceWeightedScore = pagkalipiPerformancePercentageScore * CORE_PERFORMANCE_WEIGHT;
        double pagkalipiQuarterlyWeightedScore = pagkalipiQuarterlyPercentageScore * CORE_QUARTERLY_ASSESSMENT_WEIGHT;
        
        double pagkalipiAverage = pagkalipiWrittenWeightedScore + pagkalipiPerformanceWeightedScore + pagkalipiQuarterlyWeightedScore;
        
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
        System.out.println("The subject average is: " + String.format("%.2f", pagkalipiAverage));
        System.out.println("");
        System.out.println("");

        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        // Comprog section
        final double COMPROG_WRITTEN_ONE_LIMIT = 25.0;
        final double COMPROG_WRITTEN_TWO_LIMIT = 25.0;
        final double COMPROG_PERFORMANCE_LIMIT = 100.0;
        final double COMPROG_QUARTERLY_ASSESSMENT_LIMIT = 50.0;
        
        final double COMPROG_WRITTEN_HIGHEST_POSSIBLE_SCORE = COMPROG_WRITTEN_ONE_LIMIT + COMPROG_WRITTEN_TWO_LIMIT;
        final double COMPROG_PERFORMANCE_HIGHEST_POSSIBLE_SCORE = COMPROG_PERFORMANCE_LIMIT;
        final double COMPROG_QUARTERLY_HIGHEST_POSSIBLE_SCORE = COMPROG_QUARTERLY_ASSESSMENT_LIMIT;
        
        System.out.println("----------------------------------------------------------------");
        System.out.println("                            COMPROG                             ");
        System.out.println("");
        System.out.println("Input first written task score (_/" + COMPROG_WRITTEN_ONE_LIMIT + "): ");
        double comprogWritten1 = input.nextDouble();
        while (comprogWritten1 < MIN_SCORE || comprogWritten1 > COMPROG_WRITTEN_ONE_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + COMPROG_WRITTEN_ONE_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            comprogWritten1 = input.nextDouble();
            System.out.println("");
        }
        System.out.println("Input second written task score (_/" + COMPROG_WRITTEN_TWO_LIMIT + "): ");
        double comprogWritten2 = input.nextDouble();
        while (comprogWritten2 < MIN_SCORE || comprogWritten2 > COMPROG_WRITTEN_TWO_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + COMPROG_WRITTEN_TWO_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            comprogWritten2 = input.nextDouble();
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Input performance task score (_/" + COMPROG_PERFORMANCE_LIMIT + "): ");
        double comprogPerformance = input.nextDouble();
        while (comprogPerformance < MIN_SCORE || comprogPerformance > COMPROG_PERFORMANCE_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + COMPROG_PERFORMANCE_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            comprogPerformance = input.nextDouble();
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Input quarterly exam score (_/" + COMPROG_QUARTERLY_ASSESSMENT_LIMIT + "): ");
        double comprogExam = input.nextDouble();
        while (comprogExam < MIN_SCORE || comprogExam > COMPROG_QUARTERLY_ASSESSMENT_LIMIT) {
            System.out.println("Score is invalid as it must be between " + MIN_SCORE + " and " + COMPROG_QUARTERLY_ASSESSMENT_LIMIT);
            System.out.print("Recheck the score and input it again: ");
            comprogExam = input.nextDouble();
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
        
        double comprogWrittenPercentageScore = ((comprogWritten1 + comprogWritten2) / COMPROG_WRITTEN_HIGHEST_POSSIBLE_SCORE) * 100.0;
        double comprogPerformancePercentageScore = (comprogPerformance / COMPROG_PERFORMANCE_HIGHEST_POSSIBLE_SCORE) * 100.0;
        double comprogQuarterlyPercentageScore = (comprogExam / COMPROG_QUARTERLY_HIGHEST_POSSIBLE_SCORE) * 100.0;
        
        double comprogWrittenWeightedScore = comprogWrittenPercentageScore * CORE_WRITTEN_WEIGHT;
        double comprogPerformanceWeightedScore = comprogPerformancePercentageScore * CORE_PERFORMANCE_WEIGHT;
        double comprogQuarterlyWeightedScore = comprogQuarterlyPercentageScore * CORE_QUARTERLY_ASSESSMENT_WEIGHT;
        
        double comprogAverage = comprogWrittenWeightedScore + comprogPerformanceWeightedScore + comprogQuarterlyWeightedScore;
        
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
        System.out.println("The subject average is: " + String.format("%.2f", comprogAverage));
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
        System.out.println("Mathematics Average : " + String.format("%.2f", mathAverage));
        System.out.println("Science Average     : " + String.format("%.2f", scienceAverage));
        System.out.println("English Average     : " + String.format("%.2f", englishAverage));
        System.out.println("Filipino Average    : " + String.format("%.2f", filipinoAverage));
        System.out.println("PagKaLiPi Average   : " + String.format("%.2f", pagkalipiAverage));
        System.out.println("ComProg Average     : " + String.format("%.2f", comprogAverage));
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
        System.out.println(learner + " has a General Average of " + String.format("%.2f", generalAverage));
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
        System.out.println("Mathematics Average : " + String.format("%.2f", mathAverage));
        System.out.println("Science Average     : " + String.format("%.2f", scienceAverage));
        System.out.println("English Average     : " + String.format("%.2f", englishAverage));
        System.out.println("Filipino Average    : " + String.format("%.2f", filipinoAverage));
        System.out.println("PagKaLiPi Average   : " + String.format("%.2f", pagkalipiAverage));
        System.out.println("ComProg Average     : " + String.format("%.2f", comprogAverage));
        System.out.println("");
        System.out.println("General Average: " + String.format("%.2f", generalAverage));
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