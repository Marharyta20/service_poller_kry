package com.test.example.api;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.test.example.util.ServiceStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResponse {
    @NotBlank
    private String serviceUrl;
    @NotBlank
    private String serviceName;
    @NotNull
    private ServiceStatus status;
    @NotNull
    private LocalDate creationTime;
}
