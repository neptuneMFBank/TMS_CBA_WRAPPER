package com.neptune.cbawrapper.Exception;


import com.neptune.cbawrapper.Models.ErrorLogsModel;
import com.neptune.cbawrapper.Repository.ErrorLogsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ErrorLoggingException {

    private final ErrorLogsRepository errorLogsRepository;

    public void logError(String type, String cause, String message){
        ErrorLogsModel errorLogsModel = new ErrorLogsModel(cause, message);
        errorLogsModel.setType(type);
        errorLogsModel.setCreatedAt(Instant.now());
        errorLogsModel.setUpdatedAt(Instant.now());
        errorLogsRepository.save(errorLogsModel);
    }
}
