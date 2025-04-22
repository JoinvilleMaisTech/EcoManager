package EcoManager.controllers;

import EcoManager.entities.Organization;
import EcoManager.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("organization")
public class OrganizationController {
    @Autowired private OrganizationService service;

    @GetMapping
    public List<Organization> get() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public Organization getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/filter")
    public List<Organization> getFiltered(@RequestParam(required = false) String name,
                                          @RequestParam(required = false) String contact) {
        return service.findAllByFilter(name, contact);
    }


    @PostMapping
    public Organization post(@RequestBody Organization organization) {
        organization.setId(null);
        return service.save(organization);
    }

    @PutMapping("{id}")
    public Organization put(@PathVariable Long id, @RequestBody Organization organization) {
        organization.setId(id);
        return service.save(organization);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }


}
