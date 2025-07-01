package tz.maduka.FirstJobApp.tls.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseDto {

    private int feeYear;
    private String paymentStatus;
    private String status;
}
