package com.syncfy.management.infrastructure.controllers;

import com.syncfy.management.domain.*;
import com.syncfy.management.infrastructure.services.IResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resource")
public class ResourceController {
    private Logger log = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    private IResourceService resourceService;

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String home() {
        log.info("hi from resource controller....");
        return "  Hello";
    }

    @PostMapping("/alert/new-alert")
    public ResponseEntity<AlertDtoDomain> newAlert(@RequestBody AlertDtoCreatorDomain creatorDomain)  {
        AlertDtoDomain alertDtoDomain = resourceService.newAlert(creatorDomain);
        return new ResponseEntity<>(alertDtoDomain, HttpStatus.OK);
    }

    @GetMapping("/alert/{id}")
    public ResponseEntity<List<AlertDtoDomain>> alertsByOAuth(@PathVariable String id) {
        List<AlertDtoDomain> alertList = resourceService.alertsByOAuth(id);
        return new ResponseEntity<>(alertList, HttpStatus.OK);
    }

    @DeleteMapping("/alert/{id}")
    public ResponseEntity<Void> deleteAlertByOAuth(@PathVariable String id) {
        resourceService.deleteAlertByOAuth(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/notification/{id}")
    public ResponseEntity<List<NotificationDtoDomain>> notificationByOAuth(@PathVariable String id) {
        List<NotificationDtoDomain> notificationList = resourceService.notificationByOAuth(id);
        return new ResponseEntity<>(notificationList, HttpStatus.OK);
    }

    @PostMapping("/notification/new-notification")
    public ResponseEntity<NotificationDtoDomain> newNotification(@RequestBody  NotificationDtoCreatorDomain creatorDomain) {
        NotificationDtoDomain notificationDtoDomain = resourceService.newNotification(creatorDomain);
        return new ResponseEntity<>(notificationDtoDomain, HttpStatus.OK);
    }

    @DeleteMapping("/notification/{id}")
    public ResponseEntity<Void> deleteNotificationById(@PathVariable String id) {
        resourceService.deleteNotificationById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
