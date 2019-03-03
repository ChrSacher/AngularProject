package BackendSpring.project.service;

import java.util.List;
import java.util.Optional;

import BackendSpring.project.domain.Project;
import BackendSpring.project.domain.ProjectMember;
import BackendSpring.project.domain.Task;
import BackendSpring.project.domain.Ticket;

public interface ProjectService {

    public void addTask(Project project, Task task);
    public void removeTask(Project project, Task task);
    
    public void addTicket(Project project, Ticket ticket);
    public void removeTicket(Project project, Ticket ticket);
    
    public void addProjectMember(Project project,ProjectMember member);
    public void removeProjectMember(Project project,ProjectMember member);
    
    public boolean createProject(Project project);
    public boolean updateProject(Project project);
    public boolean deleteProject(Project project);
    
    public Optional<Project> findOneByid(Long id);
    public List<Project> findAll();

}
