package BackendSpring.developer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import BackendSpring.developer.domain.Developer;
import BackendSpring.security.domain.UserCreateForm;



public interface DeveloperService {

    public Optional<Developer> getCurrentDeveloper() throws UserDeveloperNotFoundException;
    public List<Developer> findAll();
    public Developer createDeveloper(UserCreateForm form) throws UserAllreadyExistsException;
    public boolean doesDeveloperExist(UserCreateForm form);
    public Optional<Developer> findDeveloperByEmail(String email);
    public Optional<Developer> findDeveloperbyID(Long ID);

    public List<Developer> findByPage(Integer pageNumber,Sort sorting);
    public long findPageMax(Sort sorting);

}
