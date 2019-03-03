package BackendSpring.project.domain;

import javax.persistence.Entity;

import BackendSpring.BaseEntity;

@Entity
public class TicketTag extends BaseEntity<Long>{

    private String shortName;
    private String fullName;
    private String descrition;
    
    /**
     * 
     */
    public TicketTag() {
	super();
    }
    /**
     * @param shortName
     * @param fullName
     * @param descrition
     */
    public TicketTag(String shortName, String fullName, String descrition) {
	super();
	this.shortName = shortName;
	this.fullName = fullName;
	this.descrition = descrition;
    }
    /**
     * @return the shortName
     */
    public String getShortName() {
        return shortName;
    }
    /**
     * @param shortName the shortName to set
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }
    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    /**
     * @return the descrition
     */
    public String getDescrition() {
        return descrition;
    }
    /**
     * @param descrition the descrition to set
     */
    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }
    
    
}
