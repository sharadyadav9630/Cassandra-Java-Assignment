package org.gcs.cassandra.service.impl;

import org.gcs.cassandra.bean.ScanResultParam;
import org.gcs.cassandra.dao.Bird;
import org.gcs.cassandra.dao.ScanLocation;
import org.gcs.cassandra.dao.ScanResult;
import org.gcs.cassandra.dao.ScanResultCompositeKey;
import org.gcs.cassandra.repository.BirdRepository;
import org.gcs.cassandra.repository.ScanLocationRepository;
import org.gcs.cassandra.repository.ScanResultRepository;
import org.gcs.cassandra.service.ScanResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ScanResultServiceImpl implements ScanResultService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ScanResultRepository scanResultRepository;

    @Autowired
    private ScanLocationRepository scanLocationRepository;

    @Autowired
    private BirdRepository birdRepository;

    @Override
    public ScanResult save(ScanResultParam scanResultParam) {
        logger.info("*** fetch scan location from DB ***");
        ScanLocation scanLocation = scanLocationRepository.findByName(scanResultParam.getLocationName());
        logger.info("*** fetched scan location from DB ***");

        logger.info("*** fetch bird detail from DB ***");
        Optional<Bird> bird = birdRepository.findById(scanResultParam.getBirdId());
        logger.info("*** fetched bird detail from DB ***");


        ScanResultCompositeKey scanResultCompositeKey = ScanResultCompositeKey.builder().scanDate(LocalDate.now()).location(scanLocation.getLocation()).build();
        ScanResult scanResult = ScanResult.builder().scanResultCompositeKey(scanResultCompositeKey).birdId(bird.get().getId())
                .birdSpecies(bird.get().getName()).birdTraits(bird.get().getBirdCharacteristic()).build();

        return scanResultRepository.save(scanResult);
    }

    @Override
    public ScanResult findByDateAndLocationName(String date, String locationName) {
        logger.info("*** fetch location from DB ***");
        ScanLocation scanLocation = scanLocationRepository.findByName(locationName);
        logger.info("*** fetched location from DB ***");

        LocalDate localDate = LocalDate.parse(date);
        return scanResultRepository.findByScanResultCompositeKeyScanDateAndScanResultCompositeKeyLocation(localDate,scanLocation.getLocation());
    }

}
