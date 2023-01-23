package org.gcs.cassandra.repository;

import org.gcs.cassandra.dao.Bird;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface BirdRepository extends CassandraRepository<Bird, UUID> {
}
