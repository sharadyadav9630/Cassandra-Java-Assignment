package org.gcs.cassandra.repository;

import org.gcs.cassandra.dao.ScanResult;
import org.gcs.cassandra.dao.ScanResultCompositeKey;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.time.LocalDate;


public interface ScanResultRepository extends CassandraRepository<ScanResult, ScanResultCompositeKey> {

    ScanResult findByScanResultCompositeKeyScanDateAndScanResultCompositeKeyLocation(LocalDate localDate, String location);
}
