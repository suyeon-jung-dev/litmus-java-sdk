package io.litmuschaos.auth.response;

public class LoginResponse {

    private String accessToken;
    private String expiresIn;
    private String type;

    public LoginResponse(String accessToken, String expiresIn, String projectID, String projectRole, String type) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.type = type;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public String getType() {
        return type;
    }
}
