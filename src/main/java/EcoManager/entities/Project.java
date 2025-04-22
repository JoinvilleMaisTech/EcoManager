package EcoManager.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private Double co2Estimate;

    @ManyToOne
    @JoinColumn(name= "organization_id", nullable = false)
    private Organization organization;
}
