package com.norato.service;



import com.norato.model.Incident;
import com.norato.model.User;
import com.norato.repo.IncidentRepository;
import com.norato.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;
    @Autowired
    private UserRepository userRepository;

    public Incident createIncident(Incident incident, String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        incident.setUser(user);
        incident.setIncidentId(generateUniqueIncidentId());
        return incidentRepository.save(incident);
    }

    private String generateUniqueIncidentId() {
        String incidentId;
        do {
            incidentId = "RMG" + new Random().nextInt(100000) + "2022";
        } while (incidentRepository.findByIncidentId(incidentId).isPresent());
        return incidentId;
    }
}
