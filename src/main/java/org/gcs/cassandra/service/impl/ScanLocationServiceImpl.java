package org.gcs.cassandra.service.impl;

import org.gcs.cassandra.dao.ScanLocation;
import org.gcs.cassandra.repository.ScanLocationRepository;
import org.gcs.cassandra.service.ScanLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScanLocationServiceImpl implements ScanLocationService {

    @Autowired
    private ScanLocationRepository scanLocationRepository;

    @Override
    public ScanLocation save(String scanLocation, String location) {
       ScanLocation locationScan = ScanLocation.builder().location(scanLocation).name(location).build();
        return scanLocationRepository.save(locationScan);
    }

    @Override
    public List<ScanLocation> findAll() {
        return scanLocationRepository.findAll();
    }

    @Override
    public ScanLocation findByName(String locationName) {
        return scanLocationRepository.findByName(locationName);
    }
}
