// ─────────────────────────────────────────────────────────────
// FILE: InventoryManagementSystem.java
// PURPOSE: Real inventory system using ALL four loop types
// Connects: Day 2 (variables) + Day 3 (operators) +
//           Day 4 (control flow) + Day 5 (loops)
// ─────────────────────────────────────────────────────────────

public class InventoryManagementSystem {

    public static void main(String[] args) {

        // ══════════════════════════════════════════════════════
        // INVENTORY DATA — arrays of product information
        // You will learn arrays deeply on Day 7
        // For now understand: array stores multiple values
        // ══════════════════════════════════════════════════════

        String[] productNames  = {
                "Laptop", "Mouse", "Keyboard", "Monitor",
                "Headphones", "Webcam", "USB Hub"
        };

        double[] productPrices = {
                45999.0, 1299.0, 2499.0, 18999.0,
                3499.0, 4999.0, 1899.0
        };

        int[] stockQuantity    = {
                15, 50, 30, 8, 25, 12, 40
        };

        int[] reorderLevel     = {
                5, 20, 10, 3, 10, 5, 15
        };
        // reorderLevel: if stock falls BELOW this → reorder

        final double GST_RATE       = 0.18;
        final double BULK_THRESHOLD = 10;
        final double BULK_DISCOUNT  = 0.05;

        // ══════════════════════════════════════════════════════
        // SECTION 1: FULL INVENTORY REPORT
        // Using enhanced for-each for clean iteration
        // ══════════════════════════════════════════════════════

        System.out.println("╔═════════════════════════════════════════════════╗");
        System.out.println("║            COMPLETE INVENTORY REPORT           ║");
        System.out.println("╠═════════════════════════════════════════════════╣");
        System.out.printf ("║  %-12s %-10s %-8s %-10s ║%n",
                "PRODUCT", "PRICE", "STOCK", "STATUS");
        System.out.println("╠═════════════════════════════════════════════════╣");

        // Use regular for loop here because we need INDEX
        // to access matching elements from multiple arrays
        for (int i = 0; i < productNames.length; i++) {
//                         ────────────────────
//            .length gives total number of elements in array
//            We go from 0 to length-1 (array index starts at 0)

            String status;

            // Control flow from Day 4 inside loop
            if (stockQuantity[i] == 0) {
                status = "OUT OF STOCK";
            } else if (stockQuantity[i] < reorderLevel[i]) {
                status = "LOW STOCK";
            } else {
                status = "AVAILABLE";
            }

            System.out.printf("║  %-12s Rs.%-7.0f %-8d %-10s ║%n",
                    productNames[i],
                    productPrices[i],
                    stockQuantity[i],
                    status);
        }

        System.out.println("╚═════════════════════════════════════════════════╝");

        // ══════════════════════════════════════════════════════
        // SECTION 2: CALCULATE INVENTORY VALUE
        // Using enhanced for-each with running total
        // ══════════════════════════════════════════════════════

        double totalInventoryValue = 0.0;
        int    totalItemsInStock   = 0;
        int    lowStockCount       = 0;

        for (int i = 0; i < productNames.length; i++) {
            double itemValue = productPrices[i] * stockQuantity[i];
            totalInventoryValue += itemValue;
            totalItemsInStock   += stockQuantity[i];

            if (stockQuantity[i] < reorderLevel[i]) {
                lowStockCount++;
            }
        }

        System.out.printf("%nTotal Inventory Value : Rs.%.2f%n",
                totalInventoryValue);
        System.out.printf("Total Items in Stock  : %d%n",
                totalItemsInStock);
        System.out.printf("Low Stock Products    : %d%n%n",
                lowStockCount);

        // ══════════════════════════════════════════════════════
        // SECTION 3: REORDER ALERT SYSTEM
        // Using for-each loop with continue to skip in-stock items
        // ══════════════════════════════════════════════════════

        System.out.println("═══ REORDER ALERT ═══");

        boolean anyReorderNeeded = false;

        for (int i = 0; i < productNames.length; i++) {
            if (stockQuantity[i] >= reorderLevel[i]) {
                continue;
//              ────────
//              skip products that have sufficient stock
//              only products needing reorder reach below code
            }

            anyReorderNeeded = true;
            int orderQty = reorderLevel[i] * 3;
//              order 3x the reorder level as new stock

            System.out.printf("⚠️  REORDER: %-12s | Current: %d | Order: %d%n",
                    productNames[i],
                    stockQuantity[i],
                    orderQty);
        }

        if (!anyReorderNeeded) {
            System.out.println("✅ All products have sufficient stock");
        }

        // ══════════════════════════════════════════════════════
        // SECTION 4: PRODUCT SEARCH SIMULATION
        // Using while loop with break
        // ══════════════════════════════════════════════════════

        System.out.println("\n═══ PRODUCT SEARCH ═══");

        String searchProduct = "Monitor";
        int    foundIndex    = -1;
        int    searchIndex   = 0;

        while (searchIndex < productNames.length) {
//             ─────────────────────────────────
//             keep searching while we have products to check

            if (productNames[searchIndex].equals(searchProduct)) {
//                                       ───────
//                                       .equals() for String comparison
//                                       NEVER use == for Strings
                foundIndex = searchIndex;
                break;
//              ─────
//              found it — no need to keep searching
            }
            searchIndex++;
//          ────────────
//          move to next product
//          this is the UPDATE that prevents infinite loop
        }

        if (foundIndex != -1) {
            System.out.printf("Found: %s%n", searchProduct);
            System.out.printf("Price : Rs.%.2f%n",
                    productPrices[foundIndex]);
            System.out.printf("Stock : %d units%n",
                    stockQuantity[foundIndex]);
        } else {
            System.out.println("Product not found: " + searchProduct);
        }

        // ══════════════════════════════════════════════════════
        // SECTION 5: PURCHASE SIMULATION
        // Using do-while for menu-driven interaction
        // ══════════════════════════════════════════════════════

        System.out.println("\n═══ PURCHASE SIMULATION ═══");

        int[] purchaseQuantities = {2, 5, 1};
//      simulating 3 purchase requests

        int purchaseIndex = 0;

        do {
            if (purchaseIndex >= purchaseQuantities.length) {
                break;
//              exit do-while when all purchases are processed
            }

            int    productIdx = purchaseIndex;
            int    purchaseQty= purchaseQuantities[purchaseIndex];
            String pName      = productNames[productIdx];
            double pPrice     = productPrices[productIdx];
            int    currentQty = stockQuantity[productIdx];

            System.out.printf("%nProcessing purchase: %s x %d%n",
                    pName, purchaseQty);

            if (purchaseQty > currentQty) {
                System.out.printf("❌ Insufficient stock. Available: %d%n",
                        currentQty);
            } else {
                double baseAmount  = pPrice * purchaseQty;
                double discount    = purchaseQty >= BULK_THRESHOLD
                        ? baseAmount * BULK_DISCOUNT : 0.0;
                double afterDisc   = baseAmount - discount;
                double gst         = afterDisc * GST_RATE;
                double finalAmount = afterDisc + gst;

                stockQuantity[productIdx] -= purchaseQty;

                if (discount > 0) {
                    System.out.printf("✅ Bulk discount applied: Rs.%.2f%n",
                            discount);
                }
                System.out.printf("✅ GST (18%%): Rs.%.2f%n", gst);
                System.out.printf("✅ Total paid: Rs.%.2f%n", finalAmount);
                System.out.printf("✅ Remaining stock: %d%n",
                        stockQuantity[productIdx]);
            }

            purchaseIndex++;
//          ─────────────
//          move to next purchase — do-while UPDATE

        } while (purchaseIndex < purchaseQuantities.length);

        // ══════════════════════════════════════════════════════
        // SECTION 6: MULTIPLICATION TABLE using nested for loops
        // ══════════════════════════════════════════════════════

        System.out.println("\n═══ PRICING MULTIPLIER TABLE ═══");
        System.out.print("Units  ");

        for (int qty = 1; qty <= 5; qty++) {
            System.out.printf("x%-8d", qty);
        }
        System.out.println();
        System.out.println("─".repeat(50));

        for (int i = 0; i < 3; i++) {
//          outer loop — each product row
            System.out.printf("%-7s", productNames[i]);

            for (int qty = 1; qty <= 5; qty++) {
//              inner loop — each quantity column
                double rowTotal = productPrices[i] * qty;
                System.out.printf("%-9.0f", rowTotal);
            }
            System.out.println();
        }

        // ══════════════════════════════════════════════════════
        // SECTION 7: FIND MOST EXPENSIVE PRODUCT
        // Using for loop with comparison — classic algorithm
        // ══════════════════════════════════════════════════════

        System.out.println("\n═══ MOST EXPENSIVE PRODUCT ═══");

        double maxPrice     = productPrices[0];
//                                          ↑
//                  start by assuming first product is most expensive
        String maxProduct   = productNames[0];

        for (int i = 1; i < productPrices.length; i++) {
//                 ↑
//          start from index 1 because index 0 is our initial max
            if (productPrices[i] > maxPrice) {
                maxPrice   = productPrices[i];
                maxProduct = productNames[i];
//              ──────────────────────────────
//              update max whenever we find something larger
            }
        }

        System.out.printf("Most expensive: %s at Rs.%.2f%n",
                maxProduct, maxPrice);
    }
}