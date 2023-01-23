package org.gcs.cassandra.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.gcs.cassandra.bean.ScanResultParam;
import org.gcs.cassandra.dao.ScanResult;
import org.gcs.cassandra.service.ScanResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/result")
@Tag(name = "Result Scan controller", description = "Configure satellite scan result and read their scan result API with documentation annotations")
public class ScanResultController {


    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ScanResultService scanResultService;

    @Operation(summary = "Configure scan result ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Save Scan result",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ScanResult.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PostMapping("/save")
    public ResponseEntity<ScanResult> save(@Parameter(description = " Scan Date and bird unique id is sent as parameter") @RequestBody ScanResultParam scanResultParam) {

        logger.info("*** Save Scan Result ***");
        ScanResult savedScanResult= scanResultService.save(scanResultParam);
        logger.info("*** Saved Scan Result to DB ***");

        return ResponseEntity.ok().body(savedScanResult);
    }

    @Operation(summary = "Get all Scan Result By date and Location Name and Date must be in YYYY-MM_DD format")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Scan Result list",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = ScanResult.class)))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/getScanResult")
    public ResponseEntity<ScanResult> findScanResults(@Parameter(description = "YYYY-MM-DD") @RequestParam String date, @RequestParam String locationName) {

        logger.info("*** Getting Scan Result from DB ***");
        ScanResult scanResult = scanResultService.findByDateAndLocationName(date,locationName);
        logger.info("Scan Result fetched from DB :: {}", scanResult);

        return ResponseEntity.ok().body(scanResult);
    }
}
