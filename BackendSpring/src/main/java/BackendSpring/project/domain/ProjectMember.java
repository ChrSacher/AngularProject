package BackendSpring.project.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import BackendSpring.BaseEntity;
import BackendSpring.developer.domain.Developer;

@Entity
public class ProjectMember extends BaseEntity<Long> {

    public ProjectMember() {

    }

    /**
     * @param member
     */
    public ProjectMember(Developer member) {
	super();
	this.member = member;
    }

    @ManyToOne
    private Developer member;

    /**
     * @return the member
     */
    public Developer getMember() {
	return member;
    }

    /**
     * @param member
     *            the member to set
     */
    public void setMember(Developer member) {
	this.member = member;
    }
}
