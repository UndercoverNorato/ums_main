package com.norato.model;






import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String incidentId;
    private String reporterName;
    private String incidentDetails;
    private LocalDateTime reportedDateTime;
    private String priority;
    private String status;
    @ManyToOne
    private User user;
}
