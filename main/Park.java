package main;
import java.util.*;

public class Park {

    public static Map<String, Integer> record = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                    Welcome to Park+. You can trust us!                      |");
        System.out.println("|    A place for all your parking needs. You trust us, we have got your back. |");
        System.out.println("|                   A unit of Emperor's AirLine Pvt. Ltd                      |");
        System.out.println("-------------------------------------------------------------------------------");
        
        //adding few customers to map
        record.put("KA32M5964", 11);
        record.put("AP28AD9804", 13);
        record.put("JH24AL8448", 42);
        record.put("AP08D5449", 52);
        record.put("AP28CK9026", 7);
        record.put("TN09N0009", 1);
        record.put("PY01N5935", 17);
        record.put("TS08JP1997", 19);
        
        //showing the facilities provided
        System.out.println("\n\n Services provided: \n1. New car P+ registration \n2. Add money to wallet(Existing Customers) \n3. Check my parking spot(Existing Customers) \n4. OTP for visitors");
        Scanner s0 = new Scanner(System.in);
        int choice = s0.nextInt();
        switch (choice) {
            case 1:
                register();
                break;
            case 2:
                money();
                break;
            case 3:
                spot();
                break;
            case 4:
                String otp = generateOTP();
                System.out.println("Generated OTP: " + otp+ " for visitor vehicle ");
                break;
            default:
                break;
        }
    }

    public static void register(){
        System.out.println("\nWelcome to Emperor's AirLine Pvt. Ltd powered Park+");
        System.out.println("\nEnter your vehicles registration number: ");
        Scanner s1 = new Scanner(System.in);
        String rc = s1.nextLine();
        int newSpot = genNewSpot();
        record.put(rc, newSpot);
        System.out.println("\nRegistration successful. \nYour parking spot for your vehicle "+rc.toUpperCase()+" is "+newSpot+ "\n");
        }

    public static int genNewSpot(){
        Random rnd = new Random();
        return rnd.nextInt(99)+1;
    }

    
    public static void money() {
        System.out.println("\n!! This service is only for existing customers !!");
        System.out.println("Welcome customer, please enter your vehicle's registration number: ");
        Scanner s3 = new Scanner(System.in);
        String ve = s3.nextLine().toUpperCase();
        if(record.containsKey(ve)){
            System.out.println("\nYour wallet balance is zero. Enter the amount you want to add: ");
            Scanner s4 = new Scanner(System.in);
            int m1 = s4.nextInt();
            // Update the wallet balance for the existing customer
            record.put(ve, record.get(ve) + m1);
            System.out.println("\nYou have added Rs." + m1 + " to your vehicle's wallet. Thank you!");
        } else {
            System.out.println("Vehicle not found in the records.");
        }
    }

    public static void spot(){
        System.out.println("\nEnter your vehicle's registration details: ");
        Scanner s2 = new Scanner(System.in);
        String sp = s2.nextLine().toUpperCase();
        if(record.containsKey(sp)){
            System.out.println("\nYour parking spot for your vehicle "+sp+ " is " +record.get(sp));
        }
        else{
            System.out.println("\nYour vehicle is not registered with us. Please register yourself first.");
        }
    }

    public static String generateOTP(){
        int otpLength = 4;
        StringBuilder otpBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < otpLength; i++) {
            otpBuilder.append(random.nextInt(10));
        }
        return otpBuilder.toString();
    }
}
