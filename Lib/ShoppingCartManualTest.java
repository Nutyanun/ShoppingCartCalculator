import java.util.ArrayList;

public class ShoppingCartManualTest {

    public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); // 50
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));      // 15
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 65.0 but got " + total3);
            failedCount++;
        }

        // Test 4: คำนวณแบบมีส่วนลด BOGO
        ArrayList<CartItem> discount1Cart = new ArrayList<>();
        discount1Cart.add(new CartItem("BOGO", "Bread", 25.0, 2)); // จ่ายหนึ่ง 25
        discount1Cart.add(new CartItem("BOGO", "Milk", 15.0, 4));      // จ่ายสอง 30
        double total4 = ShoppingCartCalculator.calculateTotalPrice(discount1Cart);
        if (total4 == 55.0) {
            System.out.println("PASSED: Discount1 cart total is correct (55.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Discount1 cart total expected 55.0 but got " + total4);
            failedCount++;
        }

        // Test 5: คำนวณแบบมีส่วนลด BULK
        ArrayList<CartItem> discount2Cart = new ArrayList<>();
        discount2Cart.add(new CartItem("BULK", "Bread", 25.0, 6)); // 150-15 = 135
        discount2Cart.add(new CartItem("BULK", "Milk", 15.0, 8));      // 120-12 = 108
        double total5 = ShoppingCartCalculator.calculateTotalPrice(discount2Cart);
        if (total5 == 243.0) {
            System.out.println("PASSED: Discount2 cart total is correct (243.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Discount2 cart total expected 243.0 but got " + total5);
            failedCount++;
        }

        /*  Test 6: คำนวณแบบมีส่วนลด BOGO และ BULK ในตะกร้าเดียวกัน
        ArrayList<CartItem> totaldiscountCart = new ArrayList<>();
        totaldiscountCart.add(new CartItem("BULK", "Bread", 25.0, 6)); // 150-15 = 135
        totaldiscountCart.add(new CartItem("BULK", "Milk", 15.0, 2));      // 15
        double total6 = ShoppingCartCalculator.calculateTotalPrice(totaldiscountCart);
        if (total6 == 150.0) {
            System.out.println("PASSED: Total Discount cart total is correct (150.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Total Discount cart total expected 243.0 but got " + total6);
            failedCount++;
        } */

        // --- Test Summary ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}