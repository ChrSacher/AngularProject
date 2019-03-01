package BackendSpring.project.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long>{

    public Project save(Project project);
    public Optional<Project> findOneByid(Long id);
    public List<Project> findAll();
    public void delete(Project project);
}
