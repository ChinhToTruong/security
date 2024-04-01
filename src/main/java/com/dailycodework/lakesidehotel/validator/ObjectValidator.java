package com.dailycodework.lakesidehotel.validator;

import jakarta.annotation.PostConstruct;
import jakarta.validation.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Log4j2
public class ObjectValidator<T>{
    private Validator validator;

    @PostConstruct
    public void initValidatorFactory() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }


    public void validate(T instance) {
        Set<ConstraintViolation<T>> violations = validator.validate(instance);
        if (!violations.isEmpty()) {
            StringBuilder msg = new StringBuilder();
            msg.append("JSON object is not valid. Reasons (").append(violations.size()).append("): ");
            for (ConstraintViolation<T> violation : violations) {
                msg.append(violation.getMessage()).append(", ");
            }
            log.info("msg: {}", msg);
            throw new ConstraintViolationException(msg.toString(), violations);
        }
    }
}
