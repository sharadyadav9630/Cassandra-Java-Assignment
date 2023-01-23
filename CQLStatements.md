# Cassandra CQL Statements

Use this file to include your DDL.  Also include any DML that you may have created.


## DDL

CREATE KEYSPACE oboe WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;

CREATE TABLE bird ( id UUID PRIMARY KEY, name text, bird_characteristic set<text>);

CREATE TABLE scan_location ( name text PRIMARY KEY, location text);

CREATE TABLE scan_result(location text, scan_date Date, bird_id UUID, bird_species text, bird_traits set<text>, PRIMARY KEY((location, scan_date)));


## DML (if any)

## Inserting Bird table data when application get started.
