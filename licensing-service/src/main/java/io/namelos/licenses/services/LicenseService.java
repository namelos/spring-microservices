package io.namelos.licenses.services;

import io.namelos.licenses.model.License;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LicenseService {
    public License getLicense(String licenseId) {
        return new License()
                .withId(licenseId)
                .withOrganizationId(UUID.randomUUID().toString())
                .withProductName("Test Product Name")
                .withLicenseType("PerSeat");
    }

    public void saveLicense() {

    }

    public void updateLicense() {

    }

    public void deleteLicense() {

    }
}
