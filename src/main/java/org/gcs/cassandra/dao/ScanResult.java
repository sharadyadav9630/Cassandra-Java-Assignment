package org.gcs.cassandra.dao;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@Table("scan_result")
public class ScanResult implements Serializable {

    @PrimaryKey
    private ScanResultCompositeKey scanResultCompositeKey;

    @Column("bird_id")
    private UUID birdId;

    @Column("bird_species")
    private  String birdSpecies;

    @Column("bird_traits")
    private Set<String> birdTraits;

}
