package BackendSpring.security.jwt;

import org.springframework.stereotype.Component;

@Component
public class JwtProperties {
    
    private String JwtHeader = "Authorization";
    private String JwtSchema = "Bearer ";
    private String JwtSecret = "1995";
    private int validHours = 24;
    /**
     * @return the jwtHeader
     */
    public String getJwtHeader() {
        return JwtHeader;
    }
    /**
     * @param jwtHeader the jwtHeader to set
     */
    public void setJwtHeader(String jwtHeader) {
        JwtHeader = jwtHeader;
    }
    /**
     * @return the jwtSchema
     */
    public String getJwtSchema() {
        return JwtSchema;
    }
    /**
     * @param jwtSchema the jwtSchema to set
     */
    public void setJwtSchema(String jwtSchema) {
        JwtSchema = jwtSchema;
    }
    /**
     * @return the jwtSecret
     */
    public String getJwtSecret() {
        return JwtSecret;
    }
    /**
     * @param jwtSecret the jwtSecret to set
     */
    public void setJwtSecret(String jwtSecret) {
        JwtSecret = jwtSecret;
    }
    /**
     * @return the validHours
     */
    public int getValidHours() {
        return validHours;
    }
    /**
     * @param validHours the validHours to set
     */
    public void setValidHours(int validHours) {
        this.validHours = validHours;
    }

}
