package com.example.microservice_for_backstage.Controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


@RestController
public class CatalogController {

    @GetMapping(value = "/catalog/software.yaml", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getCatalog() throws IOException {
        ClassPathResource resource = new ClassPathResource("software.yaml");
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }

    @GetMapping(value = "/catalog/another-service.yaml", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getAnotherServiceCatalog() throws IOException {
        ClassPathResource resource = new ClassPathResource("another-service.yaml");
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }
}

