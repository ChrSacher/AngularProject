package BackendSpring.project.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import BackendSpring.BaseEntity;
import BackendSpring.developer.domain.Developer;
@Entity
public class Comment extends BaseEntity<Long>{
   
    private String content;
    @ManyToOne
    private Developer commentator;
    @OneToMany
    private List<Comment> subComments;
    
    /**
     * @param content
     * @param commentator
     */
    public Comment(String content, Developer commentator) {
	super();
	this.content = content;
	this.commentator = commentator;
    }
    
    public Comment() {}
    
    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }
    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
    /**
     * @return the commentator
     */
    public Developer getCommentator() {
        return commentator;
    }
    /**
     * @param commentator the commentator to set
     */
    public void setCommentator(Developer commentator) {
        this.commentator = commentator;
    }
    /**
     * @return the subComments
     */
    public List<Comment> getSubComments() {
        return subComments;
    }
    /**
     * @param subComments the subComments to set
     */
    public void setSubComments(List<Comment> subComments) {
        this.subComments = subComments;
    }
    
    
}
