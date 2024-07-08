package com.norato.service;



import com.norato.model.Incident;
import com.norato.repo.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    public Incident createIncident(Incident incident) {
        incident.setIncidentId(generateIncidentId());
        incident.setReportedDateTime(LocalDateTime.now());
        return incidentRepository.save(incident);
    }

    public Incident getIncidentById(Long id) {
        return incidentRepository.findById(id).orElse(null);
    }

    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    private String generateIncidentId() {
        Random random = new Random();
        int randomNumber = 10000 + random.nextInt(90000);
        return "RMG" + randomNumber + LocalDateTime.now().getYear();
    }
}
