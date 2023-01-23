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
@Table("bird")
public class Bird implements Serializable {

    @PrimaryKey
    private UUID id ;

    private String name;

    @Column("bird_characteristic")
    private Set<String> birdCharacteristic;
}
