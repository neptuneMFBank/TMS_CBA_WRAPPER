package com.neptune.cbawrapper.Services;

import com.neptune.cbawrapper.Models.PlatformCharges;
import com.neptune.cbawrapper.Repository.PlatformChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatformChargesService {

    @Autowired
    private PlatformChargeRepository repository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public PlatformCharges createPlatformCharge(PlatformCharges platformCharges) {
        if (platformCharges.getPlatformId() == 0) {
            platformCharges.setPlatformId(sequenceGeneratorService.getNextSequence(PlatformCharges.SEQUENCE_NAME));
        }
        return repository.save(platformCharges);
    }
}
