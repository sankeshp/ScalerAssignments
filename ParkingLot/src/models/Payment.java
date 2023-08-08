package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder@Setter@Getter
public class Payment {
    private int paymentId;
    private double amount;
    private PaymentMode paymentMode;
}
