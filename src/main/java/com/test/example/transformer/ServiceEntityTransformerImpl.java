package com.test.example.transformer;

import java.time.LocalDate;
import org.springframework.stereotype.Component;
import com.test.example.api.ServiceRequest;
import com.test.example.domain.ServiceEntity;
import com.test.example.util.ServiceStatus;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ServiceEntityTransformerImpl implements ServiceEntityTransformer {
    @Override
    public ServiceEntity transform(final ServiceRequest serviceRequest) {
        //@formatter:off
        return ServiceEntity.builder()
                .name(serviceRequest.getName())
                .url(serviceRequest.getUrl())
                .creationTime(LocalDate.now())
                .status(ServiceStatus.OK)
                .build();
        //@formatter:on
    }
}
