package tz.maduka.FirstJobApp.tls.serviceImpl;

import org.springframework.stereotype.Service;
import tz.maduka.FirstJobApp.tls.dto.CertificateRequestDto;
import tz.maduka.FirstJobApp.tls.dto.CertificateResponseDto;
import tz.maduka.FirstJobApp.tls.dto.PaymentRequestDto;
import tz.maduka.FirstJobApp.tls.dto.PaymentResponseDto;
import tz.maduka.FirstJobApp.tls.service.TlsService;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TlsServiceImpl implements TlsService {

    private static final Map<Long, String> memberPetitions = new HashMap<>();
    private static final Map<String, PaymentResponseDto> paymentStatus = new HashMap<>();

    static {
        memberPetitions.put(1234567L, "John Doe");
        memberPetitions.put(9998888L, "Jane Smith");

        paymentStatus.put("7873", new PaymentResponseDto(2025, "NOT_PAID", "PRACTISING_MEMBER"));
        paymentStatus.put("1234", new PaymentResponseDto(2025, "PAID", "NON_PRACTISING_MEMBER"));
    }

    @Override
    public CertificateResponseDto checkPetitionNumber(CertificateRequestDto request) {
        if (!memberPetitions.containsKey(request.getPetitionNo())) {
            return new CertificateResponseDto(
                    false,
                    UUID.randomUUID().toString().replace("-", ""),
                    "Member with the provided petition number does not exist"
            );
        }
        return new CertificateResponseDto(true, UUID.randomUUID().toString().replace("-", ""), "Member found.");
    }

    @Override
    public PaymentResponseDto getPaymentStatus(PaymentRequestDto request) {
        return paymentStatus.getOrDefault(request.getRollNo(),
                new PaymentResponseDto(2025, "NOT_FOUND", "UNKNOWN_MEMBER"));
    }
}
