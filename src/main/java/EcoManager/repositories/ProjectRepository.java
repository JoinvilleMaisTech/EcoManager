package EcoManager.repositories;

import EcoManager.entities.Organization;
import EcoManager.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
