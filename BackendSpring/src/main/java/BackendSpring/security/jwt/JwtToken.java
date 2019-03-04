package BackendSpring.security.jwt;

public class JwtToken {

    private String error;

    private String token;

    public JwtToken() {
    }

    public JwtToken(String token) {
        this.token = token;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}