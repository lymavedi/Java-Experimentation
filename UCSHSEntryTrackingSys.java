import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UCSHSEntryTrackingSys {

    // General Screen Clearing
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pressEnterToContinue(Scanner entrant) {
        System.out.print("\nPress [ENTER] to continue...");
        entrant.nextLine();
    }

    public static void main(String[] args) {
        Scanner entrant = new Scanner(System.in);
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");

        // Beginning of Program Section. Loading Segment.
        System.out.print("THE PROGRAM IS LOADING. PLEASE WAIT.\n");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        clearScreen();
        System.out.print("Loading");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }

        clearScreen();

        // Initialization of Containers.
        final int MAX_STUDENTS = 500;
        String[] studentNames = new String[MAX_STUDENTS];
        String[] studentIDs = new String[MAX_STUDENTS];
        String[] strands = new String[MAX_STUDENTS];
        String[] blocks = new String[MAX_STUDENTS];
        String[] timeIns = new String[MAX_STUDENTS];
        String[] timeOuts = new String[MAX_STUDENTS];
        String[] entryStatuses = new String[MAX_STUDENTS];
        String[] exitStatuses = new String[MAX_STUDENTS];

        int[] gradeLevels = new int[MAX_STUDENTS];
        int studentCount = 0;

        // Grade Level Constant
        final int SHS_GRADE_11 = 11;
        final int SHS_GRADE_12 = 12;

        // Valid strands recognized by the school curriculum
        final String[] VALID_STRANDS = {
            "STEM", "HUMSS", "ABM", "TVL-ICT-SCPTECH", "TVL-ICT-CADTECH", "TVL"
        };

        System.out.print("\t\tProgram loaded. Initializing tracking objects");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        clearScreen();

        // PRIMARY OPTION SECTION
        while (true) {
            clearScreen();
            System.out.print("\n\n\t\t\tUC STUDENT ENTRY TRACKING SYSTEM\n\n");
            System.out.print("\n\t [1] Student Entry (Time In)");
            System.out.print("\n\t [2] Student Exit  (Time Out)");
            System.out.print("\n\t [3] View Entry Log");
            System.out.print("\n\t [4] Terminate System");
            System.out.print("\n\n\t Select an option (1-4): ");

            String chosenOption = entrant.nextLine().trim();

            // STUDENT ENTRY SECTION
            if (chosenOption.equals("1")) {
                if (studentCount >= MAX_STUDENTS) {
                    System.out.println("\n[!] Storage capacity full. Cannot register more students.");
                    pressEnterToContinue(entrant);
                    continue;
                }

                clearScreen();
                System.out.println("\t\t STUDENT TIME IN REGISTRATION \n");

                // STUDENT NAME SECTION
                String studentName;
                while (true) {
                    System.out.print("Enter Full Name: ");
                    studentName = entrant.nextLine().trim();
                    if (studentName.matches("^[a-zA-Z\\s.\\-'\u00C0-\u017F]+$") && !studentName.isEmpty()) {
                        break;
                    }
                    System.out.println("Invalid name. Please enter letters, spaces, hyphens, or periods only.\n");
                }

                // STUDENT ID SECTION
                String studentID;
                while (true) {
                    System.out.print("Enter ID Number: ");
                    studentID = entrant.nextLine().trim();

                    if (studentID.matches("^[0-9-]+$") && !studentID.isEmpty()) {
                        boolean alreadyActive = false;
                        for (int i = 0; i < studentCount; i++) {
                            // Verify student is not already timed in without an exit timestamp
                            if (studentIDs[i] != null && studentIDs[i].equalsIgnoreCase(studentID) && timeOuts[i] == null) {
                                alreadyActive = true;
                                break;
                            }
                        }
                        if (alreadyActive) {
                            System.out.println("[!] Student ID " + studentID + " is already timed in and has not timed out yet.\n");
                            break;
                        }
                        break;
                    }
                    System.out.println("Invalid ID format. Only numbers and hyphens are allowed.\n");
                }

                // DUPLICATE ID SEARCH SECTION
                boolean isDuplicateActive = false;
                for (int i = 0; i < studentCount; i++) {
                    if (studentIDs[i] != null && studentIDs[i].equalsIgnoreCase(studentID) && timeOuts[i] == null) {
                        isDuplicateActive = true;
                        break;
                    }
                }
                if (isDuplicateActive) {
                    pressEnterToContinue(entrant);
                    continue;
                }

                // GRADE LEVEL SECTION
                int grade = 0;
                while (true) {
                    System.out.print("Enter Grade Level (" + SHS_GRADE_11 + " or " + SHS_GRADE_12 + "): ");
                    String gradeInput = entrant.nextLine().trim();
                    try {
                        grade = Integer.parseInt(gradeInput);
                        if (grade == SHS_GRADE_11 || grade == SHS_GRADE_12) {
                            break;
                        }
                    } catch (NumberFormatException ignored) {
                    }
                    System.out.println("Invalid grade. Only grades 11 and 12 are permitted.\n");
                }

                // STUDENT STRAND SECTION
                String strand = "";
                while (true) {
                    System.out.print("Enter Strand (STEM, HUMSS, ABM, TVL-ICT-SCPTech, TVL-ICT-CADTech, TVL): ");
                    strand = entrant.nextLine().trim();
                    boolean isValidStrand = false;
                    for (String s : VALID_STRANDS) {
                        if (s.equalsIgnoreCase(strand)) {
                            isValidStrand = true;
                            strand = s; //
                            break;
                        }
                    }
                    if (isValidStrand) {
                        break;
                    }
                    System.out.println("Invalid strand. Please select one of the offered senior high strands.\n");
                }

                // BLOCK SECTION (TVL-ICT-SCPTech Grade 11 only)
                String block = "N/A";
                if (grade == SHS_GRADE_11 && strand.equalsIgnoreCase("TVL-ICT-SCPTech")) {
                    while (true) {
                        System.out.print("Enter Block (A or B): ");
                        block = entrant.nextLine().trim().toUpperCase();
                        if (block.equals("A") || block.equals("B")) {
                            break;
                        }
                        System.out.println("Invalid block. Choose 'A' or 'B'.\n");
                    }
                }

                // System Local Date & Time value retrieval
                LocalDateTime now = LocalDateTime.now();
                LocalTime currentTime = now.toLocalTime();
                DayOfWeek currentDay = now.getDayOfWeek();
                String timestamp = now.format(timeFormat);

                // General Scheduled start time
                LocalTime classStartTime = (grade == SHS_GRADE_11) ? LocalTime.of(7, 30) : LocalTime.of(12, 30);
                boolean hasClassToday = checkClassSchedule(grade, strand, block, currentDay);

                // STUDENT ENTRY CHECK SECTION
                String entryStatus;
                if (!hasClassToday) {
                    entryStatus = "NO CLASS TODAY";
                    System.out.println("\n[i] Notice: No scheduled classes today (" + currentDay + ") for " + strand + ".");
                } else {
                    if (currentTime.isAfter(classStartTime)) {
                        entryStatus = "LATE";
                        System.out.println("\n[!] MARKED: LATE (Class started at " + classStartTime + ")");
                    } else {
                        entryStatus = "ON TIME";
                        System.out.println("\n[✓] Student is ON TIME.");
                    }
                }

                // DATA STORAGE CONTAINERS
                studentNames[studentCount] = studentName;
                studentIDs[studentCount] = studentID;
                gradeLevels[studentCount] = grade;
                strands[studentCount] = strand;
                blocks[studentCount] = block;
                timeIns[studentCount] = timestamp;
                timeOuts[studentCount] = null;
                entryStatuses[studentCount] = entryStatus;
                exitStatuses[studentCount] = "PENDING";
                studentCount++;

                System.out.println("    Entry logged at: " + timestamp);
                pressEnterToContinue(entrant);

            // STUDENT EXIT SECTION
            } else if (chosenOption.equals("2")) {
                clearScreen();
                System.out.print("\t\tSTUDENT TIME OUT VERIFICATION\n\n");

                if (studentCount == 0) {
                    System.out.println("No active student records found in the system.");
                    pressEnterToContinue(entrant);
                    continue;
                }

                System.out.print("Enter Student ID or Full / Partial Name: ");
                String query = entrant.nextLine().trim().toLowerCase();

                // DISAMBIGUATION VALIDATION SEARCH.
                /*
                    A section dedicated to clarifying possible similarities in names.
                */
                int[] matchingIndices = new int[studentCount];
                int matchCount = 0;

                for (int i = 0; i < studentCount; i++) {
                    if (timeOuts[i] == null) {
                        boolean idMatch = studentIDs[i] != null && studentIDs[i].toLowerCase().equals(query);
                        boolean nameMatch = studentNames[i] != null && studentNames[i].toLowerCase().contains(query);

                        if (idMatch || nameMatch) {
                            matchingIndices[matchCount] = i;
                            matchCount++;
                        }
                    }
                }

                int matchedIndex = -1;
                if (matchCount == 1) {
                    matchedIndex = matchingIndices[0];
                } else if (matchCount > 1) {
                    System.out.println("\nMultiple active entries matched \"" + query + "\":");
                    for (int m = 0; m < matchCount; m++) {
                        int idx = matchingIndices[m];
                        System.out.printf("  [%d] %s (ID: %s, Strand: %s, Time In: %s)\n",
                                (m + 1), studentNames[idx], studentIDs[idx], strands[idx], timeIns[idx]);
                    }
                    while (true) {
                        System.out.print("Select student number (1-" + matchCount + ") or '0' to cancel: ");
                        String selInput = entrant.nextLine().trim();
                        try {
                            int selection = Integer.parseInt(selInput);
                            if (selection == 0) {
                                break;
                            } else if (selection >= 1 && selection <= matchCount) {
                                matchedIndex = matchingIndices[selection - 1];
                                break;
                            }
                        } catch (NumberFormatException ignored) {}
                        System.out.println("Invalid selection.");
                    }
                }

                if (matchedIndex != -1) {
                    LocalDateTime now = LocalDateTime.now();
                    LocalTime currentTime = now.toLocalTime();
                    DayOfWeek currentDay = now.getDayOfWeek();
                    String timestamp = now.format(timeFormat);

                    int grade = gradeLevels[matchedIndex];
                    String strand = strands[matchedIndex];
                    String block = blocks[matchedIndex];

                    LocalTime dismissalTime = (grade == SHS_GRADE_11) ? LocalTime.of(12, 30) : LocalTime.of(17, 30);
                    boolean hasClassToday = checkClassSchedule(grade, strand, block, currentDay);

                    String exitStatus;
                    if (!hasClassToday) {
                        exitStatus = "NO CLASS EXIT";
                        System.out.println("\n[i] Time Out Recorded: Student had no scheduled classes today.");
                    } else if (currentTime.isBefore(dismissalTime)) {
                        exitStatus = "WARNING: EARLY TIMEOUT";
                        System.out.println("\n[!] WARNING: Student timed out BEFORE class dismissal (" + dismissalTime + ")!");
                    } else {
                        exitStatus = "VALID EXIT";
                        System.out.println("\n[✓] VALID EXIT: Timed out after scheduled dismissal.");
                    }

                    timeOuts[matchedIndex] = timestamp;
                    exitStatuses[matchedIndex] = exitStatus;

                    System.out.println("\n    Student Name : " + studentNames[matchedIndex]);
                    System.out.println("    ID Number    : " + studentIDs[matchedIndex]);
                    System.out.println("    Time Out     : " + timestamp);
                    System.out.println("    Status       : " + exitStatus);

                } else if (matchCount == 0) {
                    System.out.println("\n[!] No active student entry matching \"" + query + "\" was found.");
                    System.out.println("    (The student may have already timed out or was not registered).");
                }

                pressEnterToContinue(entrant);

            // ENTRY LOG SECTION
            } else if (chosenOption.equals("3")) {
                clearScreen();
                System.out.println("========================================================================================================================================================");
                System.out.printf("%-3s | %-20s | %-12s | %-5s | %-18s | %-5s | %-14s | %-23s | %-25s\n",
                        "#", "Name", "ID", "Grade", "Strand", "Block", "Entry Status", "Time In", "Time Out / Exit Status");
                System.out.println("========================================================================================================================================================");

                if (studentCount == 0) {
                    System.out.println("No records logged yet.");
                } else {
                    for (int i = 0; i < studentCount; i++) {
                        String outDisplay = (timeOuts[i] == null)
                                ? "STILL IN CAMPUS"
                                : timeOuts[i] + " (" + exitStatuses[i] + ")";

                        System.out.printf("%-3d | %-20s | %-12s | %-5d | %-18s | %-5s | %-14s | %-23s | %-25s\n",
                                (i + 1),
                                studentNames[i],
                                studentIDs[i],
                                gradeLevels[i],
                                strands[i],
                                blocks[i],
                                entryStatuses[i],
                                timeIns[i],
                                outDisplay);
                    }
                }
                System.out.println("========================================================================================================================================================");
                pressEnterToContinue(entrant);

            // TERMINATE SYSTEM SECTION
            } else if (chosenOption.equals("4")) {
                System.out.println("\nTerminating UC Student Entry Tracking System. Goodbye!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                clearScreen();
                break;

            } else {
                System.out.println("\n[!] Invalid selection. Please choose an option from 1 to 4.");
                pressEnterToContinue(entrant);
            }
        }
        entrant.close();
    }

    // SCHEDULE VALIDATION SECTION (called upon by previous parts)
    public static boolean checkClassSchedule(int grade, String strand, String block, DayOfWeek day) {
        if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
            return false;
        }

        if (day == DayOfWeek.FRIDAY) {
            return true;
        }

        if (strand.equalsIgnoreCase("STEM")) {
            return day == DayOfWeek.MONDAY || day == DayOfWeek.TUESDAY;
        }

        if (strand.equalsIgnoreCase("HUMSS") || strand.equalsIgnoreCase("ABM")) {
            return day == DayOfWeek.TUESDAY || day == DayOfWeek.THURSDAY;
        }

        if (grade == 11 && strand.equalsIgnoreCase("TVL-ICT-SCPTech")) {
            if (block.equalsIgnoreCase("A")) {
                return day == DayOfWeek.MONDAY || day == DayOfWeek.WEDNESDAY || day == DayOfWeek.THURSDAY;
            } else if (block.equalsIgnoreCase("B")) {
                return day == DayOfWeek.TUESDAY || day == DayOfWeek.WEDNESDAY || day == DayOfWeek.THURSDAY;
            }
        }

        if (strand.equalsIgnoreCase("TVL-ICT-CADTech")) {
            return day == DayOfWeek.WEDNESDAY || day == DayOfWeek.THURSDAY;
        }

        if (strand.toUpperCase().startsWith("TVL")) {
            return true;
        }
        return false;
    }
}