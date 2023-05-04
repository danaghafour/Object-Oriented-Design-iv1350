package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.integration.DiscountSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountSystemTest {

    private DiscountSystem discountSystem;

    @BeforeEach
    public void init() {
        discountSystem = new DiscountSystem();
    }
}
