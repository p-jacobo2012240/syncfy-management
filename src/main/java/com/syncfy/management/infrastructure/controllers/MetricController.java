package com.syncfy.management.infrastructure.controllers;

import com.syncfy.management.domain.AlertDtoCreatorDomain;
import com.syncfy.management.domain.AlertDtoDomain;
import com.syncfy.management.domain.AuthDtoDomain;
import com.syncfy.management.domain.AuthDtoPayloadDomain;
import com.syncfy.management.infrastructure.services.IMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metrics")
public class MetricController {
    @Autowired
    private IMetricService metricService;

    @PostMapping("/alert/new-alert")
    public ResponseEntity<AlertDtoDomain> newAlert(@RequestBody AlertDtoCreatorDomain creatorDomain)  {
        AlertDtoDomain alertDtoDomain = metricService.newAlert(creatorDomain);
        return new ResponseEntity<>(alertDtoDomain, HttpStatus.OK);
    }

    @GetMapping("/alert/{id}")
    public ResponseEntity<List<AlertDtoDomain>> alertsByOAuth(@PathVariable String id) {
        List<AlertDtoDomain> alertList = metricService.alertsByOAuth(id);
        return new ResponseEntity<>(alertList, HttpStatus.OK);
    }

    @DeleteMapping("/alert/{id}")
    public ResponseEntity<List<AlertDtoDomain>> deleteAlertByOAuth(@PathVariable String id) {
        metricService.deleteAlertByOAuth(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
