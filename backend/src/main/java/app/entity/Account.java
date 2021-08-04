package app.entity;

import app.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Account {
    Long id;
    String number;
    Currency currency;
    Double balance = 0.0;
    Customer customer;

    public Account() {
        this.number = UUID.randomUUID().toString();
    }

}
