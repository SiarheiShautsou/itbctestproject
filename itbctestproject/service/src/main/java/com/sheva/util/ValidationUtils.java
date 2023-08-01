package com.sheva.util;

import com.sheva.exception.CommonException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Log4j2
@Service
@RequiredArgsConstructor
public class ValidationUtils {

    private final Validator validator;

    public <T> void validationRequest(T req){

        if(req != null) {
            Set<ConstraintViolation<T>> result = validator.validate(req);
            if (!result.isEmpty()) {

                String resultValidation = result.stream()
                        .map(ConstraintViolation::getMessage)
                        .reduce((s1, s2) -> s1 + ". " + s2).orElse("");

                log.error("Request isn't valid", resultValidation);
                throw new CommonException(resultValidation, 400, UUIDGenerator.generateUUID());

            }
        }
    }
}
