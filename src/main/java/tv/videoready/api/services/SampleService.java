package tv.videoready.api.services;

import org.springframework.stereotype.Service;
import tv.videoready.api.co.SampleCO;
import tv.videoready.api.dto.SampleResponseDTO;

/**
 * The {@link SampleService} handles actual logic for api's.
 *
 * @author Vikram Jakhar
 */
@Service
public class SampleService {
    public SampleResponseDTO sampleMethod(SampleCO sampleCO) {
        sampleCO.validate();
        SampleResponseDTO dto = new SampleResponseDTO();
        dto.setStr1("Wowwww!!!");
        dto.setFlag(true);
        return dto;
    }
}
