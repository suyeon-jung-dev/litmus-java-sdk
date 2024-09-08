package io.litmuschaos.auth.model;

public class ApiToken {
    private final String userId;
    private final String name;
    private final String token;
    private final Integer expiresAt;
    private final Integer createdAt;

    private ApiToken(Builder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.token = builder.token;
        this.expiresAt = builder.expiresAt;
        this.createdAt = builder.createdAt;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }

    public Integer getExpiresAt() {
        return expiresAt;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public static class Builder {
        private String userId;
        private String name;
        private String token;
        private Integer expiresAt;
        private Integer createdAt;

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder expiresAt(Integer expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }

        public Builder createdAt(Integer createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public ApiToken build() {
            return new ApiToken(this);
        }
    }
}