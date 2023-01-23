package org.gcs.cassandra.dao;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@PrimaryKeyClass
public class ScanResultCompositeKey implements Serializable {

    @PrimaryKeyColumn(name = "scan_date",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    private LocalDate scanDate;

    @PrimaryKeyColumn(name = "location",ordinal = 1,type = PrimaryKeyType.PARTITIONED)
    private String location;


}
