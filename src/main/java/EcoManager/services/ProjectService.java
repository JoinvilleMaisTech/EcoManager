package EcoManager.services;

import EcoManager.entities.Organization;
import EcoManager.entities.Project;
import EcoManager.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired private ProjectRepository repository;
    @Autowired private OrganizationService organizationService;

    public List<Project> findAll() {
        return repository.findAll();
    }

    public Project findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Project save(Project project) {
        if (project.getId() != null) {
            Project old = findById(project.getId());
            if (old != null) {
                project.setId(old.getId());
            } else {
                project.setId(null);
            }
        }

        Organization organization = organizationService.findById(project.getOrganization().getId());
        if (organization == null) {
            return null;
        }

        project.setOrganization(organization);

        return repository.save(project);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
