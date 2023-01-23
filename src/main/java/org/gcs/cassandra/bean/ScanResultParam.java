package org.gcs.cassandra.bean;

import lombok.Data;
import java.util.UUID;

@Data
public class ScanResultParam {

    private UUID birdId;

    private String locationName;
}
