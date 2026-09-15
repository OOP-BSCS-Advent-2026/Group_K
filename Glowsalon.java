public class Glowsalon {

    // works out the price after applying whatever discount applies to that service
    public static double calculateSubtotal(int index, double price, int quantity) {
        double subtotal = price * quantity;

        if (index == 0 && quantity >= 3) {
            // haircut - give 5% off if they're getting 3 or more
            subtotal *= 0.95;
        } else if (index == 2 && quantity >= 2) {
            // manicure - flat 3000 off for 2+
            subtotal -= 3000;
        } else if (index == 3 && quantity >= 2) {
            // braiding - 10% off for 2+
            subtotal *= 0.90;
        }

        return subtotal;
    }

    // Print the receipt
    public static void printReceipt(String[] items, double[] prices, int[] quantities) {

        double grandTotal = 0;

        System.out.println("===== GLOW SALON =====\n");
        System.out.println("PRICE LIST");

        for (int i = 0; i < items.length; i++) {
            System.out.printf("%-12s UGX %.2f%n",
                    items[i],
                    prices[i]);
        }

        System.out.println("\n===== RECEIPT =====");

        for (int i = 0; i < items.length; i++) {

            double subtotal = calculateSubtotal(
                    i,
                    prices[i],
                    quantities[i]);

            grandTotal += subtotal;

            System.out.printf(
                    "%-12s x%d = UGX %.2f%n",
                    items[i],
                    quantities[i],
                    subtotal);
        }

        System.out.println("----------------------------");
        System.out.printf("TOTAL = UGX %.2f%n", grandTotal);

        
    }
    public static void main(String[] args) {
        String[] items = {"Haircut", "Shave", "Manicure", "Braiding"};
        double[] prices = {8000, 5000, 15000, 30000};
        int[] quantities = {2, 2, 1, 2};
    }
    
    public static String getDiscountMessage(int index, int quantity) {
        if (index == 0 && quantity >= 3) return "5% discount applied";
        if (index == 2 && quantity >= 2) return "UGX 3,000 discount applied";
        if (index == 3 && quantity >= 2) return "10% discount applied";
        return "no discount";
    }
}
