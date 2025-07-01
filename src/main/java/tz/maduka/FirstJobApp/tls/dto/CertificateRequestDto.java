package tz.maduka.FirstJobApp.tls.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CertificateRequestDto {

    private int rollNo;
    private String status;
    private String certificateIssueDate;
    private String certificateExpiryDate;
    private String admissionDate;
    private String fullName;
    private long petitionNo;
}
