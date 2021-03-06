package BackendSpring.project.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import BackendSpring.BaseEntity;

@Entity
public class Task extends BaseEntity<Long> {
    private String name;
    private String description;
    
    @ManyToOne
    private ProjectMember creator;

    @OneToMany
    private List<Comment> comments = new ArrayList();
    
    @ManyToMany
    private List<ProjectMember> assignees = new ArrayList();

    /**
     * @param name
     * @param description
     * @param creator
     */
    public Task(String name, String description, ProjectMember creator) {
	super();
	this.name = name;
	this.description = description;
	this.creator = creator;
    }

    public Task() {

    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
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
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * @return the creator
     */
    public ProjectMember getCreator() {
	return creator;
    }

    /**
     * @param creator
     *            the creator to set
     */
    public void setCreator(ProjectMember creator) {
	this.creator = creator;
    }

    /**
     * @return the comments
     */
    public List<Comment> getComments() {
	return comments;
    }

    /**
     * @param comments
     *            the comments to set
     */
    public void setComments(List<Comment> comments) {
	this.comments = comments;
    }

    /**
     * @return the assignees
     */
    public List<ProjectMember> getAssignees() {
	return assignees;
    }

    /**
     * @param assignees
     *            the assignees to set
     */
    public void setAssignees(List<ProjectMember> assignees) {
	this.assignees = assignees;
    }

}
