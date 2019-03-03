package BackendSpring.developer.boundary;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import BackendSpring.developer.domain.Developer;
import BackendSpring.developer.service.DeveloperService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/developer"})
public class DeveloperController {

    @Autowired
    private DeveloperService dService;
   
    @PostMapping({"/getDevelopersByPage"})
    public ResponseEntity<List<Developer>> getDevelopersByPage(@RequestParam Optional<Integer> pageNumber) {
	int page = 0;
	if(pageNumber.isPresent()) page = pageNumber.get();
	return new ResponseEntity<List<Developer>>(dService.findByPage(page,null), HttpStatus.OK);
    }
    
    @PostMapping({"/getDevelopersPageMax"})
    public ResponseEntity<Long> getDevelopersPageMax() {
	return new ResponseEntity<Long>(dService.findPageMax(null), HttpStatus.OK);
    }
   
    
}
