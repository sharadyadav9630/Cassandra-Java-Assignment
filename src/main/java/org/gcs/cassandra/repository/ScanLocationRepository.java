package org.gcs.cassandra.repository;

import org.gcs.cassandra.dao.ScanLocation;
import org.springframework.data.cassandra.repository.CassandraRepository;


public interface ScanLocationRepository extends CassandraRepository<ScanLocation, String> {
    ScanLocation findByName(String locationName);
}
