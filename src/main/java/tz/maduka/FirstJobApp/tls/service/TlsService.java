package tz.maduka.FirstJobApp.tls.service;

import tz.maduka.FirstJobApp.tls.dto.CertificateRequestDto;
import tz.maduka.FirstJobApp.tls.dto.CertificateResponseDto;
import tz.maduka.FirstJobApp.tls.dto.PaymentRequestDto;
import tz.maduka.FirstJobApp.tls.dto.PaymentResponseDto;

public interface TlsService {

    CertificateResponseDto checkPetitionNumber(CertificateRequestDto request);
    PaymentResponseDto getPaymentStatus(PaymentRequestDto request);
}
