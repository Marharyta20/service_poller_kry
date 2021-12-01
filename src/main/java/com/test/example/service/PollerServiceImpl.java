package com.test.example.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.test.example.api.ServiceRequest;
import com.test.example.api.ServiceResponse;
import com.test.example.domain.ServiceEntity;
import com.test.example.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PollerServiceImpl implements PollerService {
    private ServiceRepository repository;

    @Override
    public ServiceResponse processServices(final String serviceUrl, final ServiceRequest serviceRequest) {
        final List<ServiceEntity> entities = repository.findAll();

        return null;
    }
}
