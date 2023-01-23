package org.gcs.cassandra.service;

import org.gcs.cassandra.bean.ScanResultParam;
import org.gcs.cassandra.dao.ScanResult;

import java.util.List;

public interface ScanResultService {

    ScanResult save(ScanResultParam scanResultParam);

    ScanResult findByDateAndLocationName(String date, String locationName);
}
