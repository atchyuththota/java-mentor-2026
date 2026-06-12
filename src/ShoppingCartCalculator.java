// ─────────────────────────────────────────────────────────────
// FILE: ShoppingCartCalculator.java
// PURPOSE: Real e-commerce cart using ALL operators
// This connects to Day 2 variables — now we operate on them
// ─────────────────────────────────────────────────────────────

public class ShoppingCartCalculator {

    public static void main(String[] args) {

        // ══════════════════════════════════════════════════════
        // SECTION 1: PRODUCT DATA (Day 2 variables)
        // ══════════════════════════════════════════════════════

        String  product1Name  = "Wireless Headphones";
        double  product1Price = 2499.00;
        int     product1Qty   = 2;

        String  product2Name  = "USB-C Cable";
        double  product2Price = 349.00;
        int     product2Qty   = 3;

        String  product3Name  = "Phone Stand";
        double  product3Price = 199.00;
        int     product3Qty   = 1;

        final double GST_RATE          = 0.18;
        final double PREMIUM_DISCOUNT  = 0.10;
        final double FREE_DELIVERY_MIN = 500.0;
        final double DELIVERY_CHARGE   = 40.0;

        boolean isPremiumMember = true;
        boolean hasCoupon       = false;
        String  couponCode      = "SAVE20";

        // ══════════════════════════════════════════════════════
        // SECTION 2: ARITHMETIC OPERATORS — Calculate totals
        // ══════════════════════════════════════════════════════

        double item1Total = product1Price * product1Qty;
        // 2499.00 * 2 = 4998.00

        double item2Total = product2Price * product2Qty;
        // 349.00 * 3 = 1047.00

        double item3Total = product3Price * product3Qty;
        // 199.00 * 1 = 199.00

        double cartSubtotal = item1Total + item2Total + item3Total;
        // 4998.00 + 1047.00 + 199.00 = 6244.00

        // ══════════════════════════════════════════════════════
        // SECTION 3: COMPARISON + LOGICAL OPERATORS
        // ══════════════════════════════════════════════════════

        boolean isEligibleFreeDelivery = cartSubtotal >= FREE_DELIVERY_MIN;
        // 6244.00 >= 500.0 → true

        boolean isEligibleDiscount = isPremiumMember || hasCoupon;
        // true || false → true (at least one is true)

        boolean isFullBenefits = isPremiumMember && isEligibleFreeDelivery;
        // true && true → true (both must be true)

        // ══════════════════════════════════════════════════════
        // SECTION 4: TERNARY OPERATOR — Delivery and discount
        // ══════════════════════════════════════════════════════

        double deliveryFee = isEligibleFreeDelivery ? 0.0 : DELIVERY_CHARGE;
        // isEligibleFreeDelivery is true → deliveryFee = 0.0

        double discountRate = isPremiumMember ? PREMIUM_DISCOUNT : 0.0;
        // isPremiumMember is true → discountRate = 0.10

        String membershipLabel = isPremiumMember ? "PREMIUM" : "STANDARD";
        // isPremiumMember is true → "PREMIUM"

        String deliveryLabel = isEligibleFreeDelivery
                ? "FREE Delivery"
                : "Rs." + DELIVERY_CHARGE;
        // true → "FREE Delivery"

        // ══════════════════════════════════════════════════════
        // SECTION 5: COMPOUND ASSIGNMENT — Build final total
        // ══════════════════════════════════════════════════════

        double orderTotal = cartSubtotal;

        double discountAmount = orderTotal * discountRate;
        // 6244.00 * 0.10 = 624.40

        orderTotal -= discountAmount;
        // orderTotal = 6244.00 - 624.40 = 5619.60

        double gstAmount = orderTotal * GST_RATE;
        // 5619.60 * 0.18 = 1011.528

        orderTotal += gstAmount;
        // orderTotal = 5619.60 + 1011.528 = 6631.128

        orderTotal += deliveryFee;
        // orderTotal = 6631.128 + 0.0 = 6631.128

        // ══════════════════════════════════════════════════════
        // SECTION 6: MODULUS — Useful calculations
        // ══════════════════════════════════════════════════════

        int totalItems = product1Qty + product2Qty + product3Qty;
        // 2 + 3 + 1 = 6

        boolean isEvenItemCount = (totalItems % 2 == 0);
        // 6 % 2 = 0, 0 == 0 → true (even number of items)

        int itemsPerPage = 2;
        int totalPages   = totalItems / itemsPerPage;
        // 6 / 2 = 3 pages

        int remainingItems = totalItems % itemsPerPage;
        // 6 % 2 = 0 (no remaining items on last page)

        // ══════════════════════════════════════════════════════
        // SECTION 7: BITWISE — Order status flags
        // ══════════════════════════════════════════════════════

        int PAYMENT_CONFIRMED = 1;   // binary: 001
        int STOCK_AVAILABLE   = 2;   // binary: 010
        int ADDRESS_VERIFIED  = 4;   // binary: 100

        int orderStatus = PAYMENT_CONFIRMED | STOCK_AVAILABLE
                | ADDRESS_VERIFIED;
        // 001 | 010 | 100 = 111 = 7 (all flags set)

        boolean readyToShip =
                ((orderStatus & PAYMENT_CONFIRMED) != 0) &&
                        ((orderStatus & STOCK_AVAILABLE)   != 0) &&
                        ((orderStatus & ADDRESS_VERIFIED)  != 0);
        // All three flags are set → true

        // ══════════════════════════════════════════════════════
        // SECTION 8: TYPE CASTING — Display values
        // ══════════════════════════════════════════════════════

        int displayTotal    = (int) orderTotal;
        // 6631.128 → 6631 (decimal dropped, not rounded)

        int savingsInt      = (int) discountAmount;
        // 624.40 → 624

        // ══════════════════════════════════════════════════════
        // SECTION 9: PRINT THE COMPLETE INVOICE
        // ══════════════════════════════════════════════════════

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║          TECHMART ORDER INVOICE          ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.printf ("║  Member Type : %-25s ║%n", membershipLabel);
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  ITEMS ORDERED                           ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.printf ("║  %-20s x%d = Rs.%-9.2f ║%n",
                product1Name, product1Qty, item1Total);
        System.out.printf ("║  %-20s x%d = Rs.%-9.2f ║%n",
                product2Name, product2Qty, item2Total);
        System.out.printf ("║  %-20s x%d = Rs.%-9.2f ║%n",
                product3Name, product3Qty, item3Total);
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.printf ("║  Subtotal       : Rs. %-19.2f ║%n",
                cartSubtotal);
        System.out.printf ("║  Discount (10%%) : Rs. %-19.2f ║%n",
                discountAmount);
        System.out.printf ("║  GST (18%%)      : Rs. %-19.2f ║%n",
                gstAmount);
        System.out.printf ("║  Delivery       : %-22s ║%n",
                deliveryLabel);
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.printf ("║  TOTAL PAYABLE  : Rs. %-19.2f ║%n",
                orderTotal);
        System.out.printf ("║  Display Price  : Rs. %-19d ║%n",
                displayTotal);
        System.out.printf ("║  YOU SAVED      : Rs. %-19d ║%n",
                savingsInt);
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.printf ("║  Total Items    : %-22d ║%n", totalItems);
        System.out.printf ("║  Even Item Count: %-22b ║%n", isEvenItemCount);
        System.out.printf ("║  Ready to Ship  : %-22b ║%n", readyToShip);
        System.out.printf ("║  Total Pages    : %-22d ║%n", totalPages);
        System.out.println("╚══════════════════════════════════════════╝");
    }
}