package io.litmuschaos.auth.request;

public class UserUpdateRequest {

    private final String name;
    private final String email;

    private UserUpdateRequest(UserUpdateRequest.Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
    }

    public String getUsername() {
        return name;
    }

    public String getNewPassword() {
        return email;
    }

    public static class Builder {
        private String name;
        private String email;

        public Builder() {}

        public UserUpdateRequest.Builder name(String name) {
            this.name = name;
            return this;
        }

        public UserUpdateRequest.Builder email(String email) {
            this.email = email;
            return this;
        }

        public UserUpdateRequest build() {
            return new UserUpdateRequest(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
