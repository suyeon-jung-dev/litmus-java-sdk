package io.litmuschaos.auth.response;

public class PasswordUpdateResponse {

    private String message;

    private String projectId;

    public PasswordUpdateResponse(String message, String projectId) {
        this.message = message;
        this.projectId = projectId;
    }

    public String getMessage() {
        return message;
    }

    public String getProjectId() {
        return projectId;
    }
}
