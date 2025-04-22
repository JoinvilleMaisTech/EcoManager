package EcoManager.services;

import EcoManager.entities.Organization;
import EcoManager.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    @Autowired private OrganizationRepository repository;

    public List<Organization> findAll() {
        return repository.findAll();
    }

    public Organization findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Organization> findAllByFilter(String name, String contact) {
        if (name == null && contact == null) {
            return findAll();
        }
        return repository.findByNameOrContact(name, contact);
    }

    public Organization save(Organization organization) {
        if (organization.getId() != null) {
            Organization old = findById(organization.getId());
            if (old != null) {
                organization.setId(old.getId());
            } else {
                organization.setId(null);
            }
        }
        return repository.save(organization);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
