package BackendSpring.developer.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import BackendSpring.developer.domain.Developer;
import BackendSpring.developer.domain.DeveloperRepository;
import BackendSpring.security.domain.CurrentUser;
import BackendSpring.security.domain.UserCreateForm;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    @Override
    public Optional<Developer> getCurrentDeveloper() throws UserDeveloperNotFoundException {
	CurrentUser current = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	if (current == null) {
	    return Optional.ofNullable(null);
	} else {
	    Optional<Developer> dev = findDeveloperByEmail(current.getEmail());
	    if (dev.isPresent()) {
		return dev;
	    } else {
		throw (new UserDeveloperNotFoundException("Developer could not be found", current.getEmail()));

	    }

	}
    }

    @Override
    public List<Developer> findAll() {
	return developerRepository.findAll();
    }

    @Override
    public Developer createDeveloper(UserCreateForm form) throws UserAllreadyExistsException {
	Developer developer = new Developer("", "", form.getUserName(), form.getEmail());
	Optional<Developer> searchedDev = developerRepository.findByemail(form.getEmail());
	if (searchedDev.isPresent())
	    throw new UserAllreadyExistsException(form.getEmail());
	return developerRepository.save(developer);
    }

    public boolean doesDeveloperExist(UserCreateForm form) {
	Optional<Developer> searchedDev = developerRepository.findByemail(form.getEmail());
	if (searchedDev.isPresent())
	    return true;
	searchedDev = developerRepository.findByuserName(form.getUserName());
	if (searchedDev.isPresent())
	    return true;
	return false;
    }

    @Override
    public Optional<Developer> findDeveloperByEmail(String email) {
	return developerRepository.findByemail(email);
    }

    @Override
    public Optional<Developer> findDeveloperbyID(Long ID) {
	return developerRepository.findById(ID);
    }

    public List<Developer> findByPage(Integer pageNumber, Sort sorting) {
	if (sorting == null) {
	    return developerRepository.findAll(PageRequest.of(20 * pageNumber.intValue(), 20 * pageNumber + 20)).get()
		    .collect(Collectors.toList());
	} else {
	    return developerRepository
		    .findAll(PageRequest.of(20 * pageNumber.intValue(), 20 * pageNumber + 20, sorting)).get()
		    .collect(Collectors.toList());
	}

    }

    public long findPageMax(Sort sorting) {
	if (sorting == null) {
	    Page<Developer> page = developerRepository.findAll(PageRequest.of(0, 1));
	    return page.getTotalPages();
	} else {
	    Page<Developer> page = developerRepository.findAll(PageRequest.of(0, 1, sorting));
	    return page.getTotalPages();
	}

    }

}
