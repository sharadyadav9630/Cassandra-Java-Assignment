package org.gcs.cassandra;

import org.gcs.cassandra.dao.Bird;
import org.gcs.cassandra.repository.BirdRepository;
import org.gcs.cassandra.utils.HelperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.List;


@SpringBootApplication
@EnableCassandraRepositories
public class CassandraJavaAssignment {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(CassandraJavaAssignment.class, args);
	}

	@Autowired
	private BirdRepository birdRepository;

	@Bean
	CommandLineRunner runner() {
		return args -> {
			List<Bird> birds = birdRepository.findAll();
			if (birds.isEmpty()) {
				logger.info("******* Inserting Birds to DB *******");
				birdRepository.saveAll(HelperUtil.getBirds());
				logger.info("******* Birds is inserted successfully in DB *******");
			} else {
				logger.info("******* Birds stored in DB Size :: {}", birds.size());
				logger.info("******* Birds stored in DB :: {}", birds);
			}
		};
	}

}