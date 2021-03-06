package com.S00185883.service4u.Controller;

import java.util.List;
import java.util.Optional;
// Importing required classes
import javax.validation.Valid;

import com.S00185883.service4u.Service.ProvidersService;
import com.S00185883.service4u.model.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Annotation
@RestController
// Class
public class ProvidersController {

    @Autowired private ProvidersService providersService;

    // Save operation
    @PostMapping("/providers")
    @CrossOrigin(origins = "https://service4u.netlify.app")
    public Provider saveProvider(
            @Valid @RequestBody Provider provider)
    {
        return providersService.saveProvider(provider);
    }

    // Read operation
    @GetMapping("/providers/sector/All")
    @CrossOrigin(origins = "https://service4u.netlify.app")
    public List<Provider> fetchProviderList()
    {
        return providersService.fetchProviderList();
    }

    // Update operation
    @PutMapping("/providers/{id}")
    @CrossOrigin(origins = "https://service4u.netlify.app")
    public Provider
    updateDepartment(@RequestBody Provider provider,
                     @PathVariable("id") Long providerId)
    {
        return providersService.updateProvider(
                provider, providerId);
    }

    // Delete operation
    @DeleteMapping("/providers/{id}")
    @CrossOrigin(origins = "https://service4u.netlify.app")
    public String deleteProviderById(@PathVariable("id")
                                               Long providerId)
    {
        providersService.deleteProviderById(
                providerId);
        return "Deleted Successfully";
    }
    @GetMapping("/providers/{county}")
    @CrossOrigin(origins = "https://service4u.netlify.app")
    public List<Provider> findByCounty(@PathVariable("county") String county)
    {
        return providersService.findByCounty(county);

    }
    @GetMapping("/providers/sector/{sector}")
    @CrossOrigin(origins = "https://service4u.netlify.app")
    public List<Provider> findBySector(@PathVariable("sector") String sector)
    {
        return providersService.findBySector(sector);

    }
    @GetMapping("/provider/{providerId}")
    @CrossOrigin(origins = "https://service4u.netlify.app")
    public Optional<Provider> findById(@PathVariable("providerId") Long providerId)
    {
        return providersService.findById(providerId);

    }
    @GetMapping("/providers/{county}/{sector}")
    @CrossOrigin(origins = "https://service4u.netlify.app")
    public List<Provider> findByCountyAndSector(@PathVariable("county") String county,@PathVariable("sector") String sector)
    {
        if(sector=="All") {
            return providersService.findByCounty(county);
        }
        else {
            return providersService.findByCountyAndSector(county, sector);
        }

    }
}
