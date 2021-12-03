package com.test.example.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.test.example.api.ServiceRequest;
import com.test.example.domain.ServiceEntity;
import com.test.example.repository.ServiceRepository;
import com.test.example.transformer.ServiceEntityTransformer;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/services")
public class ServicePollerResource {

    private ServiceRepository serviceRepository;
    private ServiceEntityTransformer transformer;

    @GetMapping
    public List<ServiceEntity> getServices() {
        return serviceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ServiceEntity getService(@PathVariable Long id) {
        return serviceRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity<?> createService(@RequestBody @Valid ServiceRequest serviceRequest)
            throws URISyntaxException {
        ServiceEntity savedServiceEntity = serviceRepository.save(transformer.transform(serviceRequest));
        return ResponseEntity.created(new URI("/service/" + savedServiceEntity.getId())).body(savedServiceEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteService(@PathVariable Long id) {
        serviceRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
