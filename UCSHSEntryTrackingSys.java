import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UCSHSEntryTrackingSys {
    public static void main(String[] args) {
        Scanner entrant = new Scanner(System.in);
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");

        // Beginning of Program Section. Loading Segment.
        System.out.print("THE PROGRAM IS LOADING. PLEASE WAIT.\n");

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

        System.out.print("\t\tProgram loaded. Rendering objects");
        for (int i = 0; i < 4; i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // PRIMARY OPTION SECTION
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.print("\n\n\t\t\tUC STUDENT ENTRY TRACKING SYSTEM\n\n");
            System.out.print("\n\t [1] Student Entry (Time In)");
            System.out.print("\n\t [2] Student Exit  (Time Out)");
            System.out.print("\n\t [3] View Entry Log");
            System.out.print("\n\t [4] Terminate System");
            System.out.print("\n\t Select an option (1-4): ");

            String chosenOption = entrant.nextLine().trim();

            if (chosenOption.equals("1")) {
                if (studentCount >= MAX_STUDENTS) {
                    System.out.println("\n[!] Storage capacity full. Cannot register more students.");
                    continue;
                }

                /*
                    If students logged has not exceeded 500, continue registration of new entries.
                */
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("\t\t STUDENT TIME IN REGISTRATION \n");
                
                // STUDENT NAME SECTION
                String studentName;
                while (true) {
                    System.out.print("Enter Full Name: ");
                    studentName = entrant.nextLine().trim();
                    if (studentName.matches("^[a-zA-Z\\s]+$")) { // Name character check.
                        break;
                    }
                    System.out.println("Invalid name. Alphabetical characters and spaces only.\n");
                }

                // STUDENT ID SECTION
                String studentID;
                while (true) {
                    System.out.print("Enter ID Number: ");
                    studentID = entrant.nextLine().trim();

                    if (studentID.matches("^[0-9-]+$")) { // Student ID value check.
                        boolean alreadyActive = false;
                        for (int i = 0; i < studentCount; i++) {
                            if (studentIDs[i] != null && studentIDs[i].equalsIgnoreCase(studentID) && timeOuts[i] == null) { // Assign entry to the ID number.
                                alreadyActive = true;
                                break;
                            }
                        }
                        if (alreadyActive) { // if the ID number has been previously registered for Time-in, invalidate application for time-in.
                            System.out.println("Student ID " + studentID + " is already timed in and has not timed out yet.\n");
                            continue;
                        }
                        break;
                    }
                    System.out.println("Invalid ID format. Only numbers and hyphens are allowed.\n");
                }

                // GRADE LEVEL SECTION
                int grade = 0;
                while (true) {
                    System.out.print("Enter Grade Level (" + SHS_GRADE_11 + " or " + SHS_GRADE_12 + "): ");
                    if (entrant.hasNextInt()) {
                        grade = entrant.nextInt();
                        if (grade == SHS_GRADE_11 || grade == SHS_GRADE_12) { // 
                            entrant.nextLine();
                            break;
                        }
                    } else {
                        entrant.next();
                    }
                    System.out.print("Invalid grade. Only grades 11 and 12 are permitted.\n");
                }

                // STUDENT STRAND SECTION
                System.out.print("Enter Strand (STEM, HUMSS, ABM, TVL-ICT-SCPTech, TVL-ICT-CADTech, TVL): ");
                String strand = entrant.nextLine().trim();

                String block = "N/A";
                if (grade == SHS_GRADE_11 && strand.equalsIgnoreCase("TVL-ICT-SCPTech")) { // Due to varying schedules, requires specification whether student is a part of SCPT-A or SCPT-B
                    while (true) {
                        System.out.print("Enter Block (A or B): ");
                        block = entrant.nextLine().trim().toUpperCase();
                        if (block.equals("A") || block.equals("B")) {
                            break;
                        }
                        System.out.println("Invalid block. Choose 'A' or 'B'.");
                    }
                }
                
                // System Local Date & Time value retrieval
                LocalDateTime now = LocalDateTime.now();
                LocalTime currentTime = now.toLocalTime();
                DayOfWeek currentDay = now.getDayOfWeek();
                String timestamp = now.format(timeFormat);
                
                // Grade 11 standard scheduled time
                LocalTime classStartTime = (grade == SHS_GRADE_11) ? LocalTime.of(7, 30) : LocalTime.of(12, 30);
                boolean hasClassToday = checkClassSchedule(grade, strand, block, currentDay);

                // If a student entered, STUDENT ENTRY CHECK SECTION
                String entryStatus;
                if (!hasClassToday) {
                    entryStatus = "NO CLASS TODAY";
                    System.out.println("\n[i] Notice: No scheduled classes today (" + currentDay + ") for " + strand + ".");
                } else {
                    if (currentTime.isAfter(classStartTime)) { // exceeded time of LocalTime.of(7, 30)
                        entryStatus = "LATE";
                        System.out.println("\n[!] MARKED: LATE (Class starts at " + classStartTime + ")");
                    } else { // the student entered on or before 7:30 (LocalTime.of(7, 30))
                        entryStatus = "ON TIME";
                        System.out.println("\n[✓] Student is ON TIME.");
                    }
                }

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
                System.out.println("    Entry logged at: " + timestamp);
                /*
                    The student has been recorded and has been assigned to it designated container block. A new instance of containers are generated to accomodate a new student while keeping previous students who haven't timed out as open containers accepting only a Time Out option.
                */
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.print("\033[H\033[2J");
                System.out.flush();

                
            // TIME OUT SECTION
            } else if (chosenOption.equals("2")) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print("\t\tSTUDENT TIME OUT VERIFICATION\n");

                if (studentCount == 0) { // Student Presence Validation Check. 
                /*
                    If no student has entered the class premises, return to PRIMARY OPTIONS MENU
                */
                    System.out.print("No active student records found in the system.");
                    continue;
                }
                /*
                    If there are students recorded in the system, proceed to inputting studentID & studentName (not necessarily case sensitive) to check if data is available then retrieve if present.
                */
                System.out.print("Enter Student ID or Full / Partial Name: ");
                String query = entrant.nextLine().trim().toLowerCase();

                
                int matchedIndex = -1;
                for (int i = 0; i < studentCount; i++) {
                    boolean idMatch = studentIDs[i] != null && studentIDs[i].equalsIgnoreCase(query);
                    boolean nameMatch = studentNames[i] != null && studentNames[i].toLowerCase().contains(query);

                    if ((idMatch || nameMatch) && timeOuts[i] == null) {
                        matchedIndex = i;
                        break;
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
                        System.out.print("\n[i] Time Out Recorded: Student had no scheduled classes today.");
                    } else if (currentTime.isBefore(dismissalTime)) {
                        exitStatus = "WARNING: EARLY TIMEOUT";
                        System.out.print("\n[!] WARNING: Student timed out BEFORE class dismissal (" + dismissalTime + ")!");
                    } else {
                        exitStatus = "VALID EXIT";
                        System.out.print("\n[✓] VALID EXIT: Timed out after scheduled dismissal.");
                    }
                    
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.print("\033[H\033[2J");
                    System.out.flush();


                    timeOuts[matchedIndex] = timestamp;
                    exitStatuses[matchedIndex] = exitStatus;

                    System.out.print("    Student Name : " + studentNames[matchedIndex]);
                    System.out.print("    ID Number    : " + studentIDs[matchedIndex]);
                    System.out.print("    Time Out     : " + timestamp);
                    System.out.print("    Status       : " + exitStatus);
                } else {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    
                    System.out.print("\n[!] No active student entry matching \"" + query + "\" was found.\n");
                    System.out.print("    (The student may have already timed out or was not registered).");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
            
            // ENTRY LOG SECTION
            } else if (chosenOption.equals("3")) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("=============================================================================================================================================");
                System.out.printf("%-3s | %-18s | %-11s | %-5s | %-16s | %-5s | %-11s | %-22s | %-22s\n",
                        "#", "Name", "ID", "Grade", "Strand", "Block", "Entry Status", "Time In", "Time Out / Exit Status");
                System.out.println("=============================================================================================================================================");

                if (studentCount == 0) {
                    System.out.println("No records logged yet.");
                } else {
                    for (int i = 0; i < studentCount; i++) {
                        String outDisplay = (timeOuts[i] == null)
                                ? "STILL IN CAMPUS"
                                : timeOuts[i] + " (" + exitStatuses[i] + ")";

                        System.out.printf("%-3d | %-18s | %-11s | %-5d | %-16s | %-5s | %-11s | %-22s | %-22s\n",
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
                System.out.println("=============================================================================================================================================");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.print("\033[H\033[2J");
                System.out.flush();

            } else if (chosenOption.equals("4")) {
                System.out.println("\nTerminating UC Student Entry Tracking System. Goodbye!");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.print("\033[H\033[2J");
                System.out.flush();
                break;

            } else {
                System.out.println("\n[!] Invalid selection. Please choose an option from 1 to 4.");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        }
        entrant.close();
    }

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
