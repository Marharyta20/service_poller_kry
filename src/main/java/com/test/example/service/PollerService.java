package com.test.example.service;

import com.test.example.api.ServiceRequest;
import com.test.example.api.ServiceResponse;

public interface PollerService {
    ServiceResponse processServices(String serviceUrl, ServiceRequest serviceRequest);
}
