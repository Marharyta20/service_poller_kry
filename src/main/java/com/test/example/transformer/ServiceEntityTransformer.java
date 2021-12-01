package com.test.example.transformer;

import com.test.example.api.ServiceRequest;
import com.test.example.domain.ServiceEntity;

public interface ServiceEntityTransformer {
    ServiceEntity transform(ServiceRequest serviceEntity);
}
