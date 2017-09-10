package io.namelos.licenses.services;

import io.namelos.licenses.config.ServiceConfig;
import io.namelos.licenses.model.License;
import io.namelos.licenses.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LicenseService {
    @Autowired
    private LicenseRepository licenseRepository;

    @Autowired
    ServiceConfig config;


    public License getLicense(String organizationId, String licenseId) {
        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        return license.withComment(config.getExampleProperty());

//        return new License()
//                .withId(licenseId)
//                .withOrganizationId(UUID.randomUUID().toString())
//                .withProductName("Test Product Name")
//                .withLicenseType("PerSeat");
    }

    public List<License> getLicensesByOrg(String organizationId) {
        return licenseRepository.findByOrOrganizationId(organizationId);
    }

    public void saveLicense(License license) {
        license.withId(UUID.randomUUID().toString());
        licenseRepository.save(license);
    }

    public void updateLicense(License license) {
        licenseRepository.save(license);
    }

    public void deleteLicense(License license) {
        licenseRepository.delete(license.getLicenseId());
    }
}
