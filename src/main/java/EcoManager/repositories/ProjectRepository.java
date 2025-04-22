package EcoManager.repositories;

import EcoManager.entities.Organization;
import EcoManager.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByRegionContainingIgnoreCase(String region);

    List<Project> findByOrganizationNameContainingIgnoreCase(String organizationName);

    List<Project> findByRegionAndOrganizationNameContainingIgnoreCase(String region, String organizationName);
}
