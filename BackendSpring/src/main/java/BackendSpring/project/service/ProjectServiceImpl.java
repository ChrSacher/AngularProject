package BackendSpring.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import BackendSpring.project.domain.Project;
import BackendSpring.project.domain.ProjectMember;
import BackendSpring.project.domain.ProjectRepository;
import BackendSpring.task.domain.Task;
import BackendSpring.ticket.domain.Ticket;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository pRepository;
    
    @Override
    public void addTask(Project project, Task task) {
	project.addTask(task);
    }

    @Override
    public void removeTask(Project project, Task task) {
	project.removeTask(task);
    }

    @Override
    public void addTicket(Project project, Ticket ticket) {
	project.addTicket(ticket);

    }

    @Override
    public void removeTicket(Project project, Ticket ticket) {
	project.removeTicket(ticket);

    }

    public void addProjectMember(Project project, ProjectMember member) {
	project.removeProjectMember(member);
    }

    public void removeProjectMember(Project project, ProjectMember member) {
	project.removeProjectMember(member);
    }

    @Override
    public boolean createProject(Project project) {
	Optional<Project> oP = pRepository.findById(project.getId());
	if(oP.isPresent())
	{
	    return false;
	}
	else
	{
	    pRepository.save(project);
	    return true;
	}
	
    }

    @Override
    public boolean updateProject(Project project) {
	Optional<Project> oP = pRepository.findById(project.getId());
	if(oP.isPresent())
	{
	    pRepository.save(project);
	    return true;
	}
	else
	{
	   
	    return false;
	}
    }

    @Override
    public boolean deleteProject(Project project) {
	pRepository.delete(project);
	return true;
    }

    @Override
    public Optional<Project> findOneByid(Long id) {
	return pRepository.findOneByid(id);

    }

    @Override
    public List<Project> findAll() {
	return pRepository.findAll();

    }
}
