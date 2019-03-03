package BackendSpring.developer.service;

public class UserAllreadyExistsException extends Exception {

    private String email;
    public UserAllreadyExistsException(String email) {
	super("User allready exists!");
	this.setEmail(email);
    }
    /**
     * @return the email
     */
    public String getEmail() {
	return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
	this.email = email;
    }

}
