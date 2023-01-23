package org.gcs.cassandra.dao;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Data
@Builder
@Table("scan_location")
public class ScanLocation implements Serializable {

    @PrimaryKey
    private String name;

    private String location;


}
