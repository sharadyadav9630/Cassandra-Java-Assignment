package org.gcs.cassandra.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.gcs.cassandra.bean.ScanLocationParam;
import org.gcs.cassandra.dao.ScanLocation;
import org.gcs.cassandra.service.ScanLocationService;
import org.gcs.cassandra.utils.Coordinate;
import org.gcs.cassandra.utils.FindLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/location")
@Tag(name = "Location Scan controller", description = "Configure satellite scan location and read their scan location API with documentation annotations")
public class ScanLocationController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ScanLocationService scanLocationService;

    @Operation(summary = "Configure Scan Location ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Save Scan Location",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ScanLocation.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PostMapping("/save")
    public ResponseEntity<ScanLocation> save(@Parameter(description = " Location name is sent as parameter") @RequestBody ScanLocationParam scanLocationParam) {

        logger.info("*** Getting Latitude and Longitude by location :: {}", scanLocationParam);
        // Can use third party api like (HERE Geocoding & Search API) to get these details but using own created FindLocation
        // utility class to get these details
        Coordinate latAndLon = FindLocation.getLatAndLong(scanLocationParam.getLocationName());
        if(Objects.isNull(latAndLon))
            return ResponseEntity.ok().body(ScanLocation.builder().location("Location Does not exit for").name(scanLocationParam.getLocationName()).build());


        logger.info("*** First check scan location in scan_location table:: {}");
        //If Location exit in scan_location table then don't need to call third party api to save Cost
        ScanLocation scanLocation = scanLocationService.findByName(scanLocationParam.getLocationName());

        ScanLocation savedLocationScan = null;
        if(Objects.isNull(scanLocation)) {
            logger.info("*** Getting Scan Location by Latitude :: {} and Longitude :: {}", latAndLon.getLat(), latAndLon.getLon());
            String scanLocationStr = FindLocation.getLocation(latAndLon.getLat(), latAndLon.getLon());

            logger.info("*** Save Scan Location to DB ***");
            savedLocationScan = scanLocationService.save(scanLocationStr, scanLocationParam.getLocationName());
            logger.info("*** Saved Scan Location to DB ***");
        }else{
            logger.info("*** Save Scan Location to DB ***");
            savedLocationScan = scanLocationService.save(scanLocation.getLocation(), scanLocationParam.getLocationName());
            logger.info("*** Saved Scan Location to DB ***");
        }

        return ResponseEntity.ok().body(savedLocationScan);
    }

    @Operation(summary = "Get all Scan Location")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Scan Location list",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = ScanLocation.class)))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<ScanLocation>> findAll() {

        logger.info("*** Getting Scan Location from DB ***");
        List<ScanLocation> list = scanLocationService.findAll();
        logger.info("Scan Location fetched from DB :: {}", list);

        return ResponseEntity.ok().body(list);
    }
}
