package BackendSpring.security.domain;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jayway.jsonpath.Option;

import BackendSpring.developer.domain.Developer;



//Sends general information about the person logged in
public class CurrentUserDTO
{

 

    private Developer developer = null;
    private String email = "";
    private boolean isLoggedIn = false;

    /**
     * @param customer
     * @param email
     * @param isLoggedIn
     */
    public CurrentUserDTO(Developer developer, String email, boolean isLoggedIn)
    {
	super();
	this.developer = developer;
	this.email = email;
	this.isLoggedIn = isLoggedIn;
    }


    /**
     * @return the customer
     */
    public Developer getDeveloper()
    {
	return developer;
    }

    /**
     * @param customer
     *            the customer to set
     */
    public void setDeveloper(Developer developer)
    {
	this.developer = developer;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
	return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email)
    {
	this.email = email;
    }

    /**
     * @return the isLoggedIn
     */
    public boolean isLoggedIn()
    {
	return isLoggedIn;
    }

    /**
     * @param isLoggedIn
     *            the isLoggedIn to set
     */
    public void setLoggedIn(boolean isLoggedIn)
    {
	this.isLoggedIn = isLoggedIn;
    }

}
