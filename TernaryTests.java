public class TernaryTests {
    public static void main(String[] args) {
        int age = 20;
        
        String result = age >= 60 ? "Senior" : age >= 18 ? "Adult" : "Minor";
        System.out.printf("The result: " + result + "%n%n");
    }
}
