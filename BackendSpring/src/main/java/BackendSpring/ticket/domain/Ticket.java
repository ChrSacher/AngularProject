package BackendSpring.ticket.domain;

import java.util.Date;
import java.util.List;

import BackendSpring.BaseEntity;
import BackendSpring.developer.domain.Developer;

public class Ticket extends BaseEntity<Long> {
    
    private String name;
    private String description;
    private Developer creator;
    private Date submittedDate;
    private List<String> tags;
    private List<Comment> comments;
    private TicketStatus status;
    
    /**
     * 
     */
    public Ticket() {
	super();
    }

    /**
     * @param name
     * @param description
     * @param creator
     * @param submittedDate
     * @param status
     */
    public Ticket(String name, String description, Developer creator, Date submittedDate, TicketStatus status) {
	super();
	this.name = name;
	this.description = description;
	this.creator = creator;
	this.submittedDate = submittedDate;
	this.status = status;
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
     * @return the creator
     */
    public Developer getCreator() {
        return creator;
    }

    /**
     * @param creator the creator to set
     */
    public void setCreator(Developer creator) {
        this.creator = creator;
    }

    /**
     * @return the submittedDate
     */
    public Date getSubmittedDate() {
        return submittedDate;
    }

    /**
     * @param submittedDate the submittedDate to set
     */
    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    /**
     * @return the tags
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * @return the comments
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    /**
     * @return the status
     */
    public TicketStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(TicketStatus status) {
        this.status = status;
    }
   
    
}
