public class Temperature { 
    public static void main(String[] args) {
    
    int temperature = 28;
    
    boolean minimumSafe = temperature >= 18;
    boolean maximumSafe = temperature <= 30;
    
    boolean tempSafe = minimumSafe && maximumSafe;
    
    System.out.println("Temperature Safe: " + tempSafe);
    
    }
}

