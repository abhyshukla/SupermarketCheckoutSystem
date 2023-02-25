package driver;

import checkoutSystem.CheckOut;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DriverClass {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        Map<String, Map<String, Integer>> pricingRules = new HashMap<>();
        pricingRules.put("A", new HashMap<>() {{
            put("unitPrice", 50);
            put("specialPrice", 130);
            put("specialQuantity", 3);
        }});
        pricingRules.put("B", new HashMap<>() {{
            put("unitPrice", 30);
            put("specialPrice", 45);
            put("specialQuantity", 2);
        }});
        pricingRules.put("C", new HashMap<>() {{
            put("unitPrice", 20);
        }});
        pricingRules.put("D", new HashMap<>() {{
            put("unitPrice", 15);
        }});

        System.out.println("~~~~~~~~~~~ Doing checkout in static way ~~~~~~~~~~~~~");

        CheckOut checkOut = new CheckOut(pricingRules);
        checkOut.scan("A");
        checkOut.scan("B");
        int price = checkOut.total();
        System.out.println("\nTotal price of the items : " + price);


        checkOut = new CheckOut(pricingRules);
        checkOut.scan("A");
        checkOut.scan("A");
        price = checkOut.total();
        System.out.println("\nTotal price of the items : " + price);


        System.out.println("\n\n ~~~~~~~~~~~ Doing checkout in dynamic way ~~~~~~~~~~~~~");
        System.out.print("Enter the items you want to buy : ");
        String items = sc.nextLine();
        checkOut = new CheckOut(pricingRules);
        System.out.print("\nItems added in the cart : ");
        for( int i = 0; i < items.length(); i++ ) {

            // access each item
            String item = String.valueOf(items.charAt(i));
            if (pricingRules.containsKey(item)) {
                checkOut.scan(item);
                System.out.print( item + ",");
            }
        }
        int totalPrice = checkOut.total();
        System.out.println("Total price of the items : " + totalPrice);

    }
}
