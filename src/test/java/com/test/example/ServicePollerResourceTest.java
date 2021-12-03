package com.test.example;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;
import static org.mockito.MockitoAnnotations.openMocks;

import java.net.URISyntaxException;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import com.test.example.api.ServiceRequest;
import com.test.example.domain.ServiceEntity;
import com.test.example.repository.ServiceRepository;
import com.test.example.rest.ServicePollerResource;
import com.test.example.transformer.ServiceEntityTransformer;
import com.test.example.util.ServiceStatus;

@SpringBootTest
class ServicePollerResourceTest {

    @Mock
    private ServiceEntityTransformer transformer;
    @Mock
    private ServiceRepository serviceRepository;

    private ServicePollerResource resource;

    @BeforeEach
    public void beforeEach() {
        openMocks(this);
        resource = new ServicePollerResource(serviceRepository, transformer);
    }

    @Test
    public void shouldProcessServicePoller() throws URISyntaxException {
        ServiceRequest serviceRequest = ServiceRequest.builder().name("Service1").url("https://www.123").build();
        //@formatter:off
        final ServiceEntity serviceEntity = ServiceEntity.builder()
                .id(1234L)
                .url("https://www.123")
                .name("Service1")
                .status(ServiceStatus.OK)
                .creationTime(
                LocalDate.parse("2021-12-01")).build();
        //@formatter:on

        given(transformer.transform(serviceRequest)).willReturn(serviceEntity);
        given(serviceRepository.save(serviceEntity)).willReturn(serviceEntity);

        assertThat(resource.createService(serviceRequest).getStatusCode(), is(HttpStatus.CREATED));

        then(transformer).should(only()).transform(serviceRequest);
        then(serviceRepository).should(only()).save(serviceEntity);
    }

}
