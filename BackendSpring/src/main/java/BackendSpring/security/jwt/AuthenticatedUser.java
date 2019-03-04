package BackendSpring.security.jwt;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import BackendSpring.security.domain.User;

public class AuthenticatedUser extends org.springframework.security.core.userdetails.User {

    private User user;

    private String token;

    public AuthenticatedUser(User parsedUser, String token, List<GrantedAuthority> authorityList) {
	super(parsedUser.getEmail(), parsedUser.getPasswordHash(), authorityList);
	user = parsedUser;
	this.token = token;
    }

    public User getUser() {
	return user;
    }

    public Long getId() {
	return user.getId();
    }

    public String getNickname() {
	return user.getUserName();
    }

    public String getEmail() {
	return user.getEmail();
    }

    @Override
    public String toString() {
	return "CurrentUser{" + "user=" + user + "getNickname=" + user.getUserName() + "} " + super.toString();
    }

}
