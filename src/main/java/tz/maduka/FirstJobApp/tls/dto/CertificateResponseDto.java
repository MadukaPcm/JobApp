package tz.maduka.FirstJobApp.tls.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CertificateResponseDto {

    private boolean success;
    private String requestId;
    private String message;
}
