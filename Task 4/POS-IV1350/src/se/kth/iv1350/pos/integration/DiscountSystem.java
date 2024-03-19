package se.kth.iv1350.pos.integration;

import java.util.*;
/**
 * The DiscountSystem class provides discount information based on customer IDs.
 */
public class DiscountSystem {

    private Map<String, Integer> discountMap;

    /**
     * Creates a new instance of DiscountSystem and initializes the discount map.
     */
    public DiscountSystem() {
        discountMap = new HashMap<>();
        discountMap.put("123", 10);
        discountMap.put("456", 15);
        discountMap.put("789", 25);
    }

    /**
     * Gets the discount percentage for a customer based on their customer ID.
     *
     * @param customerId The ID of the customer to get the discount for.
     * @return The discount percentage as an integer value. If no discount is found for the customer, 0 is returned.
     */
    public int getDiscount(String customerId) {
        return discountMap.getOrDefault(customerId, 0);
    }
}