package org.gcs.cassandra.service;

import org.gcs.cassandra.dao.ScanLocation;

import java.util.List;

public interface ScanLocationService {

    ScanLocation save(String scanLocation, String location);

    List<ScanLocation> findAll();

    ScanLocation findByName(String locationName);
}
