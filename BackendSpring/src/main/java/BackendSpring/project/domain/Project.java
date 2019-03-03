package BackendSpring.project.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import BackendSpring.BaseEntity;
import BackendSpring.developer.domain.Developer;

@Entity
public class Project extends BaseEntity<Long> {

    private String name;
    private String description;
    
    @ManyToMany
    private List<ProjectMember> members = new ArrayList();
    
    @OneToMany
    private List<Task> tasks = new ArrayList();
   
    @OneToMany
    private List<Ticket> tickets = new ArrayList();;
    
    public void addProjectMember(ProjectMember member)
    {
	members.add(member);
    }
    
    public void removeProjectMember(ProjectMember member)
    {
	members.remove(member);
    }
    
    public void addTask(Task task)
    {
	tasks.add(task);
    }
    
    public void removeTask(Task task)
    {
	tasks.remove(task);
    }
    
    public void addTicket(Ticket ticket)
    {
	tickets.add(ticket);
    }
    
    public void removeTicket(Ticket ticket)
    {
	tickets.remove(ticket);
    }
    public Project() {
	
    }
    /**
     * @param name
     * @param description
     */
    public Project(String name, String description) {
	super();
	this.name = name;
	this.description = description;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return the members
     */
    public List<ProjectMember> getMembers() {
        return members;
    }
    /**
     * @param members the members to set
     */
    public void setMembers(List<ProjectMember> members) {
        this.members = members;
    }
    /**
     * @return the tasks
     */
    public List<Task> getTasks() {
        return tasks;
    }
    /**
     * @param tasks the tasks to set
     */
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    /**
     * @return the tickets
     */
    public List<Ticket> getTickets() {
        return tickets;
    }
    /**
     * @param tickets the tickets to set
     */
    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
