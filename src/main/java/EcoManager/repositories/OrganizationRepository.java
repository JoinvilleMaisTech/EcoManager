package EcoManager.repositories;

import EcoManager.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    @Query("SELECT o FROM Organization o WHERE "
            + "(LOWER(o.name) LIKE LOWER(CONCAT('%', :name, '%')) OR :name IS NULL) AND "
            + "(LOWER(o.contact) LIKE LOWER(CONCAT('%', :contact, '%')) OR :contact IS NULL)")
    List<Organization> findByNameOrContact(@Param("name") String name, @Param("contact") String contact);
}
