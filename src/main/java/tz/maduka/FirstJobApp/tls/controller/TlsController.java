package tz.maduka.FirstJobApp.tls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import tz.maduka.FirstJobApp.tls.dto.CertificateRequestDto;
import tz.maduka.FirstJobApp.tls.dto.CertificateResponseDto;
import tz.maduka.FirstJobApp.tls.dto.PaymentRequestDto;
import tz.maduka.FirstJobApp.tls.dto.PaymentResponseDto;
import tz.maduka.FirstJobApp.tls.service.TlsService;

@RestController
@RequestMapping("/api/tls")
public class TlsController {

    @Autowired
    private TlsService barService;

    @PostMapping("/check-petition")
    public CertificateResponseDto checkPetition(@RequestBody CertificateRequestDto request) {
        return barService.checkPetitionNumber(request);
    }

    @PostMapping("/payment-status")
    public PaymentResponseDto getPaymentStatus(@RequestBody PaymentRequestDto request) {
        return barService.getPaymentStatus(request);
    }
}
