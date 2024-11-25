package Classes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class FoodAndUtensils extends Product {
    private LocalDate expirationDate;

    public FoodAndUtensils(String code, String name, double unitPrice, int stockQuantity, int expirationDays) {
        super(code, name, unitPrice, stockQuantity); 
        this.expirationDate = LocalDate.now().plusDays(expirationDays);
    }

    public long daysToExpire() {
        return ChronoUnit.DAYS.between(LocalDate.now(), expirationDate);
    }

    @Override
    public String displayDetails() {
        return super.displayDetails() + String.format(", Expiration: %d days remaining", daysToExpire());
    }
}
