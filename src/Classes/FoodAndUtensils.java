package Classes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class FoodAndUtensils extends Product {
    private LocalDate expirationDate;

    // Constructor
    public FoodAndUtensils(String code, String name, double unitPrice, int stockQuantity, int expirationDays) {
        super(code, name, unitPrice, stockQuantity); // Calls the Product constructor
        this.expirationDate = LocalDate.now().plusDays(expirationDays);
    }

    // Method to calculate days until expiration
    public long daysToExpire() {
        return ChronoUnit.DAYS.between(LocalDate.now(), expirationDate);
    }

    @Override
    public String displayDetails() {
        // Adds expiration information to the base details
        return super.displayDetails() + String.format(", Expiration: %d days remaining", daysToExpire());
    }
}