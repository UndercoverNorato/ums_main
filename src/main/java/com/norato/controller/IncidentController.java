package com.norato.controller;




import com.norato.model.Incident;
import com.norato.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @PostMapping("/create")
    public ResponseEntity<Incident> createIncident(@RequestBody Incident incident, @RequestParam String username) {
        return ResponseEntity.ok(incidentService.createIncident(incident, username));
    }
}
