package com.test.example.exception;

import static java.lang.String.format;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public class EntityNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -4212835435467380069L;

    private final Class<?> entityType;
    private final String fieldName;
    private final Object fieldValue;

    public EntityNotFoundException(final Class<?> entityType, final String fieldName, final Object fieldValue) {
        super(format("%s not found, %s=%s", entityType.getSimpleName(), fieldName, fieldValue));
        this.entityType = entityType;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
