package BackendSpring.developer.service;

public class UserDeveloperNotFoundException extends Exception {
    private String message;
    private String email;
    /**
     * @return the message
     */
    public String getMessage() {
	return message;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setMessage(String message) {
	this.message = message;
    }

    /**
     * @return the email
     */
    public String getEmail() {
	return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
	this.email = email;
    }



    /**
     * @param message
     * @param email
     * @param requestSite
     */
    public UserDeveloperNotFoundException(String message, String email)
    {
	super();
	this.message = message;
	this.email = email;
    }


}
