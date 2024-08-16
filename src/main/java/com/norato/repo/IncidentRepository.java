package com.norato.repo;


import com.norato.model.Incident;
import com.norato.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
    List<Incident> findByUser(User user);
    Optional<Incident> findByIncidentId(String incidentId);
}
